package practice.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PollEntry;

/**
 * Servlet implementation class AddAnswer
 */
@WebServlet("/AddAnswer")
public class AddAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		List<PollEntry> polls = (List<PollEntry>) getServletContext().getAttribute("polls");
		PollEntry poll = null;
		
		for(PollEntry p : polls)
			if(p.getId() == id) {
				poll = p;
				break;
			}
		
		request.setAttribute("poll", poll);
		request.getRequestDispatcher("AddAnswer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
int id = Integer.parseInt(request.getParameter("id"));
		
		String answer = request.getParameter("answer");
		
		List<PollEntry> polls = (List<PollEntry>) getServletContext().getAttribute("polls");
		PollEntry poll = null;
		
		for(PollEntry p : polls)
			if(p.getId() == id) {
				poll = p;
				break;
			}
		poll.getAnswers().add(answer);
		response.sendRedirect("AddAnswer?id=" + id);
	}

}
