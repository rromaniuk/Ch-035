package com.crsms.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.crsms.repository.UserRepository;
import com.crsms.repository.UserRepositoryImpl;
import com.crsms.service.UserService;
import com.crsms.service.UserServiceImpl;

public class SpringMain {
	private static final Logger LOG = LoggerFactory.getLogger(SpringMain.class);

	public static void main(String[] args) {

		System.out.println("--------AnnotationConfigApplicationContext--------");
		// try (ConfigurableApplicationContext context = new
		// ClassPathXmlApplicationContext("spring/spring-app.xml") {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ApplicationContextConfig.class);
	
		context.refresh();

		UserService userRepository = context.getBean(UserServiceImpl.class);
		System.out.println(userRepository.getAll());

	}
}
