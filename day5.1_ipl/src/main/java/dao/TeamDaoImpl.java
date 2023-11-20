package dao;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.Team;

public class TeamDaoImpl implements TeamDao {
	private Connection cn;
	private PreparedStatement pst1;

	public TeamDaoImpl() throws SQLException {
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from teams where team_id=?");
	}

	@Override
	public Team getTeamInfo(int teamId) throws SQLException {
		// TODO Auto-generated method stub
		pst1.setInt(1, teamId);
		try (ResultSet rs = pst1.executeQuery()) {
			if (rs.next()) {
				Team team = new Team(teamId, rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDouble(6), rs.getInt(7));
				return team;
			}
		}
		return null;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("teamDao cleaned up!");
	}

}
