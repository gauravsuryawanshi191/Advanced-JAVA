package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/signup")
public class RegisterServlet extends HttpServlet {
	UserDaoImpl userDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println(getClass() + "initialized");
		try {
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init", e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println(getClass() + "destroyed");
		try {
			userDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("err in delete", e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			String fName = request.getParameter("fname");
			String lName = request.getParameter("lname");
			String email = request.getParameter("em");
			String pass = request.getParameter("pass");
			Date dob = Date.valueOf(request.getParameter("dob"));
			int status = userDao.addUser(fName, lName, email, pass, dob);
			if (status == 0)
				pw.print("<h4>Registeration fail!</h4>");
			else
				pw.print("<h4>Successful Registered</h4>");
		} catch (Exception e) {
			throw new ServletException("err in doPost of Register", e);
		}
	}

}
