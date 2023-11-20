package pojos;

public class Team {
	private int teamId;
	private String teamName;
	private String teamAbv;
	private String teamOwner;
	private int maxAge;
	private double battingAvg;
	private int wktTaken;

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", teamAbv=" + teamAbv + ", teamOwner=" + teamOwner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wktTaken=" + wktTaken + "]";
	}

}
