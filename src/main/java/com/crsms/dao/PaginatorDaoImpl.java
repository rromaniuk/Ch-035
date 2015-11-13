package com.crsms.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crsms.domain.User;
import com.crsms.search.AbstractSearchParams;
import com.crsms.search.UserSearchParams;

@Repository
public class PaginatorDaoImpl implements PaginatorDao {
	private static Logger log = LogManager.getLogger(PaginatorDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getPaginatedResult(AbstractSearchParams params) {
		List<User> users = new ArrayList<>();
		try {
			Criteria criteria = sessionFactory.getCurrentSession()
					.createCriteria(User.class);
			if (params.getSortField() != null
					&& params.getDirection().equals("asc")) {
				criteria.addOrder(Order.asc(params.getSortField()));
			} else {
				criteria.addOrder(Order.desc(params.getSortField()));
			}
			criteria.setFirstResult(params.getOffset());
			criteria.setMaxResults(params.getItemsPerPage());
			users.addAll(criteria.list());
		} catch (Exception e) {
			log.error("Error getPagingUsers " + e);
		}
		return users;
	}

}
