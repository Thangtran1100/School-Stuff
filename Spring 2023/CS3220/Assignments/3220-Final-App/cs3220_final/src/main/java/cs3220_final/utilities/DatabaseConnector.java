package cs3220_final.utilities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import cs3220_final.model.ReadingEntry;
import cs3220_final.model.UserEntry;

public class DatabaseConnector {

	private String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu102";

	private String username = "cs3220stu102";

	private String password = "1UYGIY3ru0Vy";

	private Connection connection;

	public DatabaseConnector() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<UserEntry> getUserEntries() {
		List<UserEntry> entries = new ArrayList<UserEntry>();


		
		try {
			Statement stmt = connection.createStatement();
			
		
			
			ResultSet rs = stmt.executeQuery("select * from users");
			UserEntry entry = null;
			while (rs.next()) {
				int userId = rs.getInt("id");
				String userName = rs.getString("name");
			
				
				
				// If a new user is encountered, create a new user object
				if (entry == null || entry.getId() != userId) {
					entry = new UserEntry();
					entry.setId(userId);
					entry.setName(userName);
			
					entries.add(entry);
				}
				
				

			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return entries;
	}

	public UserEntry getUserEntry(int id) {
		UserEntry entry = new UserEntry();

		try {
			String sql = "select * from users where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entry.setId(rs.getInt("id"));
				entry.setName(rs.getString("name"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entry;
	}

	
	
	public List<ReadingEntry> getReadingEntries() {
		List<ReadingEntry> entries = new ArrayList<ReadingEntry>();
		
		int id =0;

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from readings;");
			
			ReadingEntry readingEntry = null;
			
			while (rs.next()) {
				int readingId = rs.getInt("id");
				int systolic = rs.getInt("systolic");
				int diastolic = rs.getInt("diastolic");
				int userId = rs.getInt("user_id");
				String time = rs.getString("time");
				
				

				// If a new reading is encountered, create a new reading object
				if (readingEntry == null || readingEntry.getUser_id() != userId) {
					readingEntry = new ReadingEntry();
					readingEntry.setId(readingId);
					readingEntry.setSystolic(systolic);
					readingEntry.setDiastolic(diastolic);
					readingEntry.setUser_id(userId);
					readingEntry.setTime(time);
					
					
	
					entries.add(readingEntry);
				}
				
			}

			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return entries;
	}
	
	public ReadingEntry getReadingEntry(int id) {
		ReadingEntry entry = new ReadingEntry();

		try {
			String sql = "select * from readings where p.id = ?;";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entry.setId(rs.getInt("id"));
				entry.setSystolic(rs.getInt("systolic"));
				entry.setDiastolic(rs.getInt("diastolic"));
				entry.setUser_id(rs.getInt("user_id"));
				entry.setTime(rs.getString("time"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entry;
	}
	
	public int addReadingEntry(int systolic, int diastolic, int userId)
			throws ClassNotFoundException {

		int id = 0;
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mmaa");
    	String time = dateFormat.format(LocalDate.now()).toString();

		try {
			String INSERT_VACCINES_SQL = "insert into readings (systolic, diastolic, user_id, time) values (?,?,?,?);";

			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VACCINES_SQL,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, systolic);
			preparedStatement.setInt(2, diastolic);
			preparedStatement.setInt(3, userId);
			preparedStatement.setString(4, time);

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next())
				id = rs.getInt(1);
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;

	}




	
	

}