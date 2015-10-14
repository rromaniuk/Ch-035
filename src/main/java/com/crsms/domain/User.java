package com.crsms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
@NamedQueries({
		@NamedQuery(name = User.DELETE, query = "DELETE FROM User aUser "
				+ "WHERE aUser.id= :id"),
		@NamedQuery(name = User.BY_EMAIL, query = "SELECT aUser FROM User aUser "
				+ "LEFT JOIN FETCH aUser.role WHERE aUser.email= :email"),
		@NamedQuery(name = User.GET_ALL, query = "SELECT aUser FROM User aUser "
				+ "LEFT JOIN FETCH aUser.roles ORDER BY aUser.name, aUser.email") })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User {
	public static final String DELETE = "User.delete";
	public static final String BY_EMAIL = "User.getByEmail";
	public static final String GET_ALL = "User.getAll";
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "email", nullable = false, unique = true)
	@Email
	@NotEmpty
	private String email;
	
	@Column(name = "password", nullable = false)
	@NotEmpty
	@Length(min = 6)
	private String password;
	
	@Column(name = "roles")
	@NotEmpty
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Role role;
	
	
	@Column(name = "roles")
	@NotEmpty
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private UserInfo userInfo;
	
	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User{" 
					
					+ ", email: " + getEmail()
					+ ", password: " + getPassword() 
					+ ", role: " + getRole()
					+ ", user info: " + getUserInfo()
					+ "}";
	}
	

}
