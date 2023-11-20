package pojos;

import java.sql.Date;

public class Player {
	private int playerId;
	private String fName;
	private String lName;
	private Date dob;
	private double battingAvg;
	private int wktTaken;
	private int teamId;

	public Player() {
		super();
	}

	public Player(int playerId, String fName, String lName, Date dob, double battingAvg, int wktTaken, int teamId) {
		super();
		this.playerId = playerId;
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wktTaken = wktTaken;
		this.teamId = teamId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWktTaken() {
		return wktTaken;
	}

	public void setWktTaken(int wktTaken) {
		this.wktTaken = wktTaken;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "PlayerDao [playerId=" + playerId + ", fName=" + fName + ", lName=" + lName + ", dob=" + dob
				+ ", battingAvg=" + battingAvg + ", wktTaken=" + wktTaken + ", teamId=" + teamId + "]";
	}

}
