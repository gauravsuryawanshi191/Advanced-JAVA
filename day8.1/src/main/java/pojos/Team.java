package pojos;

import javax.persistence.*;

@Entity // class level annotation, mandatory annotation, to tell hibernate following is
		// a entity class,whose life cycle to be managed by hibernate
@Table(name = "teams_tbl")
public class Team {
	@Id // mandatory annotation,to place PK constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY) // for auto increment of Id
	@Column(name = "team_id")
	private Integer teamId;// as per founder(Gavin King), use id prop: explicitly serializable
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

	public Team(String teamName, String teamAbv, String teamOwner, int maxAge, double battingAvg, int wktTaken) {
		super();
		this.teamName = teamName;
		this.teamAbv = teamAbv;
		this.teamOwner = teamOwner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wktTaken = wktTaken;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
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
