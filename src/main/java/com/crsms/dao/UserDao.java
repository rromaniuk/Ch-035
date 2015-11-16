package com.crsms.dao;

import java.util.List;

import com.crsms.domain.User;
import com.crsms.search.SearchParams;
import com.crsms.search.UserSearchParams;

/**
 * 
 * @author Roman Romaniuk
 *
 */

public interface UserDao {

	User saveUser(User user);
	
	User getUserById(Long id);

	User getUserByEmail(String email);

	void delete(Long id);

	List<User> getAllUsers();
	
	Long getRowsCount();
	
//	List<User> getPagedUsers(UserSearchParams params);
	
	List<User> getPagingUsers(int startPosition, int itemsPerPage, String sortingField, String order);
	
	List <User> searchByKeyword(String keyword);

	List<User> getPagingUsers(UserSearchParams params);
}