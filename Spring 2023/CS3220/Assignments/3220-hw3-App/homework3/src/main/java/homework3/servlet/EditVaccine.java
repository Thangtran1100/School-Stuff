package homework3.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework3.model.VaccineEntry;
import homework3.utilities.DatabaseConnector;

/**
 * Servlet implementation class EditVaccine
 */
@WebServlet("/EditVaccine")
public class EditVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DatabaseConnector databaseConnector = new DatabaseConnector();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVaccine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		int vaccineId = Integer.parseInt(request.getParameter("id"));

		VaccineEntry vaccineEntry = databaseConnector.getVaccineEntry(vaccineId);
	
		request.setAttribute("vaccineEntry", vaccineEntry);
		request.getRequestDispatcher("EditVaccine.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String vaccine = request.getParameter( "name" );
        int doses = Integer.parseInt(request.getParameter( "dose" ));
        int days = Integer.parseInt(request.getParameter( "days" ));

        try {
        	databaseConnector.updateVaccineInfo(vaccine, doses, days);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        response.sendRedirect( "ListVaccine" );
        
	}

}
