package com.crsms.service;

import java.util.List;

import com.crsms.domain.User;
import com.crsms.util.Invocable;
import com.crsms.util.PageParams;
/**
 * 
 * @author Roman Romaniuk
 *
 */
public interface UserService extends BaseService<User> {

	boolean isEmailExists(String email);
	
	User saveUser(User user);
	
	User saveUser(User user, boolean teacherRequest);
		
	User createAndSaveStudent(String email, String password);

	boolean changePassword(String email, String currentPassword, String newPassword);

	User getUserByEmail(String email);
	
	User getUserByEmail(String email, List<Invocable<User>> initializers);
	
	long getRowsCount(String keyWord);
	
	long getUsersToApproveCount();
	
	List<User> getPagingUsers(int offSet, int itemsPerPage,
							String sortingField, String order, String keyWord);
	
	List<User> getUsersToApprove(Boolean teacherRequest);

	List<User> getSearchResult(PageParams pageParams, String sortingField,
			String order, String keyWord);
	
}
