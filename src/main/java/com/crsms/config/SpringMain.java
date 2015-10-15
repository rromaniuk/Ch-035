package com.crsms.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.crsms.domain.Role;
import com.crsms.domain.User;
import com.crsms.domain.UserInfo;
import com.crsms.service.UserService;
import com.crsms.service.UserServiceImpl;
import com.crsms.service.UserTestData;


public class SpringMain {

	public static void main(String[] args) {
//		
//		UserInfo userInfo = new UserInfo();
//		userInfo.setId((long) 1);
//		userInfo.setFirstName("Admin");
//		userInfo.setLastName("Adminov");
//		
//		Role role = new Role();
//		role.setId((long) 1);
//		role.setName("ROLE_ADMIN");
//		
//		User user = new User();
//		user.setId((long) 1);
//		user.setEmail("admin@gmail.com");
//		user.setPassword("admin");
//		user.setRole(role);
//		user.setUserInfo(userInfo);
//		
		

		System.out.println("--------GenericXmlApplicationContext--------");
		// try (ConfigurableApplicationContext context = new
		// ClassPathXmlApplicationContext("spring/spring-app.xml") {
		try (GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext()) {
			context.load("spring/spring-app.xml", "spring/spring-db.xml");
			context.refresh();
//			System.out.println("\n"
//					+ Arrays.toString(context.getBeanDefinitionNames()) + "\n");
//			UserService userService =(UserService)context.getBean(UserServiceImpl.class);
//			System.out.println(userService.getById(user.getId()));
//			
		}
	}
}
