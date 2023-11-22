package dao;

import java.sql.SQLException;

public interface StudentDao {
	int studentRegister(String fName, String lName, int marks, String course) throws SQLException;

	void updateStatus(String fName) throws SQLException;
}
