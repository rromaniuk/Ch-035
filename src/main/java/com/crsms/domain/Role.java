package com.crsms.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.FIELD)
@Table(name = "roles")
@NamedQueries({
		@NamedQuery(name = Role.DELETE, query = "DELETE FROM Role r WHERE r.id=:id AND r.user.id = :userId"),
		@NamedQuery(name = Role.ALL_SORTED, query = "FROM Role r ORDER BY r.name"),
		@NamedQuery(name = Role.BY_NAME, query = "FROM Role r WHERE r.name= :name") })
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String DELETE = "Role.delete";
	public static final String ALL_SORTED = "Role.getAllSorted";
	public static final String BY_NAME = "Role.Name";
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	private User user;

	public Role() {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role{" + ", id: " + getId() + ", name: " + getName() + "}";
	}
}
