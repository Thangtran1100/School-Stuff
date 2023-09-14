package cs3220.utilities;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import cs3220.model.GuestBookEntry;

public class ServletUtilities {
	
	public static final String GuestBookEntresKey = "entries";
	public static final String DOCTYPE =
			"<!DOCTYPE HTML>";
	
	public static String headWithTitle(String title) {
		return(
				DOCTYPE + "\n" +
						"<HTML>\n" +
						"<HEAD><TITLE>" + title + "</TITLE></HEAD>\n");
	}
	
	public static String titleWithBody(String title, String body) {
		return (headWithTitle(title) + "<BODY>" + body + "</BODY>\n" + "</HTML>\n");
	}
	
	public static int getInt(String str){
		try {
			int val = str == null || str.trim().length() == 0 ? 0
		            : Integer.parseInt( str );
			return val;
		}catch(Exception ex) { }
		return 0;
   }
	
	public static GuestBookEntry getEntry(List<GuestBookEntry> entries, int id){
		GuestBookEntry entry = null;
		for( var e : entries )
            if( e.getId() == id )
            {
                entry = e;
                break;
            }
		return entry;
   }
	
	public static List<GuestBookEntry> getGuestBookEntresFromServletContext(ServletContext context){
		var obj = context.getAttribute( GuestBookEntresKey );
		if (obj == null) return new ArrayList<GuestBookEntry>();
		try {
			return (List<GuestBookEntry>) obj;
		}catch(Exception ex) { return new ArrayList<GuestBookEntry>(); }
   }

}
