package tester;

import java.util.List;
import java.util.Scanner;

import dao.CandidateDaoImpl;
import pojos.Candidate;

public class CandidateTester {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			CandidateDaoImpl dao = new CandidateDaoImpl();
			List<Candidate> candidateList = dao.getcandidateList();
			candidateList.forEach(System.out::println);
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
