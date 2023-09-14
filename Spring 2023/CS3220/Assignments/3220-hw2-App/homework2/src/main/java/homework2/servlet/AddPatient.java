package homework2.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class AddPatient
 */
@WebServlet("/AddPatient")
public class AddPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPatient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Get list of available vaccines from the application scope
		List<VaccineEntry> vaccines = (List<VaccineEntry>) getServletContext().getAttribute("entries");

		// Create a list of vaccine names for the dropdown menu
		List<String> vaccineNames = new ArrayList<String>();
		for (VaccineEntry vaccine : vaccines) {
			if (vaccine.getTotalDoseLeft() > 0) {
				vaccineNames.add(vaccine.getVaccineName());
			}
		}

		// Add the list of vaccine names to the request
		request.setAttribute("vaccineNames", vaccineNames);

		request.getRequestDispatcher("AddPatient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patientName = request.getParameter("patient");
		String vaccineName = request.getParameter("vaccine");

		LocalDate currDate = LocalDate.now();

		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// Get the list of vaccines from the application scope
		List<VaccineEntry> vaccines = (List<VaccineEntry>) getServletContext().getAttribute("entries");

		// Find the selected vaccine in the list
		VaccineEntry selectedVaccine = null;
		for (VaccineEntry vaccine : vaccines) {
			if (vaccine.getVaccineName().equals(vaccineName)) {
				selectedVaccine = vaccine;
				break;
			}
		}

		// Decrement the stock of the selected vaccine by 1
		selectedVaccine.decrementDose();

		// Set the date of the first dose to the current date
		String firstDoseDate = formatDate.format(currDate);

		// Create a new patient entry and add it to the list of patients
		PatientEntry patient = new PatientEntry(patientName, vaccineName, firstDoseDate, "");
		List<PatientEntry> patientEntries = (List<PatientEntry>) getServletContext().getAttribute("patientEntries");
		patientEntries.add(patient);

		getServletContext().setAttribute("patientEntries", patientEntries);

		response.sendRedirect("ListPatient");
	}

}
