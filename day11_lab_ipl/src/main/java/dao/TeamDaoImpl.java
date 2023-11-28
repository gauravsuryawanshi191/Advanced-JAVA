package dao;

import java.util.List;
import org.hibernate.*;

import pojos.Team;

import static utils.HibernateUtils.getFactory;

public class TeamDaoImpl implements TeamDao {

	@Override
	public List<String> getAllTeamsAbbreviations() {
		List<String> abbreviations = null;
		String jpql = "select t.abbreviation from Team t";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			abbreviations = session.createQuery(jpql, String.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return abbreviations;
	}

	@Override
	public Team getDetailsByAbbreviation(String abbreviation) {
		Team team=null;
		String jpql="select t from Team t where t.abbreviation=:abbr";
		// 1. get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			team=session.createQuery(jpql, Team.class)
					.setParameter("abbr",abbreviation)
					.getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return team;
	}

}
