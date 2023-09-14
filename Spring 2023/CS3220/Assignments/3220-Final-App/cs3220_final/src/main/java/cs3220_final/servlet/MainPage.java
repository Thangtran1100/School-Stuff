package cs3220_final.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220_final.model.UserEntry;
import cs3220_final.utilities.DatabaseConnector;

/**
 * Servlet implementation class MainPage
 */
@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DatabaseConnector databaseConnector = new DatabaseConnector();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<UserEntry> users = databaseConnector.getUserEntries();
		
		getServletContext().setAttribute("users", users);

		request.getRequestDispatcher("MainPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");

		request.setAttribute("userId", userId);
        request.getRequestDispatcher("DisplayReading").forward(request, response);
	}

}
