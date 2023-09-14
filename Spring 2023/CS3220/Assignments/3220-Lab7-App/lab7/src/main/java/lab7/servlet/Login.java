package lab7.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private boolean userValid(String username, String password) 
	{
		  // Array of string arrays holding credentials login
		  String[][] validUser = {
		    {"cysun", "abcd"},
		    {"stu102", "123456"},
		    {"cs3220stu102", "incoming"}
		  };

		  // Check if username and password match valid user
		  for (String[] user : validUser) 
		  {
		    if (user[0].equals(username) && user[1].equals(password)) 
		    {
		      return true;
		    }
		  }

		  return false;
		}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<form method ='post'>");
		out.println("<label>Username:</label>");
		out.println("<input type='text' name='username'><br><br>");
		out.println("<label>Password:</label>");
		out.println("<input type='text' name='password'><br><br>");
		out.println("<input type='submit' value='Login'>");
		out.println("</form>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		if(userValid(username, password))
		{
			session.setAttribute("user", username);
			response.sendRedirect("Members");
		}
		else
		{
			response.sendRedirect("Login");
		}
	}

}
