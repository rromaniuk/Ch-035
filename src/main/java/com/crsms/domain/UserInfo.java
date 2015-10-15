package com.crsms.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.FIELD)
@Table(name = "userinfo")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserInfo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@NotEmpty
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	/*Set<Group> groups;*/
	
	public UserInfo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "UserInfo{" 
					+ ", id: " + getId()
					+ ", name: " + getFirstName()
					+ ", lastname: " + getLastName()
					+ "}";
	}
}

