package com.crsms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crsms.domain.Role;
import com.crsms.repository.RoleRepository;
import com.crsms.util.NotFoundException;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository repository;

	@Override
	@Transactional
	public Role save(Role role, Long userId) throws NotFoundException {
		return repository.save(role, userId);
	}

	@Override
	@Transactional
	public void delete(Long id, Long userId) throws NotFoundException {
		repository.delete(id, userId);
	}

	@Override
	public Role getByName(String name) throws NotFoundException {
		return repository.getByName(name);
	}

	@Override
	public List<Role> getAll() throws NotFoundException {
		return repository.getAll();
	}

	@Override
	@Transactional
	public Role update(Role role, Long userId) throws NotFoundException {
		return repository.save(role, userId);
	}
	
}
