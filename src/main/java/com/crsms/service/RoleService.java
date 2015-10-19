package com.crsms.service;

import java.util.List;

import com.crsms.domain.Role;
import com.crsms.util.NotFoundException;

public interface RoleService {

	Role save(Role role, Long userId) throws NotFoundException;
	
	void delete(Long id, Long userId) throws NotFoundException;
	
	Role getByName(String name)throws NotFoundException;
		
	List<Role> getAll() throws NotFoundException;
	
	public Role update(Role role, Long userId) throws NotFoundException;

}
