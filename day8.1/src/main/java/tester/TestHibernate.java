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
			TeamDaoImpl teamDao = new TeamDaoImpl();
			System.out.println("Enter Team Data:");
			System.out.println("teamName,teamABV,teamOwner,maxAge,battingAvg,wktTaken");
			Team newTeam = new Team(sc.nextLine(), sc.next(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
			teamDao.registerTeam(newTeam);
		} // sf.close --> DBCP cleaned up..
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
