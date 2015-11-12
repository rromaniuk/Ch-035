package com.crsms.search;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.crsms.domain.Role;

@Component
@Scope(value ="session")
public class UserSearchParams extends AbstractSearchParams {

	public enum SearchField {
		BY_EMAIL, BY_ROLE
	};

	private SearchField emailField = SearchField.BY_EMAIL;
	private String email;
	private Role role;
	

	public SearchField getSearchField() {
		return emailField;
	}

	public void setSearchField(SearchField searchField) {
		this.emailField = searchField;
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

}
