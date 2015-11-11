package com.crsms.search;

import com.crsms.domain.User;

public class UserSearchParams extends AbstractSearchParams<User> {

	public enum UserSearchType {
		BY_EMAIL, BY_ROLE
	};

	private UserSearchType searchType = UserSearchType.BY_EMAIL;
	private int id;
	private String email;

	public UserSearchType getSearchType() {
		return searchType;
	}

	public void setSearchType(UserSearchType searchType) {
		this.searchType = searchType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
