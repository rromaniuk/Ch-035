package com.crsms.service;

import java.util.List;

import com.crsms.domain.User;
import com.crsms.search.UserSearchParams;

public interface UserPaginatorService {

	List<User> getPaginatedResult(UserSearchParams params);

}
