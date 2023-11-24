package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.TeamDaoImpl;
import pojos.Team;

public class TeamSearchingTest {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			Team selectedTeam = null;
			TeamDaoImpl teamDao = new TeamDaoImpl();
			System.out.print("Enter Team Abbreviation: ");
			selectedTeam = teamDao.searchByABV(sc.next().toUpperCase());
			System.out.println(selectedTeam);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
