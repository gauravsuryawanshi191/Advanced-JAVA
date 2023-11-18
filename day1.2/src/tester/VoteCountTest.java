package tester;

import java.util.Scanner;

import dao.CandidateDaoImpl;

public class VoteCountTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			CandidateDaoImpl dao = new CandidateDaoImpl();
			System.out.println("Enter id to update vote:");
			int status = dao.updateCount(sc.nextInt());
			if (status != 0)
				System.out.println("Vote Updated");
			else
				System.out.println("No such Candidate!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
