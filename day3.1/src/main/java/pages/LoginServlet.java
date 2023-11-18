package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/LoginServlet", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	UserDaoImpl userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println(getClass() + " initialized");
		try {
			userDao = new UserDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("err in init", e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println(getClass() + " destroyed");
		try {
			userDao.cleanUp();
		} catch (SQLException e) {
			throw new RuntimeException("err in destroy ", e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("em");
			String pass = request.getParameter("pass");
			User user = userDao.getUser(email, pass);
			if (user == null)
				pw.print("<h4> Invalid Login <br>Please <a href='login.html'>Retry</a></h4>");
			else {
				pw.print("<h4>Successful Login , User Details " + user + "</h4>");
				if (user.getRole().equals("admin"))
					response.sendRedirect("admin_page");
				else {
					if (user.isVotingStatus())
						response.sendRedirect("logout");
					else
						response.sendRedirect("voting_page");
				}
			}
		} catch (Exception e) {
			throw new ServletException("err in auth", e);
		}

	}

}
