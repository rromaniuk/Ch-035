package com.crsms.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.crsms.dao.GenericDaoImpl;

public abstract class AbstractSearchResult<T> {
	private static Logger log = LogManager
			.getLogger(AbstractSearchResult.class);

	List<T> result = new ArrayList<T>();

	@Autowired
	private AbstractSearchParams<T> abstractSearchParams;

	public int getItemsPerPage() {
		return abstractSearchParams.getItemsPerPage();
	}

	public int getRowsCount() {
		return abstractSearchParams.getRowsCount();
	}

	public String getDirection() {
		return abstractSearchParams.getDirection();
	}

	public List<T> getResult(int page) {

		List<T> subList = new ArrayList<T>();

		if (page <= 0 || page > getPagesCount()) {
			log.error("Page number must be > 0 or page number cannot be greater then pages count");
		}

		int start = (page - 1) * getItemsPerPage();
		int end = start + getItemsPerPage();

		if (end > this.result.size()) {
			end = this.result.size();
		}
		for (int i = start; i < end; i++) {
			subList.add(this.result.get(i));
		}
		return subList;
	}

	private int getPagesCount() {
		if (result == null || result.size() == 0) {
			return 0;
		}
		return (getRowsCount() / getItemsPerPage())
				+ (getRowsCount() % getItemsPerPage() > 0 ? 1 : 0);
	}
}
