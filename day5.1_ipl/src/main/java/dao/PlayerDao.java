package dao;

import java.sql.Date;
import java.sql.SQLException;

public interface PlayerDao {
	int playerRegister(String fName, String lName, Date dob, Double batAvg, int wktTaken, int teamId) throws SQLException;
}
