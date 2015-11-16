
package com.crsms.service;

import java.util.List;

import com.crsms.domain.User;
import com.crsms.search.SearchParams;
import com.crsms.search.Paginator;
import com.crsms.search.UserSearchParams;
/**
 * 
 * @author Roman Romaniuk
 *
 */
public interface UserService {

	User saveUser(User user);
	
	User updateUser(User user);
	
	boolean changePassword(String email, String currentPassword, String newPassword);

	User getUserById(Long id);

	User getUserByEmail(String email);
	
	void delete(Long id);

	List<User> getAllUsers();
	
	Long getRowsCount();
	
	List<User> getPagingUsers(int startPosition, int itemsPerPage, String sortingField, String order);
	
	List<User> getAllWithInitializedCourses();

}
