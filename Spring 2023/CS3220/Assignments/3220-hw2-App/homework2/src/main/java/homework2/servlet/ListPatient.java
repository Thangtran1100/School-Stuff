package homework2.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PatientEntry;
import model.VaccineEntry;
import utilities.ServletUtilities;

/**
 * Servlet implementation class ListPatient
 */
@WebServlet("/ListPatient")
public class ListPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       

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
		List<PatientEntry> patientEntries = (List<PatientEntry>) getServletContext().getAttribute("patientEntries");
		request.setAttribute("patientEntries", patientEntries);
        request.getRequestDispatcher("ListPatient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int patientId = Integer.parseInt(request.getParameter("patientId"));
		String vaccineName = request.getParameter("vaccineName");
		
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	 // Get the patient entries and vaccine entries from the application context
	    List<PatientEntry> patientEntries = (List<PatientEntry>) getServletContext().getAttribute("patientEntries");
	    List<VaccineEntry> vaccineEntries = (List<VaccineEntry>) getServletContext().getAttribute("entries");

	    // Decrement the stock of the vaccine by 1 if vaccineEntries is not null
	    for(PatientEntry patientEntry : patientEntries) {
	        if(patientEntry.getPatientId() == patientId) {
	        	for (VaccineEntry vaccineEntry : vaccineEntries) {
		            if (vaccineEntry.getVaccineName().equals(vaccineName)) {
		            	patientEntry.setSecondDoseDate(formatDate.format(LocalDate.now()));
		                vaccineEntry.decrementDose();
		                break;
		            }
		        }
	        }
	    }
	    
	    doGet(request, response);
	}

}
