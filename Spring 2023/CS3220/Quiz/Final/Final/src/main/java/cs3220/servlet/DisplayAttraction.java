package cs3220.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Attraction;

@WebServlet("/DisplayAttraction")
public class DisplayAttraction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DisplayAttraction() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu48";
			String username = "cs3220stu48";
            String password = "RLUx6rq7K2Lv";
            
            c = DriverManager.getConnection(url, username, password);
            Statement statement = c.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM attractions");
            
            List<Attraction> attractions = new ArrayList<>();
            
            while(results.next()) {
            	Attraction attraction = new Attraction();
            	attraction.setName(results.getString("name"));
            	attraction.setNumber(results.getString("phone number"));
            	
            	attractions.add(attraction);
            }
            request.setAttribute("attraction", attractions);
            
		}
		catch (SQLException e){
			throw new ServletException(e);
		}
		finally {
			try {
				if (c != null) {
					c.close();
				}
			}
			catch (SQLException e) {
				throw new ServletException(e);
			}
		}
		
		request.getRequestDispatcher("DisplayAttraction.jsp").forward(request, response);
	}


}
