package cs3220final.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddTask")
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddTask() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		request.getRequestDispatcher( "/WEB-INF/AddTask.jsp" )
        .forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		String detail = request.getParameter("detail");
		
		Connection c = null;
        try {
        	
        	String username = "cs3220stu94";
        	String password = "Nw9Vex4Y33Hh";
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu94";
            
            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            
            String sql = "insert into tasks (task, detail) values ('" 
                	+ task + "', '" + detail + "')";
            stmt.executeUpdate(sql);
            
        } catch (SQLException e) {
        	throw new ServletException(e);
		} finally {
			try {
                if (c != null) c.close();
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        

		response.sendRedirect("TaskManagement");
	}

}
