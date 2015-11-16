package com.crsms.service;

import java.util.List;

import com.crsms.domain.User;
import com.crsms.search.SearchParams;
import com.crsms.search.UserSearchParams;

public interface PaginatorService<T> {

	List<T> getPaginatedResult(SearchParams params);

}
