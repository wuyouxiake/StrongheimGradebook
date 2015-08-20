import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/allavg")
public class allavg extends HttpServlet {
	
	String allavg;
	public void init() throws ServletException {
		// Do required initialization
	}

	@SuppressWarnings("null")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String type = request.getParameter("action");
			//String type = request.getParameter("type");
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//System.out.println(studentID);
			
			String url = "jdbc:oracle:thin:testuser/password@localhost";
			// properties for creating connection to Oracle database
			Properties props = new Properties();
			props.setProperty("user", "testdb");
			props.setProperty("password", "password");
			Connection conn = DriverManager.getConnection(url, props);
			String sql ="";
			
				sql = "select avg(grade) as Avg from student where type=\'"+type+"\'";
			
			PreparedStatement preStatement = conn.prepareStatement(sql);
			ResultSet result = preStatement.executeQuery();
			
			while(result.next()){
				allavg=result.getString("avg");
				
			}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			

			// Set response content type
			response.setContentType("text/html");

			// Actual logic goes here.
			// PrintWriter out = response.getWriter();
			// message = "Hello";
			// out.println("&lt;h1&gt;" + message + "&lt;/h1&gt;");

			request.setAttribute("allavg", allavg);
			getServletContext().getRequestDispatcher("/allavg.jsp").forward(request, response);
			allavg="";
	}

	public void destroy() {
		// do nothing.
	}

}
