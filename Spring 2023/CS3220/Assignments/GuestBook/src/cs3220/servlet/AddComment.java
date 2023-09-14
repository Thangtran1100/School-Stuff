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

@WebServlet("/AddComment")
public class AddComment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddComment()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	StringBuilder html = new StringBuilder();
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        
        html.append( "<form action='AddComment' method='post'>" );
        html.append( "Name: <input type='text' name='name'><br>" );
        html.append( "<textarea name='message' rows='6' cols='40'></textarea><br>" );
        html.append( "<button type='submit'>Add Comment</button></form>" );
        
        out.println( ServletUtilities.titleWithBody("GuestBook", html.toString()) );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String name = request.getParameter( "name" );
        String message = request.getParameter( "message" );
        GuestBookEntry entry = new GuestBookEntry( name, message );

        List<GuestBookEntry> entries = ServletUtilities.getGuestBookEntresFromServletContext(getServletContext());
        entries.add( entry );

        response.sendRedirect( "GuestBook" );
    }

}
