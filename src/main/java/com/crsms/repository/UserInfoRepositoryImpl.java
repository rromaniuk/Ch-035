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

import com.crsms.domain.User;
import com.crsms.domain.UserInfo;
@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {
	private static final Logger LOG = LoggerFactory
			.getLogger(UserInfoRepositoryImpl.class);

	

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public UserInfo save(UserInfo userInfo, Long userId) {
		Session session =sessionFactory.openSession();
		User ref = (User) session.byId(User.class).getReference(userId);
		session.close();
		userInfo.setUser(ref);
		if (userInfo.getId() == null) {
			sessionFactory.getCurrentSession().save(userInfo);
		} else {
			if (getByUserId(userInfo.getId(), userId) == null)
				return null;
			sessionFactory.getCurrentSession().update(userInfo);
		}
	
		return userInfo;
	}

	@Override
	public void delete(Long id, Long userId) {
		Query query = sessionFactory.getCurrentSession()
				.getNamedQuery(UserInfo.DELETE).setLong("id", id)
				.setLong("user_id", userId);
		query.executeUpdate();

	}

	@Override
	public UserInfo getByUserId(Long id, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> getAll() {
		Query query = sessionFactory.getCurrentSession().getNamedQuery(
				UserInfo.ALL_SORTED);
		return query.list();
	}
}
