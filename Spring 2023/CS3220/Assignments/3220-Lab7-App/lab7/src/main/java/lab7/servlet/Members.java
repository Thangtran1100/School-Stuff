package lab7.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Members
 */
@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Members() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Get session
	    HttpSession session = request.getSession();

	    // Check if session attribute user is set
	    String user = (String) session.getAttribute("user");
	    if (user != null) 
	    {
	      // User is authenticated, display welcome message and logout link
	      response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      out.println("<html><body>");
	      out.println("<h1>Welcome to the Members Area</h1>");
	      out.println("<a href='Logout'>Logout</a>");
	      out.println("</body></html>");
	    } 
	    else 
	    {
	      // User is not authenticated, redirect to login
	      response.sendRedirect("Login");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
