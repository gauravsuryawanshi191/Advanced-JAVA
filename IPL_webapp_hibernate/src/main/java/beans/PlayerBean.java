package beans;

import java.time.LocalDate;
import java.util.List;

import dao.PlayerDao;
import dao.PlayerDaoImpl;
import dao.TeamDao;
import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

public class PlayerBean {
	private PlayerDao playerDao;
	private TeamDao teamDao;
	private String fn;
	private String ln;
	private String dob;
	private double avg;
	private int wickets;
	private String myTeam;
	
	
public String getMyTeam() {
		return myTeam;
	}


	public void setMyTeam(String myTeam) {
		this.myTeam = myTeam;
	}

	
	public PlayerBean() {
		super();
		playerDao = new PlayerDaoImpl();
		teamDao = new TeamDaoImpl();
	}
	
	
	public String addNewPlayer() {
		Team team = teamDao.getTeamDetails(myTeam);
		return playerDao.addNewPlayer(new Player(fn, ln, LocalDate.parse(dob), avg, wickets),team.getId());
	}
	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}

	

	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	

	public PlayerBean(String fn, String ln, String dob, double avg, int wickets) {
		super();
		this.fn = fn;
		this.ln = ln;
		this.dob = dob;
		this.avg = avg;
		this.wickets = wickets;
	}


	public PlayerDao getPlayerDao() {
		return playerDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	

}
