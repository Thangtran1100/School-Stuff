package practice.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PollEntry;

/**
 * Servlet implementation class ListPoll
 */
@WebServlet("/ListPoll")
public class ListPoll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<PollEntry> pollEntries = new ArrayList<PollEntry>();
		PollEntry poll = new PollEntry();
		poll.setQuestion(" Programming language(s)?");
		poll.getAnswers().add("Java");
		poll.getAnswers().add("Python");
		poll.getAnswers().add("C/C++");
		polls.add(poll);
		getServletContext().setAttribute("pollEntries", pollEntries);

	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPoll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("ListPoll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
