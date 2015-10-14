package com.crsms.repository;

import java.util.List;

import com.crsms.domain.User;


public interface UserRepository {

	User save(User user);
		
	boolean delete(int id);

	User get(int id);
		
	User getByEmail(String email);
		
	List<User> getAll();
}
