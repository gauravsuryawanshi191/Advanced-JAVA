package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static utils.DBUtils.*;

public class StudentDaoImpl implements StudentDao {
	private Connection cn;
	private PreparedStatement pst1, pst2;

	public StudentDaoImpl() throws SQLException {
		cn = openConnection();
		pst1 = cn.prepareStatement("insert into students(f_name,l_name,marks,course) values(?,?,?,?)");
		pst2 = cn.prepareStatement("update students set admission_status=true where f_name=?");
	}

	@Override
	public int studentRegister(String fName, String lName, int marks, String course) throws SQLException {
		pst1.setString(1, fName);
		pst1.setString(2, lName);
		pst1.setInt(3, marks);
		pst1.setString(4, course);
		pst1.executeUpdate();
		return 0;
	}

	@Override
	public void updateStatus(String fName) throws SQLException {
		pst2.setString(1, fName);
		pst2.executeUpdate();
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("studentdao cleaned up");
	}
}
