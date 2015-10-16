
package com.crsms.service;

import java.util.List;

import com.crsms.domain.User;
import com.crsms.util.NotFoundException;

public interface UserService {

    User save(User user);

    void delete(Long id) throws NotFoundException;

    User getById(Long id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;
    
    List <User> getAll() throws NotFoundException;;
    
    void update(User user) throws NotFoundException;

	
}

