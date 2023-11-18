package tester;

import java.util.Scanner;

import dao.UserDaoImpl;

public class VotingStatusTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			int status = dao.updateStatus(sc.next(), sc.next());
			if (status != 0)
				System.out.println("Status Updated");
			else
				System.out.println("No such User Exists");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
