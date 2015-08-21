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
@WebServlet("/ChangeWeight")
public class ChangeWeight extends HttpServlet {

	public void init() throws ServletException {
		// Do required initialization

	}

	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		// String action = request.getParameter("action");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url1 = "jdbc:oracle:thin:testuser/password@localhost";
			// properties for creating connection to Oracle database
			Properties props = new Properties();
			props.setProperty("user", "testdb");
			props.setProperty("password", "password");
			Connection conn = DriverManager.getConnection(url1, props);

			String homework = request.getParameter("homework");
			String quiz = request.getParameter("quiz");
			String test = request.getParameter("test");
			String project = request.getParameter("project");

			String sql1 = "update assignmentweight set weight="+homework+" where type=\'homework\'";
			String sql2 = "update assignmentweight set weight="+quiz+" where type=\'quiz\'";
			String sql3 = "update assignmentweight set weight="+test+" where type=\'test\'";
			String sql4 = "update assignmentweight set weight="+project+" where type=\'project\'";
			
			
			PreparedStatement preStatement = conn.prepareStatement(sql1);
			preStatement.executeQuery();
			
			preStatement = conn.prepareStatement(sql2);
			preStatement.executeQuery();
			
			preStatement = conn.prepareStatement(sql3);
			preStatement.executeQuery();
			
			preStatement = conn.prepareStatement(sql4);
			preStatement.executeQuery();

			request.setAttribute("homework", homework);
			request.setAttribute("quiz", quiz);
			request.setAttribute("test", test);
			request.setAttribute("project", project);
			url = "/updated.jsp";
			getServletContext().getRequestDispatcher(url).forward(request,
					response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		// do nothing.
	}

}
