package com.crsms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crsms.dao.PaginatorDao;
import com.crsms.domain.User;
import com.crsms.search.UserSearchParams;

@Service
public class UserPaginatorServiceImpl implements UserPaginatorService {
	
	@Autowired
	private PaginatorDao paginatorDao;

	@Override
	public List<User> getPaginatedResult(UserSearchParams params) {
		return paginatorDao.getPaginatedResult(params);
	}
}
