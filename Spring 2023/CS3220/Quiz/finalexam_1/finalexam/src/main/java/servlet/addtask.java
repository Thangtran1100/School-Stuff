package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.dbservice;

@WebServlet("/addtask")
public class addtask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public addtask() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/addtask.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String task = request.getParameter("task");
		String detail = request.getParameter("detail");
		dbservice ob = new dbservice();
		ob.addnewTask(task, detail);
		response.sendRedirect("mainhomepage");
	}

}
