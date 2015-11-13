package com.crsms.dao;

import java.util.List;

import com.crsms.domain.User;
import com.crsms.search.AbstractSearchParams;
import com.crsms.search.UserSearchParams;

public interface PaginatorDao {
//	List<User> getPaginatedResult(UserSearchParams params);

	List<User> getPaginatedResult(AbstractSearchParams params);
}
