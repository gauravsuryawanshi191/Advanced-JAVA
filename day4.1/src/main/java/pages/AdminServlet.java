package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;

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
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user_details");
			pw.print("<h4>Welcome Admin" + user.getFirstName() + " " + user.getLastName() + "</h4>");
			pw.write("<h4>" + user + "</h4>");
			pw.print("<h4><a href='login.html'>Login</a></h4>");
		}
	}

}
