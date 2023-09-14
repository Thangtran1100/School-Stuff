package homework3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework3.utilities.DatabaseConnector;

/**
 * Servlet implementation class NewDose
 */
@WebServlet("/NewDose")
public class NewDose extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DatabaseConnector databaseConnector = new DatabaseConnector();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDose() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("NewDose.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String vaccine = request.getParameter("dose");
        int dosesReceived = Integer.parseInt(request.getParameter("newDose"));

        try {
        	databaseConnector.addVaccineDose(vaccine, dosesReceived);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.sendRedirect("ListVaccine");
        
        
	}

}
