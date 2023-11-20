package dao;

import java.sql.SQLException;

import pojos.Team;

public interface TeamDao {
	Team getTeamInfo(int teamId) throws SQLException;
}
