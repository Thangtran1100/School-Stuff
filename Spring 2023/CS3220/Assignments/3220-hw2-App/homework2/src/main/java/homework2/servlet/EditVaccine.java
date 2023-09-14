package homework2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VaccineEntry;
import utilities.ServletUtilities;

/**
 * Servlet implementation class EditVaccine
 */
@WebServlet("/EditVaccine")
public class EditVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		List<VaccineEntry> entries = ServletUtilities.getVaccineEntresFromServletContext(getServletContext());
		
		int vaccineId = Integer.parseInt(request.getParameter("id"));

		VaccineEntry vaccineEntry = null;
		
		for(VaccineEntry entry : entries)
		{
			if(entry.getVaccineId() == vaccineId)
			{
				vaccineEntry = entry;
				break;
			}
		}
	
		request.setAttribute("vaccineEntry", vaccineEntry);
		request.getRequestDispatcher("EditVaccine.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String vaccine = request.getParameter( "name" );
        String doses = request.getParameter( "dose" );
        String days = request.getParameter( "days" );

        List<VaccineEntry> entries = ServletUtilities.getVaccineEntresFromServletContext(getServletContext());
        
        
        for( VaccineEntry entry : entries )
        {
        	if(vaccine.equals(entry.getVaccineName()))
        	{
        		entry.setDoseRequired(doses);
        		entry.setDaysBetweenDose(days);
        	}
        }


        response.sendRedirect( "ListVaccine" );

	}

}
