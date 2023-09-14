package homework2.servlet;

import java.io.IOException;
import java.time.LocalDate;
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

/**
 * Servlet implementation class MainPage
 */
@WebServlet(urlPatterns = "/MainPage", loadOnStartup = 1)
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        
        List<VaccineEntry> entries = new ArrayList<VaccineEntry>();
        ArrayList<PatientEntry> patientEntries = new ArrayList<PatientEntry>();
        
        entries.add( new VaccineEntry( "Pfizer/BioNTech", "2", "21", 10000, 10000 ) );
        entries.add( new VaccineEntry( "Johnson & Johnson", "1", "",5000, 5000 ) );
        entries.add( new VaccineEntry( "Moderna", "2", "28",0, 0) );

        getServletContext().setAttribute( "entries", entries );
        
        patientEntries.add( new PatientEntry("John Doe","Pfizer/BioNTech" , "02/18/2021", "03/11/2021"));
	    patientEntries.add( new PatientEntry( "Jane Doe", "Pfizer/BioNTech", "02/18/2021", ""));
	    patientEntries.add( new PatientEntry( "Tom Smith", "Johnson & Johnson", "03/12/2021", ""));
	    patientEntries.add( new PatientEntry( "Jim Lee", "Moderna", "03/12/2021", ""));
	    
	    for(PatientEntry patientEntry : patientEntries) {
	        
	        	for (VaccineEntry vaccineEntry : entries) {
		            if (vaccineEntry.getVaccineName().equals(patientEntry.getVaccineName()) && vaccineEntry.getTotalDoseLeft() > 0) {
		            	
		                vaccineEntry.decrementDose();
		                if(!patientEntry.getSecondDoseDate().equals("")) {
		                	vaccineEntry.decrementDose();
		                }
		               
		            }
		        }
	        
	    }
	    
	    getServletContext().setAttribute( "patientEntries", patientEntries );
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("MainPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
