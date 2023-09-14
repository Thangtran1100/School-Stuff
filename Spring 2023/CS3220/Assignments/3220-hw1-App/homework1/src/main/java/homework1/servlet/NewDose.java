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
 * Servlet implementation class NewDose
 */
@WebServlet("/NewDose")
public class NewDose extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		StringBuilder html = new StringBuilder();
		
		List<VaccineEntry> entries = ServletUtilities.getVaccineEntresFromServletContext(getServletContext());
	
		html.append("<table border='1' cellpadding= '5'><form action='NewDose' method='post'>");
		
		html.append("<tr>");
		html.append("<th><label>Doses Required</label></th>");
		html.append("<td><select name='dose'>");
		
		for( VaccineEntry entry : entries )
		{
            html.append( "<option value ='" + entry.getVaccine() + "'>" + entry.getVaccine() + "</option>" );
        }
		
		html.append("</select></td>");
		html.append("</tr>");
		
		html.append("<tr>");
		html.append("<th><label>New Doses Received</label></th>");
		html.append("<td><input type='text' name='newDose'></td>");
		html.append("</tr>");
		
		html.append("<tr>");
		html.append("<td colspan='2'><input type='submit' value='Add'></td>");
		html.append("</tr>");
		
		html.append("</form></table>");
		
		out.println( ServletUtilities.titleWithBody("NewDose", html.toString()) );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vaccine = request.getParameter( "dose" );
        String dosesReceived = request.getParameter( "newDose" );

        List<VaccineEntry> entries = ServletUtilities.getVaccineEntresFromServletContext(getServletContext());
        
        for( VaccineEntry entry : entries )
        {
        	if(vaccine.equals(entry.getVaccine()))
        	{
        		entry.setTotalDoseReceived(String.valueOf(Integer.parseInt(entry.getTotalDoseReceived())+ Integer.parseInt(dosesReceived)));
        		entry.setTotalDoseLeft(String.valueOf(Integer.parseInt(entry.getTotalDoseLeft())+ Integer.parseInt(dosesReceived)));
        	}
        }


        response.sendRedirect( "ListVaccine" );

	}

}
