package com.crsms.search;

public abstract class AbstractSearchParams {

	private static final Integer DEFAULTITEMSPERPAGE = 4;
	private String direction;
	private Integer page;
	private String sortField;
	private Integer itemsPerPage;
	
	public Boolean isEmpty() {
		return direction == null || page == null || sortField == null;
	}

	public void setDefaults() {
		direction = "asc";
		page = 1;
		sortField = "email";
		itemsPerPage = DEFAULTITEMSPERPAGE;
	}

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

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public int getOffset() {
		return (this.getPage() - 1) * this.getItemsPerPage();
	}

	public void setOffSet(Integer offSet) {
	}

	public abstract Long getRowsCount();
}
