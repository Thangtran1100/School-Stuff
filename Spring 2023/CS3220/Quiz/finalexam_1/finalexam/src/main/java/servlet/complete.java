package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.dbservice;

@WebServlet("/complete")
public class complete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public complete() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("cid"));
		dbservice ob = new dbservice();
		ob.removeparticularmem(id);
		response.sendRedirect("mainhomepage");
	}

}
