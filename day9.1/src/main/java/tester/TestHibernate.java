package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDaoImpl;
import pojos.Team;

public class TestHibernate {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			System.out.println("hibernate booted succesfully!!!" + sf);
		} // sf.close --> DBCP cleaned up..
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
