package dao;

import org.hibernate.*;
import pojos.Team;
import static utils.HibernateUtils.getFactory;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String registerTeam(Team team) {
		// 1. open session from SF
		Session session = getFactory().openSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			session.save(team);
			// success : commit
			tx.commit();
		} catch (RuntimeException e) {
			// rollback tx n re throw the exc to the caller
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (session != null)
				session.close();
		}
		return "User registered with ID " + team.getTeamId();
	}

	@Override
	public Team searchByABV(String teamAbv) {
		Team selectedTeam = null;
		String jpql = "select * from Team where teamAbv=/abv";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			selectedTeam = session.createQuery(jpql, Team.class).setParameter("abv", teamAbv).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return selectedTeam;
	}

}
