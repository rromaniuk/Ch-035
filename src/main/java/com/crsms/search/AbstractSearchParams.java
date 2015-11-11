package com.crsms.search;

import org.springframework.beans.factory.annotation.Autowired;

import com.crsms.dao.GenericDao;

public abstract class AbstractSearchParams<T> {
	
	private String direction = "asc";
	private Integer itemsPerPage = 4;
	private Integer rowsCount = null;

	@Autowired
	private GenericDao<T> genericDao;
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public Integer getRowsCount() {
		return genericDao.getRowsCount();
	}

	public void setRowsCount(Integer rowsCount) {
		this.rowsCount = rowsCount;
	}
}
