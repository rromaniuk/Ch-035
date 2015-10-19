package com.crsms.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.crsms.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User save(User user) {
		if (user.getId() == null) {
			sessionFactory.getCurrentSession().save(user);
		} else {
			sessionFactory.getCurrentSession().update(user);
		}
		return user;
	}

	@Override
	public void delete(Long id) {
		Query query = sessionFactory.getCurrentSession()
				.getNamedQuery(User.DELETE).setLong("id", id);
		query.executeUpdate();
	}

	@Override
	public User getById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getByEmail(String email) {

//		Query query = sessionFactory.getCurrentSession()
//				.getNamedQuery(User.BY_EMAIL).setString("email", email);
//		User user = (User) query.uniqueResult();
		
		List<User>users = sessionFactory.getCurrentSession()
				.getNamedQuery(User.BY_EMAIL).setString("email", email).list();
		return users.size() == 0 ? null : DataAccessUtils.requiredSingleResult(users); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(
				User.ALL_SORTED);
		return query.list();
	}

	}
