package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;

import dao.*;
import pojos.Team;

/**
 * Servlet implementation class PlayerRegisterPage
 */
@WebServlet(urlPatterns = "/player_register", loadOnStartup = 1)
public class PlayerRegisterPage extends HttpServlet {
	PlayerDaoImpl playerDao;
	TeamDaoImpl teamDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " init");
		try {
			playerDao = new PlayerDaoImpl();
			teamDao = new TeamDaoImpl();
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
			teamDao.cleanUp();
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
			String dobString = request.getParameter("dob");
			Date dob = Date.valueOf(dobString);
			Double batAvg = Double.parseDouble(request.getParameter("bat_avg"));
			int wktTaken = Integer.parseInt(request.getParameter("wkt_taken"));
			int teamId = Integer.parseInt(request.getParameter("team_id"));
			int playerAge = Period.between(LocalDate.parse(dobString), LocalDate.now()).getYears();
			Team team = teamDao.getTeamInfo(teamId);
			if (playerAge < team.getMaxAge() && batAvg > team.getBattingAvg() && wktTaken > team.getWktTaken()) {
				int status = playerDao.playerRegister(fName, lName, dob, batAvg, wktTaken, teamId);
				if (status != 0)
					pw.write("<h4>Player Succesfully Registered.</h4>");
				else
					pw.write("<h4>Player Registeration failed.</h4>");
			} else
				pw.write("<h4>Player Registeration failed.</h4>");

		} catch (Exception e) {
			throw new ServletException("err in doPost of" + getClass(), e);
		}
	}

}
