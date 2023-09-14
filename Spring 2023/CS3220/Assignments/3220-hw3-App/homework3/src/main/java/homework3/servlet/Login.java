package homework3.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import homework3.model.UserEntry;
import homework3.utilities.DatabaseConnector;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DatabaseConnector databaseConnector = new DatabaseConnector();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = null;
		List<UserEntry> user = databaseConnector.getUserEntries();
		for (UserEntry userEntry : user) {
			if (username.equals(userEntry.getUsername()) && password.equals(userEntry.getPassword())) {
				role = userEntry.getRole();
				break;
			}
		}
		if (role != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("role", role);
			response.sendRedirect("MainPage.jsp");
		} else {
			response.sendRedirect("LoginError.jsp");
		}

	}

}
