package com.crsms.repository;

import java.util.List;

import com.crsms.domain.User;


public interface UserRepository {

	User save(User user);
		
	void delete(Long id);

	User getById(Long id);
		
	User getByEmail(String email);
		
	List<User> getAll();
}
