
package com.crsms.search;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.crsms.dao.UserDao;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SearchParams {

	private static final Integer DEFAULTITEMSPERPAGE = 4;
	private Integer page;
	private Integer itemsPerPage;
	private Integer pagesCount;
	private Integer offSet;
	private String sortField;
	private String direction;

	public Boolean isEmpty() {
		return direction == null || page == null || itemsPerPage == null;
	}

	public void setDefaults() {
		direction = "asc";
		page = 1;
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
		return  (page - 1) * getItemsPerPage();
	}

	public int getPagesCount() {
		return pagesCount;
	}

	public void setPagesCount(Integer pagesCount) {
		this.pagesCount = pagesCount;
	}

}
