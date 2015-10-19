package com.crsms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.crsms.domain.Role;
import com.crsms.domain.User;
import com.crsms.domain.UserInfo;
import com.crsms.service.RoleService;
import com.crsms.service.UserInfoService;
import com.crsms.service.UserService;

public class SpringMain {
	private static final Logger LOG = LoggerFactory.getLogger(SpringMain.class);

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		User newUser = new User();
		newUser.setEmail("newEmail@gmail.com");
		newUser.setPassword("newPassword");
		newUser.setEnabled(true);
		
		Role role = new Role();
		role.setName("ADMIN");
		
		UserInfo ui = new UserInfo();
		ui.setFirstName("newFirstName");
		ui.setLastName("newLastName");
		
		
		System.out.println("--------AnnotationConfigApplicationContext--------");
		
		UserService userService = context.getBean(UserService.class);
		RoleService roleService = context.getBean(RoleService.class);
		UserInfoService userInfoService = context.getBean(UserInfoService.class);
		
		userService.save(newUser);
		System.out.println("--------new user--------" + userService.getByEmail("newEmail@gmail.com"));
		
		User updateStudent = userService.getByEmail("student@gmail.com");
		updateStudent.setPassword("dsfhsdklgkldfgdflkghdfkhg");
		userService.update(updateStudent);
		System.out.println("--------updated student--------" + userService.getByEmail("student@gmail.com"));
		
		roleService.save(role, userService.getByEmail("student@gmail.com").getId());	
		System.out.println("--------updated student role--------" + userService.getByEmail("student@gmail.com"));

		userInfoService.save(ui,userService.getByEmail("newEmail@gmail.com").getId());
		System.out.println("--------updated new user userInfo--------" + userService.getByEmail("newEmail@gmail.com"));


		
		//		System.out.println(service.getAll());
	
		
	}
}
