package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addNewPlayer(Player p, Long teamId) {
		String msg = "Player addition failed!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Team team = session.get(Team.class, teamId);
			if (team != null) {
				team.addPlayer(p);
				session.persist(p);
				tx.commit();
				msg = "Player added successfully!";
			}

		} catch (RuntimeException e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
