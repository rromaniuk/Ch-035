package com.crsms.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crsms.domain.User;
import com.crsms.search.AbstractSearchParams;
import com.crsms.search.UserSearchParams;

/**
 * 
 * @author Roman Romaniuk
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	private static Logger log = LogManager.getLogger(UserDaoImpl.class);

	public User saveUser(User user) {
		try {
			if (user.getId() == null) {
				log.info("saving user: ", user);
				sessionFactory.getCurrentSession().save(user);
			} else {
				log.info("updating user: ", user);
				sessionFactory.getCurrentSession().update(user);
			}
		} catch (Exception e) {
			log.error("Error saveUser: " + e);
		}
		return user;
	}

	@Override
	public void delete(Long id) {
		try {
			log.info("delete " + id);
			Query query = sessionFactory.getCurrentSession()
					.getNamedQuery(User.DELETE).setLong("id", id);
			query.executeUpdate();
		} catch (Exception e) {
			log.error("Error deleting user by Id: " + id + e);
		}
	}

	@Override
	public User getUserById(Long id) {
		User user = new User();

		try {

			user = (User) sessionFactory.getCurrentSession()
					.get(User.class, id);
			if (user != null) {
				Hibernate.initialize(user.getRole());
			}

		} catch (Exception e) {
			log.error("Error get user by Id: " + id + e);
		}
		Hibernate.initialize(user.getRole());
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = new User();
		try {
			log.info("getUserById email: ", user);
			Query query = sessionFactory.getCurrentSession()
					.getNamedQuery(User.BY_EMAIL).setString("email", email);
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			log.error("Error get user by email: " + email + e);
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		try {
			log.info("get all users");
			Query query = sessionFactory.getCurrentSession().getNamedQuery(
					User.ALL_SORTED);
			users = query.list();
		} catch (Exception e) {
			log.error("Error get all users " + e);
		}
		return users;
	}

	@Override
	public Long getRowsCount() {
		Long rowsCount = null;
		try {
			rowsCount = (Long) sessionFactory.getCurrentSession()
					.createCriteria(User.class)
					.setProjection(Projections.rowCount()).uniqueResult();
		} catch (Exception e) {
			log.error("Error get rowsCount " + e);
		}

		return rowsCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getPagingUsers(int offset, int itemsPerPage,
			String sortingField, String order) {
		List<User> users = new ArrayList<>();

		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(User.class);
			if (sortingField != null && order.equals("asc")) {
				criteria.addOrder(Order.asc(sortingField));
			} else {
				criteria.addOrder(Order.desc(sortingField));
			}
			criteria.setFirstResult(offset);
			criteria.setMaxResults(itemsPerPage);
			users.addAll(criteria.list());
		} catch (Exception e) {
			log.error("Error getPagingUsers " + e);
		}
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> searchByKeyword(String keyword) {
		List<User> users = new ArrayList<>();
		if (!keyword.equals("")) {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(User.class);
			Disjunction or = Restrictions.disjunction();
			or.add(Restrictions.ilike("email", keyword, MatchMode.ANYWHERE));
			or.add(Restrictions.ilike("role", keyword, MatchMode.ANYWHERE));
			criteria.add(or);
			users.addAll(criteria.list());
		}
		return users;
	}

}
