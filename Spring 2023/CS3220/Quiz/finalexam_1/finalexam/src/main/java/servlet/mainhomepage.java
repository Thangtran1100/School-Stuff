package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.taskdetail;
import service.dbservice;

@WebServlet(value = "/mainhomepage", loadOnStartup = 1)
public class mainhomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dbservice ob = new dbservice();
		List<taskdetail> entries = new ArrayList<>();
		entries = ob.get_all_details();
		getServletContext().setAttribute("entries", entries);
	}

	public mainhomepage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dbservice ob = new dbservice();
		List<taskdetail> entries = new ArrayList<>();
		entries = ob.get_all_details();
		request.setAttribute("entries",entries);
		request.getRequestDispatcher("WEB-INF/mainhomepage.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
