package com.crsms.service;

import com.crsms.domain.User;
import com.crsms.repository.UserRepository;
import com.crsms.util.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	public User save(User user) {
		return repository.save(user);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public User getById(Long id) throws NotFoundException {
		return repository.getById(id);
	}

	public User getByEmail(String email) throws NotFoundException {
		return repository.getByEmail(email);
	}

	public List<User> getAll() {
		return repository.getAll();
	}

	public void update(User user) throws NotFoundException {
		repository.save(user);
	}
}
