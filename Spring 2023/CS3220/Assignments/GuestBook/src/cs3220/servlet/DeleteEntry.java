package cs3220.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;
import cs3220.utilities.ServletUtilities;

@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DeleteEntry()
    {
        super();
    }

    @SuppressWarnings("unchecked")
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	List<GuestBookEntry> entries = ServletUtilities.getGuestBookEntresFromServletContext(getServletContext());
        GuestBookEntry entry = ServletUtilities.getEntry(entries, ServletUtilities.getInt(request.getParameter( "id" )));
        
        if( entry != null ) entries.remove( entry );
        
        response.sendRedirect( "GuestBook" );
    }
}
