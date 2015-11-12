package com.crsms.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractSearchResult<T> {
	private static Logger log = LogManager
			.getLogger(AbstractSearchResult.class);

	private List<T> searchResult = new ArrayList<T>();
	private Integer rowsCount = null;

	@Autowired
	private AbstractSearchParams abstractSearchParams;

	public List<T> getSearchResult() {
		return searchResult;
	}

	public int getItemsPerPage() {
		return abstractSearchParams.getItemsPerPage();
	}

	public Long getRowsCount() {
		return abstractSearchParams.getRowsCount();
	}

	private void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

	public List<T> getResult(int page) {

		List<T> subList = new ArrayList<T>();

		if (page <= 0 || page > getPagesCount()) {
			log.error("Page number must be > 0 or page number cannot be greater then pages count");
		}

		int offset = (page - 1) * getItemsPerPage();
		int end = offset + getItemsPerPage();

		if (end > this.searchResult.size()) {
			end = this.searchResult.size();
		}
		for (int i = offset; i < end; i++) {
			subList.add(this.searchResult.get(i));
		}
		return subList;
	}

	private int getPagesCount() {
		if (searchResult == null || searchResult.size() == 0) {
			return 0;
		}
		return (int) ((getRowsCount() / getItemsPerPage())
				+ (getRowsCount() % getItemsPerPage() > 0 ? 1 : 0));
	}

	public void setSearchResult(List<T> aSearchResult) {
		if (aSearchResult == null) {
		 aSearchResult = new ArrayList<T>();
		}
		this.searchResult = aSearchResult;
		this.setRowsCount(searchResult.size());
	}
}
