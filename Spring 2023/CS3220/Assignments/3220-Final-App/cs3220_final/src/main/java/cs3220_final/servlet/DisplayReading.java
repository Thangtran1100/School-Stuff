package cs3220_final.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220_final.model.ReadingEntry;
import cs3220_final.model.UserEntry;
import cs3220_final.utilities.DatabaseConnector;

/**
 * Servlet implementation class DisplayReading
 */
@WebServlet("/DisplayReading")
public class DisplayReading extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DatabaseConnector databaseConnector = new DatabaseConnector();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayReading() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ReadingEntry> readings = databaseConnector.getReadingEntries();
		List<UserEntry> users = databaseConnector.getUserEntries();
		
		getServletContext().setAttribute("readings", readings);
		getServletContext().setAttribute("users", users);

		request.getRequestDispatcher("DisplayReading.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
