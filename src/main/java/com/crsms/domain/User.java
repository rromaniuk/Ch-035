package com.crsms.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.crsms.domain.Role;

@Entity
@Access(AccessType.FIELD)
@Table(name = "users")
@NamedQueries({
		@NamedQuery(name = User.DELETE, query = "DELETE FROM User u "
				+ "WHERE u.id= :id"),
		@NamedQuery(name = User.GET_BY_EMAIL, query = "SELECT u FROM User u "
				+ "LEFT JOIN FETCH u.roles LEFT JOIN FETCH u.userInfo WHERE u.email= :email"),
		@NamedQuery(name = User.GET_BY_ID, query = "SELECT u FROM User u "
				+ "LEFT JOIN FETCH u.roles LEFT JOIN FETCH u.userInfo WHERE u.id= :id ORDER BY u.id"),
		@NamedQuery(name = User.GET_ALL, query = "SELECT u FROM User u "
				+ "LEFT JOIN FETCH u.roles LEFT JOIN FETCH u.userInfo ORDER BY u.email") })
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

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@NotEmpty
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_info_id")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private UserInfo userInfo;

	@NotEmpty
	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = { 
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, 
			inverseJoinColumns = {@JoinColumn(name = "role_id", 
								referencedColumnName = "id") })
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<Role> roles = new HashSet<Role>();

	public User() {
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Set<Role> getRole() {
		return this.roles;
	}

	public void addRole(Role role) {
		roles.add(role);
	}

	@Override
	public String toString() {
		return "User{" + ", id: " + getId() + ", email: " + getEmail()
				+ ", password: " + getPassword() + ", role: " + getRole()
				+ ", user info: " + getUserInfo() + "}";
	}
}
