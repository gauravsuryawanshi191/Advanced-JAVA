package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDaoImpl implements TeamDao {
	//dep : EntitiyManager (super i/f of Hibernate Session)
	@Autowired
	private EntityManager manager;

	@Override
	public List<String> getAllTeamsAbbreviations() {
		String jpql="select t.abbreviation from Team t";
		return manager.createQuery(jpql, String.class)
				.getResultList();
	}

}
