package lab13.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lab13.model.Department;
import lab13.model.Faculty;

public class DbService {

    private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu102";

    private String username = "cs3220stu102";

    private String password = "1UYGIY3ru0Vy";

    private Connection connection;

    public DbService()
    {
        try
        {
            connection = DriverManager.getConnection( url, username, password );
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        if( connection != null )
        {
            try
            {
                connection.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }

    
    public List<Department> getDepartmentEntries()
    {
        List<Department> entries = new ArrayList<Department>();

        try
        {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "select d.id as department_id, d.name as department_name, f.name as faculty_name, f.chair as faculty_chair " +
                                            "from departments as d " +
                                            "left join faculty as f on d.id = f.department_id" );
            Department entry = null;
            while( rs.next() )
            {
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                String facultyName = rs.getString("faculty_name");
                boolean facultyChair = rs.getBoolean("faculty_chair");

                // If a new department is encountered, create a new Department object
                if (entry == null || entry.getDepartmentId() != departmentId) {
                    entry = new Department();
                    entry.setDepartmentId(departmentId);
                    entry.setName(departmentName);
                    entry.setFaculty(new ArrayList<>());
                    entries.add(entry);
                }

                // If faculty information is available, add it to the current department
                if (facultyName != null) {
                    Faculty faculty = new Faculty();
                    faculty.setName(facultyName);
                    faculty.setChair(facultyChair);
                    entry.getFaculty().add(faculty);
                }
            }
            stmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }

        return entries;
    }

    

    public Department getDepartmentEntry( int id )
    {
    	Department entry = new Department();
        try
        {
            String sql = "select * from departments where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();
            if( rs.next() )
            {
                entry.setName( rs.getString( "name" ) );
            }
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        return entry;
    }
    
    public int addDepartmentEntry(String departmentName) throws ClassNotFoundException
    {
    	
    	int id = 0;
        
        try
        {
        	String INSERT_DEPARTMENT_SQL = "insert into departments (name) values (?);";
     
            PreparedStatement preparedStatement = connection.prepareStatement( INSERT_DEPARTMENT_SQL, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString( 1, departmentName);
            
            preparedStatement.executeUpdate();
            
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if( rs.next() ) id = rs.getInt( 1 );
            preparedStatement.close();
         
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        
        return id;

    }
    
    public int addFacultyEntry(int departmentId, Faculty faculty) throws ClassNotFoundException
    {
    	int id = 0;
        
        try
        {
        	
        	String INSERT_FACULTY_SQL = "insert into faculty (name, chair, department_id) values (?,?,?);";
     
            PreparedStatement preparedStatement = connection.prepareStatement( INSERT_FACULTY_SQL, Statement.RETURN_GENERATED_KEYS);
            
            preparedStatement.setString( 1, faculty.getName());
            preparedStatement.setBoolean( 2, faculty.isChair());
            preparedStatement.setInt( 3, departmentId);
            
            preparedStatement.executeUpdate();
            
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
        
        return id;
    }

    public void updateDepartmentEntry( int id, String name)
    {
        try
        {
            String sql = "update guestbook set name = ? where id = ?";
            PreparedStatement pstmt = connection.prepareStatement( sql );
            pstmt.setString( 1, name );
            pstmt.setInt( 2, id );
            pstmt.executeUpdate();
            pstmt.close();
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }

    
}
