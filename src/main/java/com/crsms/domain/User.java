package com.crsms.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.FIELD)
@Table(name = "users")
@NamedQueries({
		@NamedQuery(name = User.DELETE, query = "DELETE FROM User u "
				+ "WHERE u.id= :id"),
		@NamedQuery(name = User.GET_BY_EMAIL, query = "SELECT u FROM User u "
				+ "LEFT JOIN FETCH u.role LEFT JOIN FETCH u.userInfo WHERE u.email= :email"),
		@NamedQuery(name = User.GET_BY_ID, query = "SELECT u FROM User u "
				+ "LEFT JOIN FETCH u.role LEFT JOIN FETCH u.userInfo WHERE u.id= :id ORDER BY u.id"),
		@NamedQuery(name = User.GET_ALL, query = "SELECT u FROM User u "
				+ "LEFT JOIN FETCH u.role LEFT JOIN FETCH u.userInfo ORDER BY u.email") })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User {
	public static final String DELETE = "User.delete";
	public static final String GET_BY_EMAIL = "User.getByEmail";
	public static final String GET_ALL = "User.getAll";
	public static final String GET_BY_ID = "User.getById";

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

	@NotEmpty
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_info_id")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private UserInfo userInfo;

	@NotEmpty
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Role role;

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
		return "User{" + ", id: " + getId() + ", email: " + getEmail()
				+ ", password: " + getPassword() + ", role: " + getRole()
				+ ", user info: " + getUserInfo() + "}";
	}
}
