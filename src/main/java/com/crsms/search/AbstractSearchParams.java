package com.crsms.search;

import org.springframework.beans.factory.annotation.Autowired;

import com.crsms.dao.UserDao;

public abstract class AbstractSearchParams {
	
	private String direction = "asc";
	private final Integer itemsPerPage = 4;
	private Long rowsCount = null;

	@Autowired
	private UserDao userDao;
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getItemsPerPage() {
		return itemsPerPage;
	}

	public Long getRowsCount() {
		return userDao.getRowsCount();
	}
}
