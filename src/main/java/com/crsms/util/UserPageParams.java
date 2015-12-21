package com.crsms.util;

public class UserPageParams extends PageParams {
	private String email;

	public void setDefaultParams() {
		super.setDefaultParams();
		
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
