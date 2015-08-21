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
@WebServlet("/getStudentSummary")
public class getStudentSummary extends HttpServlet {
	private String outputText="";
	
	private String homeworkweight;
	private String quizweight;
	private String testweight;
	private String projectweight;
	
	private String p_homeworkavg;
	private String p_quizavg;
	private String p_testavg;
	private String p_projectavg;
	private double physicsGPA;
	
	private String e_homeworkavg;
	private String e_quizavg;
	private String e_testavg;
	private String e_projectavg;
	private double earthscienceGPA;
	
	private String h_homeworkavg;
	private String h_quizavg;
	private String h_testavg;
	private String h_projectavg;
	private double historyGPA;
	
	private String m_homeworkavg;
	private String m_quizavg;
	private String m_testavg;
	private String m_projectavg;
	private double mathGPA;

	public void init() throws ServletException {
		// Do required initialization
		p_homeworkavg = "0";
		p_quizavg = "0";
		p_testavg = "0";
		p_projectavg = "0";
	}

	@SuppressWarnings("null")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String studentid = request.getParameter("studentid");
			String url = "jdbc:oracle:thin:testuser/password@localhost";
			// properties for creating connection to Oracle database
			Properties props = new Properties();
			props.setProperty("user", "testdb");
			props.setProperty("password", "password");
			Connection conn = DriverManager.getConnection(url, props);
			//find student
			String preSQL="select studentid from student where studentid="+studentid;
			PreparedStatement preStatementt = conn.prepareStatement(preSQL);
			ResultSet resultt = preStatementt.executeQuery();

			if(!resultt.next()){
				outputText="Student not exist!";
			}else{
			//Get weight
				String sqlhomework = "select weight from assignmentweight where type=\'homework\'";
				PreparedStatement preStatementq = conn.prepareStatement(sqlhomework);
				ResultSet resultq = preStatementq.executeQuery();
				while (resultq.next()) {
					homeworkweight = resultq.getString("weight");
				}
				
				
				String sqlquiz = "select weight from assignmentweight where type=\'quiz\'";
				PreparedStatement preStatementw = conn.prepareStatement(sqlquiz);
				ResultSet resultw = preStatementw.executeQuery();
				while (resultw.next()) {
					quizweight = resultw.getString("weight");
				}
				
				String sqltest = "select weight from assignmentweight where type=\'test\'";
				PreparedStatement preStatemente = conn.prepareStatement(sqltest);
				ResultSet resulte = preStatemente.executeQuery();
				while (resulte.next()) {
					testweight = resulte.getString("weight");
				}
				
				String sqlproject = "select weight from assignmentweight where type=\'project\'";
				PreparedStatement preStatementr = conn.prepareStatement(sqlproject);
				ResultSet resultr = preStatementr.executeQuery();
				while (resultr.next()) {
					projectweight = resultr.getString("weight");
				}
				

// AVG FOR PHYSICS				
// avg homework for physics
				String sql1 = "select avg(grade) as avg from student where studentid="+ studentid + " and type=\'homework\' and class=1";
				PreparedStatement preStatement1 = conn.prepareStatement(sql1);
				ResultSet result1 = preStatement1.executeQuery();
				p_homeworkavg = "0";
				while (result1.next()) {
					p_homeworkavg = result1.getString("avg");
					if(p_homeworkavg==null){
						p_homeworkavg="0";
					}
				}
			
// avg quiz for physics
			String sql2 = "select avg(grade) as avg from student where studentid="+ studentid + " and type=\'quiz\' and class=1";
			PreparedStatement preStatement2 = conn.prepareStatement(sql2);
			ResultSet result2 = preStatement2.executeQuery();
			p_quizavg = "0";
			while (result2.next()) {
				p_quizavg = result2.getString("avg");
				if(p_quizavg==null){
					p_quizavg="0";
				}
				// System.out.println(fullList);
			}
		

// avg test for physics
				String sql3 = "select avg(grade) as avg from student where studentid="+ studentid + " and type=\'test\' and class=1";
				PreparedStatement preStatement3 = conn.prepareStatement(sql3);
				ResultSet result3 = preStatement3.executeQuery();
				p_testavg = "0";
				while (result3.next()) {
					p_testavg = result3.getString("avg");
					if(p_testavg==null){
						p_testavg="0";
					}
					// System.out.println(fullList);
				}
			
			
// avg project for physics
					String sql4 = "select avg(grade) as avg from student where studentid="+ studentid + " and type=\'project\' and class=1";
					PreparedStatement preStatement4 = conn.prepareStatement(sql4);
					ResultSet result4 = preStatement4.executeQuery();
					p_projectavg = "0";
					while (result4.next()) {
						p_projectavg = result4.getString("avg");
						if(p_projectavg==null){
							p_projectavg="0";
						}
					}
					physicsGPA = Float.parseFloat(p_homeworkavg) * Float.parseFloat(homeworkweight)+
							Float.parseFloat(p_quizavg) * Float.parseFloat(quizweight)+
								Float.parseFloat(p_testavg) * Float.parseFloat(testweight)+
								Float.parseFloat(p_projectavg) * Float.parseFloat(projectweight);

// AVG FOR EARTH SCIENCE
// avg homework for EARTH SCIENCE
				String sql5 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'homework\' and class=2";
				PreparedStatement preStatement5 = conn.prepareStatement(sql5);
				ResultSet result5 = preStatement5.executeQuery();
				e_homeworkavg = "0";
				while (result5.next()) {
					e_homeworkavg = result5.getString("avg");
					if (e_homeworkavg == null) {
						e_homeworkavg = "0";
					}
				}

// avg quiz for EARTH SCIENCE
				String sql6 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'quiz\' and class=2";
				PreparedStatement preStatement6 = conn.prepareStatement(sql6);
				ResultSet result6 = preStatement6.executeQuery();
				e_quizavg = "0";
				while (result6.next()) {
					e_quizavg = result6.getString("avg");
					if (e_quizavg == null) {
						e_quizavg = "0";
					}
				}

// avg test for EARTH SCIENCE
				String sql7 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'test\' and class=2";
				PreparedStatement preStatement7 = conn.prepareStatement(sql7);
				ResultSet result7 = preStatement7.executeQuery();
				e_testavg = "0";
				while (result7.next()) {
					e_testavg = result7.getString("avg");
					if (e_testavg == null) {
						e_testavg = "0";
					}
				}

// avg project for EARTH SCIENCE
				String sql8 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'project\' and class=2";
				PreparedStatement preStatement8 = conn.prepareStatement(sql8);
				ResultSet result8 = preStatement8.executeQuery();
				e_projectavg = "0";
				while (result8.next()) {
					e_projectavg = result8.getString("avg");
					if (e_projectavg == null) {
						e_projectavg = "0";
					}
				}

				earthscienceGPA = Float.parseFloat(e_homeworkavg)
						* Float.parseFloat(homeworkweight)
						+ Float.parseFloat(e_quizavg)
						* Float.parseFloat(quizweight)
						+ Float.parseFloat(e_testavg)
						* Float.parseFloat(testweight)
						+ Float.parseFloat(e_projectavg)
						* Float.parseFloat(projectweight);
				
				
				

// AVG FOR HISTORY
// avg homework for HISTORY
				String sql9 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'homework\' and class=3";
				PreparedStatement preStatement9 = conn.prepareStatement(sql9);
				ResultSet result9 = preStatement9.executeQuery();
				h_homeworkavg = "0";
				while (result9.next()) {
					h_homeworkavg = result9.getString("avg");
					if (h_homeworkavg == null) {
						h_homeworkavg = "0";
					}
				}

// avg quiz for HISTORY
				String sql10 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'quiz\' and class=3";
				PreparedStatement preStatement10 = conn.prepareStatement(sql10);
				ResultSet result10 = preStatement10.executeQuery();
				h_quizavg = "0";
				while (result10.next()) {
					h_quizavg = result10.getString("avg");
					if (h_quizavg == null) {
						h_quizavg = "0";
					}
					// System.out.println(fullList);
				}

// avg test for HISTORY
				String sql11 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'test\' and class=3";
				PreparedStatement preStatement11 = conn.prepareStatement(sql11);
				ResultSet result11 = preStatement11.executeQuery();
				h_testavg = "0";
				while (result11.next()) {
					h_testavg = result11.getString("avg");
					if (h_testavg == null) {
						h_testavg = "0";
					}
				}

// avg project for HISTORY
				String sql12 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'project\' and class=3";
				PreparedStatement preStatement12 = conn.prepareStatement(sql12);
				ResultSet result12 = preStatement12.executeQuery();
				h_projectavg = "0";
				while (result12.next()) {
					h_projectavg = result12.getString("avg");
					if (h_projectavg == null) {
						h_projectavg = "0";
					}
				}
				historyGPA = Float.parseFloat(h_homeworkavg)
						* Float.parseFloat(homeworkweight)
						+ Float.parseFloat(h_quizavg)
						* Float.parseFloat(quizweight)
						+ Float.parseFloat(h_testavg)
						* Float.parseFloat(testweight)
						+ Float.parseFloat(h_projectavg)
						* Float.parseFloat(projectweight);
				
				
				
				
// AVG FOR MATH
// avg homework for MATH
				String sql13 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'homework\' and class=4";
				PreparedStatement preStatement13 = conn.prepareStatement(sql13);
				ResultSet result13 = preStatement13.executeQuery();
				m_homeworkavg = "0";
				while (result13.next()) {
					m_homeworkavg = result13.getString("avg");
					if (m_homeworkavg == null) {
						m_homeworkavg = "0";
					}
				}

// avg quiz for MATH
				String sql14 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'quiz\' and class=4";
				PreparedStatement preStatement14 = conn.prepareStatement(sql14);
				ResultSet result14 = preStatement14.executeQuery();
				m_quizavg = "0";
				while (result14.next()) {
					m_quizavg = result14.getString("avg");
					if (m_quizavg == null) {
						m_quizavg = "0";
					}
				}

// avg test for MATH
				String sql15 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'test\' and class=4";
				PreparedStatement preStatement15 = conn.prepareStatement(sql15);
				ResultSet result15 = preStatement15.executeQuery();
				m_testavg = "0";
				while (result15.next()) {
					m_testavg = result15.getString("avg");
					if (m_testavg == null) {
						m_testavg = "0";
					}
				}

// avg project for MATH
				String sql16 = "select avg(grade) as avg from student where studentid="
						+ studentid + " and type=\'project\' and class=4";
				PreparedStatement preStatement16 = conn.prepareStatement(sql16);
				ResultSet result16 = preStatement16.executeQuery();
				m_projectavg = "0";
				while (result16.next()) {
					m_projectavg = result16.getString("avg");
					if (m_projectavg == null) {
						m_projectavg = "0";
					}
				}
				mathGPA = Float.parseFloat(m_homeworkavg)
						* Float.parseFloat(homeworkweight)
						+ Float.parseFloat(m_quizavg)
						* Float.parseFloat(quizweight)
						+ Float.parseFloat(m_testavg)
						* Float.parseFloat(testweight)
						+ Float.parseFloat(m_projectavg)
						* Float.parseFloat(projectweight);

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
		request.setAttribute("p_homeworkavg", p_homeworkavg);
		request.setAttribute("p_quizavg", p_quizavg);
		request.setAttribute("p_testavg", p_testavg);
		request.setAttribute("p_projectavg", p_projectavg);
		request.setAttribute("physicsGPA", physicsGPA);
		
		request.setAttribute("e_homeworkavg", e_homeworkavg);
		request.setAttribute("e_quizavg", e_quizavg);
		request.setAttribute("e_testavg", e_testavg);
		request.setAttribute("e_projectavg", e_projectavg);
		request.setAttribute("earthscienceGPA", earthscienceGPA);
		
		request.setAttribute("h_homeworkavg", h_homeworkavg);
		request.setAttribute("h_quizavg", h_quizavg);
		request.setAttribute("h_testavg", h_testavg);
		request.setAttribute("h_projectavg", h_projectavg);
		request.setAttribute("historyGPA", historyGPA);
		
		request.setAttribute("m_homeworkavg", m_homeworkavg);
		request.setAttribute("m_quizavg", m_quizavg);
		request.setAttribute("m_testavg", m_testavg);
		request.setAttribute("m_projectavg", m_projectavg);
		request.setAttribute("mathGPA", mathGPA);

		request.setAttribute("outputText", outputText);


		getServletContext().getRequestDispatcher("/personalSummary.jsp").forward(request,
				response);
		outputText="";
		p_homeworkavg="";
		p_quizavg="";
		p_testavg="";
		p_projectavg="";
		physicsGPA=0;
		
		e_homeworkavg="";
		e_quizavg="";
		e_testavg="";
		e_projectavg="";
		earthscienceGPA=0;
		
		h_homeworkavg="";
		h_quizavg="";
		h_testavg="";
		h_projectavg="";
		historyGPA=0;
		
		m_homeworkavg="";
		m_quizavg="";
		m_testavg="";
		m_projectavg="";
		mathGPA=0;
	}

	public void destroy() {
		// do nothing.
	}

}
