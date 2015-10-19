package com.crsms.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crsms.config.SpringMain;
import com.crsms.domain.Role;
import com.crsms.domain.User;

@Repository
public class RoleRepositoryImpl implements RoleRepository {
	private static final Logger LOG = LoggerFactory
			.getLogger(RoleRepositoryImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;

	@Override
	public Role save(Role role, Long userId) {
		Session session =sessionFactory.openSession();
		 User ref = (User) session.byId(User.class).getReference(userId);
		 session.close();
		 role.setUser(ref);
		if (role.getId() == null) {
			sessionFactory.getCurrentSession().save(role);
		} else {
			if (getByName(role.getName()) == null) return null;
			sessionFactory.getCurrentSession().update(role);
		}
		return role;
	}

	@Override
	public void delete(Long id, Long userId) {
		Query query = sessionFactory.getCurrentSession()
				.getNamedQuery(Role.DELETE)
				.setLong("id", id)
				.setLong("user_id", userId);
		query.executeUpdate();
	}

	@Override
	public Role getByName(String name) {
		Query query = sessionFactory.getCurrentSession()
				.getNamedQuery(Role.BY_NAME).setString("name", name);
		Role role = (Role) query.uniqueResult();
		return role;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAll() {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(
				Role.ALL_SORTED);
		return query.list();
	}
}
