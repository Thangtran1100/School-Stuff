package lab8.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Question;

/**
 * Servlet implementation class DrivingTestBrowser
 */
@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
        super.init(config);
        
        List<Question> questionEntry = new ArrayList<>();

        try {

            File textFileInput = new File(getServletContext().getRealPath("/WEB-INF/DrivingTest.txt"));
            
            if (textFileInput.length() == 0) {
                throw new ServletException("Text file is empty");
            }
            
            Scanner fileInput = new Scanner(textFileInput);
            
            while (fileInput.hasNextLine()) {
                Question question = new Question();
                
                question.setDescription(fileInput.nextLine());        
                
                if(fileInput.hasNextLine())
                {
                	question.setAnswerA(fileInput.nextLine());
                }
                else
                {
                	question.setAnswerA("");
                }
                
                if(fileInput.hasNextLine())
                {
                	question.setAnswerB(fileInput.nextLine());
                }
                else
                {
                	question.setAnswerB("");
                }
                
                if(fileInput.hasNextLine())
                {
                	question.setAnswerC(fileInput.nextLine());
                }
                else
                {
                	question.setAnswerC("");
                }
                
                if(fileInput.hasNextLine())
                {
                	question.setCorrectAnswer(Integer.parseInt(fileInput.nextLine()));
                }
                else
                {
                	question.setCorrectAnswer(0);
                }
                
                
                questionEntry.add(question);
                
                if (fileInput.hasNextLine()) {
                    fileInput.nextLine();
                }
            }
            
            fileInput.close();
        } catch (FileNotFoundException e) {
            throw new ServletException(e);
        }
        
        getServletContext().setAttribute("questionEntry", questionEntry);

    }




    


	/**
     * @see HttpServlet#HttpServlet()
     */
    public DrivingTestBrowser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int questionID;
		
	    HttpSession session = request.getSession();
	    
	    if (session.getAttribute("questionID") == null) {
	        questionID = 0;
	    } else {
	        questionID = (int) session.getAttribute("questionID");
	        
	        questionID++;
	    }
	    
	    session.setAttribute("questionID", questionID);

	    request.setAttribute("idSession", questionID);

	    request.getRequestDispatcher("DrivingTestBrowser.jsp").forward(request, response);



    }





	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
