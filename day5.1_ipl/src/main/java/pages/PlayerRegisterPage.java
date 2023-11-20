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

import org.apache.catalina.User;

import dao.*;

/**
 * Servlet implementation class PlayerRegisterPage
 */
@WebServlet(urlPatterns = "/player_register", loadOnStartup = 1)
public class PlayerRegisterPage extends HttpServlet {
	PlayerDaoImpl playerDao;
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " init");
		try {
			playerDao = new PlayerDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init of" + getClass(), e);
		}

	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " destroyed");
		try {
			playerDao.cleanUp();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy of " + getClass(), e);
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
			String fName = request.getParameter("f_name");
			String lName = request.getParameter("l_name");
			Date dob = Date.valueOf(request.getParameter("dob"));
			Double batAvg = Double.parseDouble(request.getParameter("bat_avg"));
			int wktTaken = Integer.parseInt(request.getParameter("wkt_taken"));
			int teamId = Integer.parseInt(request.getParameter("team_id"));
			
			int status = playerDao.playerRegister(fName, lName, dob, batAvg, wktTaken, teamId);
			if (status != 0)
				pw.write("<h4>Player Succesfully Registered.</h4>");
			else
				pw.write("<h4>Player Registeration failed.</h4>");
		} catch (Exception e) {
			throw new ServletException("err in doPost of" + getClass(), e);
		}
	}

}
