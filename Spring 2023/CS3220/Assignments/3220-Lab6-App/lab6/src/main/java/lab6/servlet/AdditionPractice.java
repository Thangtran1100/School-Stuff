package lab6.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Servlet implementation class AdditionPractice
 */
@WebServlet("/AdditionPractice")
public class AdditionPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdditionPractice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		
		// Generate a random number between 1 and 9 (inclusive)
        int num1 = rand.nextInt(9) + 1; 
        int num2 = rand.nextInt(9) + 1;
        
    
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<form method='post'>");
        out.println(num1 + " + " + num2 + " = ");
        out.println("<input type='hidden' name='num1' value='" + num1 + "' />");
        out.println("<input type='hidden' name='num2' value='" + num2 + "' />");
        out.println("<input type='text' name='answer' />");
        out.println("<input type='submit' value='Submit' />");
        out.println("</form>");
        out.println("</body></html>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        int answer = Integer.parseInt(request.getParameter("answer"));
        int correctAnswer = num1 + num2;
        
        // Check if the user's answer is correct
        String result;
        
        if (answer == correctAnswer) {
            result = "correct.";
        } else {
            result = "incorrect. The correct answer is " + correctAnswer + ".";
        }
        
        // Display the result and provide a link to try again
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(num1 + " + " + num2 + " = " + answer);
        out.println("<br><br>Your answer is " + result);
        out.println("<br><br><a href='AdditionPractice'>Try Again</a>");
        out.println("</body></html>");
	}

}
