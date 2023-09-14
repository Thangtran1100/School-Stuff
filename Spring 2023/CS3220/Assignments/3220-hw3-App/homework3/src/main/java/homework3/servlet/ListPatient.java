package homework3.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import homework3.model.PatientViewModel;
import homework3.utilities.DatabaseConnector;

/**
 * Servlet implementation class ListPatient
 */
@WebServlet("/ListPatient")
public class ListPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private DatabaseConnector databaseConnector = new DatabaseConnector();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


List<PatientViewModel> patientEntries = databaseConnector.getPatientEntries();
		
		getServletContext().setAttribute("patientEntries", patientEntries);
		
        request.getRequestDispatcher("ListPatient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		String vaccineName = request.getParameter("vaccineName");
		
		try {
        	databaseConnector.updateVaccineReceivedInfo(patientId, vaccineName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    doGet(request, response);
	}

}
