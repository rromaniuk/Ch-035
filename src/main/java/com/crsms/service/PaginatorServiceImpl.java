package com.crsms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crsms.dao.PaginatorDao;
import com.crsms.domain.User;
import com.crsms.search.Paginator;
import com.crsms.search.SearchParams;
import com.crsms.search.UserSearchParams;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class PaginatorServiceImpl<T> implements PaginatorService<T> {

	@Autowired
	private PaginatorDao<T> paginatorDao;

	@Autowired
	private Paginator<T> paginator;

	@Override
	public List<T> getPaginatedResult(SearchParams params) {
		List<T> result = null;
		result = paginatorDao.getPaginatedResult(params);
		System.out.println("dao" + result);
		paginator.setPaginatedList(result);
		result = paginator.getPaginatedResult(params);
		return result;
	}
}
