package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface CandidateDao {
	List<Candidate> getcandidateList() throws SQLException;
	int updateCount(int id)throws SQLException;
}
