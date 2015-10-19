package com.crsms.repository;

import java.util.List;

import com.crsms.domain.Role;
import com.crsms.domain.User;

public interface RoleRepository {

	Role save(Role role, Long userId);
	
	void delete(Long id, Long userId);
	
	Role getByName(String name);
		
	List<Role> getAll();
	

}
