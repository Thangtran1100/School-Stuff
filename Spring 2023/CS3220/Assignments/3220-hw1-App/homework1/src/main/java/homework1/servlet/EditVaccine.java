package homework1.servlet;

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
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		StringBuilder html = new StringBuilder();
		
		List<VaccineEntry> entries = ServletUtilities.getVaccineEntresFromServletContext(getServletContext());
		
		int vaccineId = Integer.parseInt(request.getParameter("id"));

		VaccineEntry vaccineEntry = null;
		
		for(VaccineEntry entry : entries)
		{
			if(entry.getId() == vaccineId)
			{
				vaccineEntry = entry;
				break;
			}
		}
	
		html.append("<table border='1' cellpadding= '5'><form action='EditVaccine' method='post'");
		
		html.append("<tr>");
		html.append("<th><label>Name</label></th>");
		html.append("<td><input type='text' name='name' value='" + vaccineEntry.getVaccine() + "'></td>");
		html.append("</tr>");
		
		html.append("<tr>");
		html.append("<th><label>Doses Required</label></th>");
		html.append("<td><select name='dose'>");
		
		for (int index = 1; index < 3; index++) {
			if (index == Integer.parseInt(vaccineEntry.getDoseRequired())) {
			    html.append("<option value='" + index + "' selected>" + index + "</option>");
			} else {
			    html.append("<option value='" + index + "'>" + index + "</option>");
			}
	    }
		
		html.append("</select></td>");
		html.append("</tr>");
		
		html.append("<tr>");
		html.append("<th><label>Days Between Doses</label></th>");
		html.append("<td><input type='text' name='days'></td>");
		html.append("</tr>");
		
		html.append("<tr>");
		html.append("<td colspan='2'><input type='submit' value='Save'></td>");
		html.append("</tr>");
		
		html.append("</form></table>");
		
		out.println( ServletUtilities.titleWithBody("EditVaccine", html.toString()) );

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
        	if(vaccine.equals(entry.getVaccine()))
        	{
        		entry.setDoseRequired(doses);
        		entry.setDaysBetweenDose(days);
        	}
        }


        response.sendRedirect( "ListVaccine" );

	}

}
