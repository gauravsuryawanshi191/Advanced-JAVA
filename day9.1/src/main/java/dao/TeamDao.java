package dao;

import pojos.Team;

public interface TeamDao {
	String registerTeam(Team team);

	Team searchByABV(String teamAbv);
}
