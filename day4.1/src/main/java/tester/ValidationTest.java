package tester;

import java.util.Scanner;

import dao.UserDaoImpl;
import pojos.User;

public class ValidationTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			UserDaoImpl dao = new UserDaoImpl();
			System.out.println("Enter Id And Password");
			User selectedUser = dao.getUser(sc.next(), sc.next());
			if (selectedUser != null)
				System.out.println(selectedUser);
			else
				System.out.println("No such User Exists");
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
