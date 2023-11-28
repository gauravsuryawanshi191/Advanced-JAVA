package beans;
//Dependent : TeamBean , it's dependency : TeamDao

import java.util.List;

import dao.TeamDao;
import dao.TeamDaoImpl;

public class TeamBean {
//Dependency
	private TeamDao teamDao;
	//def ctor
	public TeamBean() {
		// create a dependency
		teamDao=new TeamDaoImpl();
		System.out.println("Team bean n team dao created....");
	}
	//add a B.L to fetch abbreviations of all teams
	public List<String> fetchTeamsAbbreviations() 
	{
		return teamDao.getAllTeamsAbbreviations();
	}
	
}
