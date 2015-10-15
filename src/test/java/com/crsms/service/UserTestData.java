package com.crsms.service;

import java.util.EnumSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crsms.domain.Role;
import com.crsms.domain.User;
import com.crsms.domain.UserInfo;

@Service
public class UserTestData {

	
//	public static final User ADMIN = new TestUser(1,"admin", "adminLastName", 
//			"admin@gmail.com", "admin", Role.ROLE_ADMIN);
//
//	public static final User STUDENT = new TestUser(2,"student", "studentLastName", 
//			"student@gmail.com", "student", Role.ROLE_STUDENT);
//	public static final User NEW_USER = new TestUser("new admin", "new adminLastName", 
//			"new_admin@gmail.com", "new_admin", Role.ROLE_ADMIN);
		
				  
		public static User testAdmin() {
			
			UserInfo userInfo = new UserInfo();
			userInfo.setId((long) 1);
			userInfo.setFirstName("Admin");
			userInfo.setLastName("Adminov");
			
			Role role = new Role();
			role.setId((long) 1);
			role.setName("ROLE_ADMIN");
			
			User user = new User();
			user.setId((long) 1);
			user.setEmail("admin@gmail.com");
			user.setPassword("admin");
			user.setRole(role);
			user.setUserInfo(userInfo);
	
			return user;
		}

		
}
