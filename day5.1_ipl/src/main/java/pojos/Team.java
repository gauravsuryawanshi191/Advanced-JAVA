package pojos;

public class Team {
	private int teamId;
	private String teamName;
	private String teamAbv;
	private String teamOwner;
	private int maxAge;
	private double battingAvg;
	private int wktTaken;

	public Team(int teamId, String teamName, String teamAbv, String teamOwner, int maxAge, double battingAvg,
			int wktTaken) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamAbv = teamAbv;
		this.teamOwner = teamOwner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wktTaken = wktTaken;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamAbv() {
		return teamAbv;
	}

	public void setTeamAbv(String teamAbv) {
		this.teamAbv = teamAbv;
	}

	public String getTeamOwner() {
		return teamOwner;
	}

	public void setTeamOwner(String teamOwner) {
		this.teamOwner = teamOwner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
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

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teamAbv=" + teamAbv + ", teamOwner=" + teamOwner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wktTaken=" + wktTaken + "]";
	}

}
