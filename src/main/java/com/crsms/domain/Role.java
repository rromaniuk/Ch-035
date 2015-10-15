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
@Table(name = "roles")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	@Column(name = "name", nullable = false)
	private String name;
	
	public Role() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role{" 
					+ ", id: " + getId()
					+ ", name: " + getName()
					+ "}";
	}
}
