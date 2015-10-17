package com.crsms.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crsms.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private SessionFactory sessionFactory;

	// protected Session getSession() {
	// return sessionFactory.getCurrentSession();
	// }

	@Override
	public User save(User user) {
		if (user.getId() == null) {
			sessionFactory.getCurrentSession().persist(user);
		} else {
			sessionFactory.getCurrentSession().merge(user);
		}
		return user;
	}

	@Override
	public void delete(Long id) {
		// Query query = session.getNamedQuery(User.DELETE)
		sessionFactory.getCurrentSession().getNamedQuery(User.DELETE).setParameter("id", id)
				.executeUpdate();
	}

	@Override
	public User getById(Long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public User getByEmail(String email) {
		return (User) sessionFactory.getCurrentSession().getNamedQuery(User.GET_BY_EMAIL).setParameter(
				"email", email);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return sessionFactory.getCurrentSession().getNamedQuery(User.GET_ALL).list();
	}
}
