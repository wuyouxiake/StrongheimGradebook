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
 * Servlet implementation class GetList
 */
@WebServlet("/AddToList")
public class AddToList extends HttpServlet {
	
	public void init() throws ServletException {
		// Do required initialization
	
	}
	
	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
			String url="/form.jsp";
			//String action = request.getParameter("action");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url1 = "jdbc:oracle:thin:testuser/password@localhost";
				//properties for creating connection to Oracle database
		        Properties props = new Properties();
		        props.setProperty("user", "testdb");
		        props.setProperty("password", "password");
		        Connection conn=DriverManager.getConnection(url1,props);
		        
		        
		        String studentid = request.getParameter("studentid");
		        String assignmentname = request.getParameter("assignmentname");
		        String type = request.getParameter("type");
		        String assignmentdate = request.getParameter("assignmentdate");
		        String grade = request.getParameter("grade");

		String sql = "insert into student values(null, \'"+studentid+"\' ,\'"+assignmentname+"\' ,\'"+type+"\' ,\'"+assignmentdate+"\' ,"+grade+")";
		System.out.println(sql);
        PreparedStatement preStatement = conn.prepareStatement(sql);
		preStatement.executeQuery();
		
		request.setAttribute("studentid", studentid);
		request.setAttribute("assignmentname", assignmentname);
		request.setAttribute("type", type);
		request.setAttribute("assignmentdate", assignmentdate);
		request.setAttribute("grade", grade);
		url="/added.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	public void destroy() {
		// do nothing.
	}

	
	
}
