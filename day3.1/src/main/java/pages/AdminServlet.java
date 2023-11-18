package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin_page")
public class AdminServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in admin page");
		resp.setContentType("text/html");
		try (PrintWriter pw = resp.getWriter()) {
			pw.print("<h4>Welcome Admin</h4>");
			pw.print("<h4><a href='login.html'>Login</a></h4>");
		}
	}

}
