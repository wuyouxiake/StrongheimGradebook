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
@WebServlet("/studentdetail")
public class studentdetail extends HttpServlet {
	String fullList;
	public void init() throws ServletException {
		// Do required initialization
	}

	@SuppressWarnings("null")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String studentID = request.getParameter("studentID");
			//String type = request.getParameter("type");
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//System.out.println(studentID);
			
			String url = "jdbc:oracle:thin:testuser/password@localhost";
			// properties for creating connection to Oracle database
			Properties props = new Properties();
			props.setProperty("user", "testdb");
			props.setProperty("password", "password");
			Connection conn = DriverManager.getConnection(url, props);
			String action=request.getParameter("action");
			String sql ="";
			if(action.equals("all")){
				sql = "select * from student where studentid= "+ studentID;
			}else if(action.equals("homework")){
				sql = "select * from student where studentid= "+ studentID+" and type = \'homework\'";
			}else if(action.equals("quiz")){
				sql = "select * from student where studentid= "+ studentID+" and type = \'quiz\'";
			}else if(action.equals("test")){
				sql = "select * from student where studentid= "+ studentID+" and type = \'test\'";
			}else if(action.equals("project")){
				sql = "select * from student where studentid= "+ studentID+" and type = \'project\'";
			}
			
			PreparedStatement preStatement = conn.prepareStatement(sql);
			ResultSet result = preStatement.executeQuery();
			
			while(result.next()){
				fullList+=("<tr><td>"+
						result.getString("assignmentname")+"</td><td>"+
						result.getString("type")+"</td><td>"+
						result.getString("assignmentdate")+"</td><td>"+
						result.getString("grade")+
						"</td></tr>");
				
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

			request.setAttribute("fullList", fullList);
			getServletContext().getRequestDispatcher("/studentdetail.jsp").forward(request, response);
			fullList="";
	}

	public void destroy() {
		// do nothing.
	}

}
