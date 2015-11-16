package com.crsms.dao;

import java.util.List;

import com.crsms.domain.User;
import com.crsms.search.SearchParams;
import com.crsms.search.UserSearchParams;

public interface PaginatorDao<T> {
//	List<User> getPaginatedResult(UserSearchParams params);

	List<T> getPaginatedResult(SearchParams params);
}
