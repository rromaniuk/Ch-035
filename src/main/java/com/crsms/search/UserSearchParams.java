package com.crsms.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.crsms.domain.Role;
import com.crsms.service.UserService;

@Component
public class UserSearchParams extends SearchParams {
	
	@Autowired
	private UserService userService;
	private String email;
	private String role;
//	private Long rowsCount;
	
	public void setDefaults() {
    	super.setDefaults();
		setSortField("email");
    }
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Long getRowsCount() {
//		return userService.getRowsCount();
//	}
}
