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
@WebServlet("/studentavg")
public class studentavg extends HttpServlet {
	String studentavg;
	String type;
	public void init() throws ServletException {
		// Do required initialization
	}

	@SuppressWarnings("null")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String studentID = request.getParameter("studentID");
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
			type=request.getParameter("action");
			String sql ="";
			if(!type.equals("none")){
				sql = "select avg(grade) as avg from student where type=\'"+type+"\' and studentid = "+studentID;
			}else{
				
				sql = "select avg(grade) as avg from student where studentid = "+studentID;
			}
			
			System.out.println(sql);
			PreparedStatement preStatement = conn.prepareStatement(sql);
			ResultSet result = preStatement.executeQuery();
			
			while(result.next()){
				studentavg="The avg score is "+ result.getString("avg");
				
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

			request.setAttribute("studentavg", studentavg);
			getServletContext().getRequestDispatcher("/studentavg.jsp").forward(request, response);
			studentavg="";
	}

	public void destroy() {
		// do nothing.
	}

}
