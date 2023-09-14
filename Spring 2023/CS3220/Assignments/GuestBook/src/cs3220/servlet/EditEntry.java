package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;
import cs3220.utilities.ServletUtilities;

@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public EditEntry()
    {
        super();
    }

    @SuppressWarnings("unchecked")
    private GuestBookEntry getEntry( int id )
    {
        List<GuestBookEntry> entries = (List<GuestBookEntry>) getServletContext()
            .getAttribute( "entries" );
        
        
        for( GuestBookEntry entry : entries )
            if( entry.getId() == id ) return entry;
        return null;
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	StringBuilder html = new StringBuilder();
    	
        String id = request.getParameter( "id" );
        String fname = request.getParameter( "fname" );
        
        GuestBookEntry entry = getEntry( Integer.parseInt( id ) );

        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        
        html.append( "<form action='EditEntry' method='post'>" );
        
        html.append( "<input type='hidden' name='id' value='" + id + "'>" );
        html.append( "Name: <input type='text' name='name' value='" + entry.getName() + "'><br>" );
        html.append( "<textarea name='message' rows='6' cols='40'>" + entry.getMessage() + "</textarea><br>" );
        
        html.append( "<button type='submit'>Save</button></form>" );
        
        out.println( ServletUtilities.titleWithBody("GuestBook", html.toString()) );
        
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	var idStr = request.getParameter( "id" );
    	var id = ServletUtilities.getInt(idStr);
        List<GuestBookEntry> entries = ServletUtilities.getGuestBookEntresFromServletContext(getServletContext());
        GuestBookEntry entry = ServletUtilities.getEntry(entries, id);
        
        entry.setName( request.getParameter( "name" ) );
        entry.setMessage( request.getParameter( "message" ) );
        
        response.sendRedirect( "GuestBook" );
    }
}
