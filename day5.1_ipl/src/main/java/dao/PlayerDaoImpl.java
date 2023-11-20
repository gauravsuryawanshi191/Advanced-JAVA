package dao;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerDaoImpl implements PlayerDao {
	private Connection cn;
	private PreparedStatement pst1;

	public PlayerDaoImpl() throws SQLException {
		cn = openConnection();
		pst1 = cn.prepareStatement(
				"insert into players(first_name,last_name,dob,batting_avg,wickets_taken,team_id) values(?,?,?,?,?,?)");
	}

	@Override
	public int playerRegister(String fName, String lName, Date dob, Double batAvg, int wktTaken, int teamId)
			throws SQLException {
		pst1.setString(1, fName);
		pst1.setString(2, lName);
		pst1.setDate(3, dob);
		pst1.setDouble(4, batAvg);
		pst1.setInt(5, wktTaken);
		pst1.setInt(6, teamId);
		return pst1.executeUpdate();
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("playerdao cleaned up!");
	}
}
