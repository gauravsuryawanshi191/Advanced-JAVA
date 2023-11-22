package beans;

import java.sql.SQLException;

import dao.UserDaoImpl;
import pojos.User;

public class UserBean {
	private UserDaoImpl userDao;
	private User userDetails;
	private String email;
	private String pass;

	public UserBean() throws SQLException {
		userDao = new UserDaoImpl();
		System.out.println("userDao created");
	}

	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

	public User getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String validateUser() throws SQLException {
		userDetails = userDao.getUser(email, pass);
		if (userDetails == null)
			return "login";
		if (userDetails.getRole().equals("admin"))
			return "adminpage";
		if (userDetails.isVotingStatus())
			return "logout";
		return "castavote";
	}
}
