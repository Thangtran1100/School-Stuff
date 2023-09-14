package utilities;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import model.PatientEntry;
import model.VaccineEntry;

public class ServletUtilities {
	
	public static final String VaccineEntresKey = "entries";
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
	
	public static VaccineEntry getEntry(List<VaccineEntry> entries, int id){
		VaccineEntry entry = null;
		for( var e : entries )
            if( e.getVaccineId() == id )
            {
                entry = e;
                break;
            }
		return entry;
   }
	
	public static List<VaccineEntry> getVaccineEntresFromServletContext(ServletContext context){
		var obj = context.getAttribute( VaccineEntresKey );
		if (obj == null) return new ArrayList<VaccineEntry>();
		try {
			return (List<VaccineEntry>) obj;
		}catch(Exception ex) { return new ArrayList<VaccineEntry>(); }
   }
	
	public static PatientEntry getPatientEntry(List<PatientEntry> entries, int id){
		PatientEntry entry = null;
		for( var e : entries )
            if( e.getPatientId() == id )
            {
                entry = e;
                break;
            }
		return entry;
   }
	
	public static List<PatientEntry> getPatientEntresFromServletContext(ServletContext context){
		var obj = context.getAttribute( VaccineEntresKey );
		if (obj == null) return new ArrayList<PatientEntry>();
		try {
			return (List<PatientEntry>) obj;
		}catch(Exception ex) { return new ArrayList<PatientEntry>(); }
   }

}

