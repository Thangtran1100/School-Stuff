package lab13.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab13.model.Department;
import lab13.model.Faculty;
import lab13.service.DbService;

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private DbService dbService = new DbService();

    public AddFaculty()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "AddFaculty.jsp" )
            .forward( request, response );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        
    	int departmentId = Integer.parseInt(request.getParameter( "department" ));
        Faculty faculty = new Faculty( request.getParameter( "faculty" ) );
        if( request.getParameter( "chair" ) != null ) faculty.setChair( true );

        try {
			dbService.addFacultyEntry(departmentId, faculty);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

        response.sendRedirect( "DisplayFaculty" );
    }

}