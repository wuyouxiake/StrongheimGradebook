import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/Detail")
public class Detail extends HttpServlet {
	String studentid;

	public void init() throws ServletException {
		// Do required initialization
	}

	@SuppressWarnings("null")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String studentID = request.getParameter("studentid");		
			response.setContentType("text/html");
			// Actual logic goes here.
			// PrintWriter out = response.getWriter();
			// message = "Hello";
			// out.println("&lt;h1&gt;" + message + "&lt;/h1&gt;");			
			request.setAttribute("studentid", studentID);
			getServletContext().getRequestDispatcher("/Detail.jsp").forward(request, response);
		
	}

	public void destroy() {
		// do nothing.
	}

}
