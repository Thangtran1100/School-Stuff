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
 * Servlet implementation class NewVaccine
 */
@WebServlet("/NewVaccine")
public class NewVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewVaccine() {
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
	
		html.append("<table border='1' cellpadding= '5'><form action='NewVaccine' method='post'>");
		
		html.append("<tr>");
		html.append("<th><label>Name</label></th>");
		html.append("<td><input type='text' name='name'></td>");
		html.append("</tr>");
		
		html.append("<tr>");
		html.append("<th><label>Doses Required</label></th>");
		html.append("<td><select name='dose'>");
		html.append("<option value='0'>0</option>");
		html.append("<option value='1'>1</option>");
		html.append("<option value='2'>2</option>");
		html.append("</select></td>");
		html.append("</tr>");
		
		html.append("<tr>");
		html.append("<th><label>Days Between Doses</label></th>");
		html.append("<td><input type='text' name='days'></td>");
		html.append("</tr>");
		
		html.append("<tr>");
		html.append("<td colspan='2'><input type='submit' value='Add'></td>");
		html.append("</tr>");
		
		html.append("</form></table>");
		
		out.println( ServletUtilities.titleWithBody("NewVaccine", html.toString()) );
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
        entries.add( new VaccineEntry( vaccine, doses, days, "0", "0" ));


        response.sendRedirect( "ListVaccine" );

	}

}
