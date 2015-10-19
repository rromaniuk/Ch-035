package com.crsms.domain;

import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.FIELD)
@Table(name = "userinfo")
@NamedQueries({
		@NamedQuery(name = UserInfo.DELETE, query = "DELETE FROM UserInfo u WHERE u.id=:id AND u.user.id = :userId"),
		@NamedQuery(name = UserInfo.BY_USER_ID, query = "FROM UserInfo u WHERE u.id= :id AND u.user.id = :userId"),
		@NamedQuery(name = UserInfo.ALL_SORTED, query = "FROM UserInfo u ORDER BY u.firstName, u.lastName") })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserInfo {

	private static final long serialVersionUID = 1L;
	public static final String DELETE = "UserInfo.delete";
	public static final String ALL_SORTED = "UserInfo.getAllSorted";
	public static final String BY_USER_ID = "UserInfo.getByUserId";

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotEmpty
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotEmpty
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	@Transient
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Group> groups;

	public UserInfo() {
		super();
	}

	public Long getId() {
		return userId;
	}

	public void setId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// public Set<Group> getGroups() {
	// return groups;
	// }
	//
	// public void setGroups(Set<Group> groups) {
	// this.groups = groups;
	// }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserInfo{" + ", id: " + getId() + ", firstName: " + getFirstName()
				+ ", lastName: " + getLastName() + "}";
	}
}
