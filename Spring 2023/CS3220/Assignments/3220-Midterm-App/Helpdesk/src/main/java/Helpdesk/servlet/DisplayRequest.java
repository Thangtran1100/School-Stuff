package Helpdesk.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HelpdeskEntry;

/**
 * Servlet implementation class DisplayRequest
 */
@WebServlet("/DisplayRequest")
public class DisplayRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        
        List<HelpdeskEntry> entries = new ArrayList<HelpdeskEntry>();
        
        entries.add( new HelpdeskEntry( "2022-10-27 11:30 AM", "John Doe", "Computers", "Completed", "Amy" ) );
        entries.add( new HelpdeskEntry( "2022-10-27 1:30 PM", "Jane Doe", "Video Games", "Created", "" ) );
        entries.add( new HelpdeskEntry( "2022-10-27 3:00 PM", "Jack Smith", "Appliances", "Assinged", "Bob" ) );
        entries.add( new HelpdeskEntry( "2022-10-27 3:00 PM", "Jack Smith", "Movies", "Assinged", "Amy" ) );

        getServletContext().setAttribute( "entries", entries );
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("DisplayRequest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
