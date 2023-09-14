package homework2.servlet;

import java.io.IOException;
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

        request.getRequestDispatcher("NewDose.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String vaccine = request.getParameter("dose");
        String dosesReceived = request.getParameter("newDose");

        List<VaccineEntry> entries = ServletUtilities.getVaccineEntresFromServletContext(getServletContext());

        for (VaccineEntry entry : entries) {
            if (vaccine.equals(entry.getVaccineName())) {
                entry.setTotalDoseReceived(entry.getTotalDoseReceived() + Integer.parseInt(dosesReceived));
                entry.setTotalDoseLeft(entry.getTotalDoseLeft() + Integer.parseInt(dosesReceived));
            }
        }

        response.sendRedirect("ListVaccine");

	}

}
