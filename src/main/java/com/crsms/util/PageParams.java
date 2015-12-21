package com.crsms.util;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class PageParams {

	private Integer page;
	private Integer itemsPerPage;
	private String order;
	private Integer lastPage;
	private Long rowsCount; 
	private Integer offset;
	
	 public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Boolean checkIsEmptyParams() {
			return page == null ||	itemsPerPage == null || order == null; 
		}
	 
	 public void setDefaultParams() {
	    	page = 1;
	    	itemsPerPage = 6;
	    	order = "asc";
	    }
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getItemsPerPage() {
		return itemsPerPage;
	}
	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}
	public Integer getLastPage() {
		return lastPage;
	}
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	public Long getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(Long rowsCount) {
		this.rowsCount = rowsCount;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
	
	
	
	

}
