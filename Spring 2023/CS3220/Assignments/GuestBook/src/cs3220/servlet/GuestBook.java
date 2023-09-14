package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;
import cs3220.utilities.*;

@WebServlet(urlPatterns = "/GuestBook", loadOnStartup = 1)
public class GuestBook extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public GuestBook()
    {
        super();
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
        entries.add( new GuestBookEntry( "John", "Hello!" ) );
        entries.add( new GuestBookEntry( "Jane", "Nice site!" ) );

        getServletContext().setAttribute( ServletUtilities.GuestBookEntresKey, entries );
    }

    @SuppressWarnings("unchecked")
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	StringBuilder html = new StringBuilder();
    	List<GuestBookEntry> entries = ServletUtilities.getGuestBookEntresFromServletContext(getServletContext());

        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();

        html.append( "<h2>Guest Book</h2>" );
        
        html.append("<table border='1'>");
        
        for( GuestBookEntry entry : entries )
        {
            html.append("<tr>");
            html.append( "<td>" + entry.getName() + " says</td>" );
            html.append( "<td>" + entry.getMessage() + "</td>" );
            
            html.append( "<td><a href='EditEntry?fname=frank&id=" + entry.getId() + "'>Edit</a> |"  );
            
            html.append( "<a href='DeleteEntry?id=" + entry.getId() + "'>Delete</a>" );
            
            html.append( "</td>" );
            html.append( "</tr>" );
        }
        html.append( "</table>" );
        
        html.append( "<p><a href='AddComment'>Add Comment</a></p>" );
        
        out.println( ServletUtilities.titleWithBody("GuestBook", html.toString()) );
    }

}
