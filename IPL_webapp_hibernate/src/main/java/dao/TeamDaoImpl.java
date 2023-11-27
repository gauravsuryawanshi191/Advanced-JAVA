package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeamDetails(Team newTeam) {
		// 1. open hibernate session from SF
		// immutable
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			session.save(newTeam);
			// end of try => success
			tx.commit();
		} catch (RuntimeException e) {
			// rollback tx n re throw the exc to the caller
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return "Added new Team with ID " + newTeam.getId();
	}

	@Override
	public List<Team> getSeletedTeamDetails(String abbr) {
		List<Team> list = null;
		Session session = getFactory().getCurrentSession();
		String jpql = "SELECT t FROM Team t WHERE t.abbreviation = :abbr";
		Transaction tx = session.beginTransaction();

		try {
			list = session.createQuery(jpql, Team.class).setParameter("abbr", abbr).getResultList();

			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return list;
	}

	@Override
	public Team getTeamDetails(String abbr) {
		Session session = getFactory().getCurrentSession();
		String jpql = "SELECT t from Team t where t.abbreviation = :abbr";
		Team team = null;
		Transaction tx = session.beginTransaction();
		try {
			team = session.createQuery(jpql,Team.class)
					.setParameter("abbr", abbr)
					.getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return team;
	}

	@Override
	public List<String> getTeamWithMaxAge(int age) {
		List<String> list = null;
		Session session = getFactory().getCurrentSession();
		String jpql = "SELECT t.name FROM Team t WHERE t.maxAge > :a";
		Transaction tx = session.beginTransaction();
		try {
			list = session.createQuery(jpql, String.class).setParameter("a", age).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return list;
	}

	@Override
	public Team updateTeamStats(int teamid,double battingAvg,int wickets) {
		Team team= null;
		Session session = getFactory().getCurrentSession();
//		String jpql = "SELECT t FROM Team t WHERE t.teamId";
		
		Transaction tx = session.beginTransaction();
		try {
			team =  session.get(Team.class, teamid);
			
			if(team!=null) {
				team.setMinBattingAvg(battingAvg);
				team.setMinWicketsTaken(wickets);
			}
			tx.commit();
		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return team;
	}

	@Override
	public List<String> getAllTeamsByAbbr() {
		List<String> abbrLst = null;
		String jpql = "SELECT t.abbreviation FROM Team t";
		//1.get session from SF
		Session session = getFactory().getCurrentSession();
		//2. begin transaction
		Transaction tx = session.beginTransaction();
		try {
			abbrLst  = session.createQuery(jpql,String.class)
						.getResultList();
			tx.commit();
		}catch (RuntimeException e) {
			// TODO: handle exception
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return abbrLst;
	}
}
