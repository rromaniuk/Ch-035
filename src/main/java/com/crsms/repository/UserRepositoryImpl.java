package com.crsms.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crsms.domain.User;

@Repository
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public User save(User user) {
		if (user.getId()==null) {
			em.persist(user);
		} else {
			em.merge(user);
		}
		return user;
	}

	@Override
	@Transactional
	public boolean delete(int id) {

		return em.createNamedQuery(User.DELETE).setParameter("id", id)
				.executeUpdate() != 0;
	}

	@Override
	public User get(int id) {
		return em.find(User.class, id);
	}

	@Override
	public User getByEmail(String email) {
		return em.createNamedQuery(User.BY_EMAIL, User.class)
				.setParameter("email", email).getSingleResult();
	}

	@Override
	public List<User> getAll() {
		return em.createNamedQuery(User.GET_ALL, User.class).getResultList();
	}
}
