package beans;

import java.util.List;

import dao.TeamDao;
import dao.TeamDaoImpl;

public class TeamBean {
	private TeamDao teamDao;

	public TeamBean() {
		super();
		teamDao = new TeamDaoImpl();
		System.out.println("Team Dao Created...:)");
	}

	public List<String> fetchAllTeamsByAbbr() {
		return teamDao.getAllTeamsByAbbr();
	}

	public TeamDao getTeamDao() {
		return teamDao;
	}

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

}
