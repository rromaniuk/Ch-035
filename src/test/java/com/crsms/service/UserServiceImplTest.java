package com.crsms.service;

import static org.testng.AssertJUnit.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crsms.domain.User;
import com.crsms.util.DbPopulator;

@ContextConfiguration({ "classpath:spring/spring-db.xml",
		"classpath:spring/spring-app.xml" })
public class UserServiceImplTest extends AbstractTestNGSpringContextTests {

	@Autowired
	protected UserService userService;

	@Autowired
	private DbPopulator dbPopulator;

	@BeforeMethod
	public void setUp() {
		dbPopulator.execute();
	}

	@Test
	public void delete() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getAll() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getByEmail() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getById() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void save() {
		User actual = userService.getById(UserTestData.testAdmin().getId());
		assertEquals(UserTestData.testAdmin(), actual);
	}

	@Test
	public void update() {
		throw new RuntimeException("Test not implemented");
	}
}
