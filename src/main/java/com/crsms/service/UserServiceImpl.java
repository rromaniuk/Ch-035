package com.crsms.service;

import com.crsms.config.SpringMain;
import com.crsms.domain.User;
import com.crsms.repository.UserRepository;
import com.crsms.util.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	private static final Logger LOG = LoggerFactory.getLogger(SpringMain.class);

	@Autowired
	private UserRepository repository;

	@Transactional
	public User save(User user) {
		return repository.save(user);
	}

	@Transactional
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

	@Transactional
	public void update(User user) throws NotFoundException {
		repository.save(user);
	}
}
