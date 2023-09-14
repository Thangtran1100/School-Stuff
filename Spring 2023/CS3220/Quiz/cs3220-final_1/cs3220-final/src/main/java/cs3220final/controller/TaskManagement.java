package cs3220final.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220final.model.Task;
import cs3220final.model.User;

@WebServlet(urlPatterns = "/TaskManagement", loadOnStartup = 1)
public class TaskManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TaskManagement() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Task> taskEntries = new ArrayList<Task>();
		List<User> userEntries = new ArrayList<User>();
		
		Connection c = null;
        try {
        	
        	String username = "cs3220stu94";
        	String password = "Nw9Vex4Y33Hh";
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu94";
            String sql1 = "select * from users";
            String sql2 = "select * from tasks";
            
            c = DriverManager.getConnection( url, username, password );
            Statement stmt1 = c.createStatement();
            Statement stmt2 = c.createStatement();
            
            ResultSet rs1 = stmt1.executeQuery(sql1);
            
            while (rs1.next()) {
            	User newUser = new User();
            	
            	newUser.setId(rs1.getInt("id"));
            	newUser.setName(rs1.getString("name"));
            	
            	userEntries.add(newUser);
            }
            
            ResultSet rs2 = stmt2.executeQuery(sql2);
            
            while (rs2.next()) {
            	Task newTask = new Task();
            	
            	newTask.setId(rs2.getInt("id"));
            	newTask.setTask(rs2.getString("task"));
            	newTask.setDetail(rs2.getString("detail"));
            	newTask.setStatus(rs2.getString("status"));
            	newTask.setUserId(rs2.getInt("user_id"));
            	
            	taskEntries.add(newTask);
            }
            
        } catch(SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (c != null) c.close();
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        
        request.setAttribute("userEntries", userEntries);
        request.setAttribute("taskEntries", taskEntries);
		request.getRequestDispatcher( "/WEB-INF/TaskManagement.jsp" )
			.forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}