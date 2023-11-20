package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.*;

import pojos.User;

public class UserDaoImpl implements UserDao {

	// state (fields)
	private Connection connection;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3, pst4;

	// def ctor
	public UserDaoImpl() throws SQLException {
		// get cn from db utils
		connection = openConnection();
		pst1 = connection.prepareStatement(
				"select first_name,last_name,dob,status from users where role=? and dob between ? and ?");
		pst2 = connection.prepareStatement("select * from users where email=? and password=?");
		pst3 = connection.prepareStatement("update users set status=1 where email=? and password=?");
		pst4 = connection.prepareStatement(
				"insert into users(first_name,last_name,email,password,dob,status,role) values(?,?,?,?,?,?,?)");
		System.out.println("user dao created!");
	}

	@Override
	public List<User> getSelectedUsers(String role, Date begin, Date end) throws SQLException {
		// set IN params
		pst1.setString(1, role);
		pst1.setDate(2, begin);
		pst1.setDate(3, end);
		// exec query : execQuery() --- RST
		List<User> users = new ArrayList<>();
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				users.add(new User(rst.getString(1), rst.getString(2), rst.getDate(3), rst.getBoolean(4)));
		}
		return users;// DAO rets populated list of users to tester.
	}

	@Override
	public User getUser(String email, String password) throws SQLException {
		pst2.setString(1, email);
		pst2.setString(2, password);
		try (ResultSet rst = pst2.executeQuery()) {
			if (rst.next()) {
				User selectedUser = new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
				return selectedUser;
			}
		}
		return null;
	}

	@Override
	public int updateStatus(String email, String password) throws SQLException {
		pst3.setString(1, email);
		pst3.setString(2, password);
		int status = pst3.executeUpdate();
		return status;
	}

	@Override
	public int addUser(String fName, String lName, String email, String pass, Date dob) throws SQLException {
		pst4.setString(1, fName);
		pst4.setString(2, lName);
		pst4.setString(3, email);
		pst4.setString(4, pass);
		pst4.setDate(5, dob);
		pst4.setBoolean(6, false);
		pst4.setString(7, "voter");
		return  pst4.executeUpdate();
		
	}

	// clean up
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("user dao cleaned up !");
	}

}
