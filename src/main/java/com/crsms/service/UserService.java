
package com.crsms.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.crsms.domain.User;
import com.crsms.util.NotFoundException;

public interface UserService {
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    User save(User user);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id) throws NotFoundException;
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    User getById(Long id) throws NotFoundException;
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    User getByEmail(String email) throws NotFoundException;
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List <User> getAll() throws NotFoundException;
    
    void update(User user) throws NotFoundException;

	
}

