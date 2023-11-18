package dao;

import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;

public class CandidateDaoImpl implements CandidateDao {

	private Connection cn;
	private PreparedStatement pst2, pst3;

	public CandidateDaoImpl() throws SQLException {
		cn = openConnection();
		pst2 = cn.prepareStatement(" select * from candidates");
		pst3 = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		System.out.println("candidate dao created!");
	}

	@Override
	public List<Candidate> getcandidateList() throws SQLException {
		List<Candidate> candList = new ArrayList<>();
		try (ResultSet rst = pst2.executeQuery()) {
			while (rst.next())
				candList.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return candList;
	}

	@Override
	public int updateCount(int id) throws SQLException {
		pst3.setInt(1, id);
		return pst3.executeUpdate();
	}

	public void cleanUp() throws SQLException {
		if (pst2 != null)
			pst2.close();
		closeConnection();
		System.out.println("candidate dao cleaned up!");
	}

}
