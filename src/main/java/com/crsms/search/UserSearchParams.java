package com.crsms.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.crsms.domain.Role;
import com.crsms.service.UserService;

@Component
//@Scope(value ="session")
public class UserSearchParams extends AbstractSearchParams {
	
	@Autowired
	private UserService userService;
	private String email;
	private Role role;
	private Long rowsCount; 
	
	public void setDefaults() {
    	super.setDefaults();
		setSortField("email");
		setSortField(role.getName());
    	email = null;
    }
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public Long getRowsCount() {
		return userService.getRowsCount();
	}
}
