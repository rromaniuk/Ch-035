package com.crsms.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
public class Paginator<T> {
	private static Logger log = LogManager.getLogger(Paginator.class);

	private List<T> paginatedList = new ArrayList<T>();

	public List<T> getPaginatedResult(SearchParams params) {

		List<T> subList = new ArrayList<T>();
		int page = params.getPage();
		int itemsPerPage = params.getItemsPerPage();
		int pagesCount = (int) ((paginatedList.size() / itemsPerPage) 
				+ (paginatedList.size() % itemsPerPage > 0 ? 1 : 0));
		params.setPagesCount(pagesCount);
//		
//		if (page > pagesCount) {
//			page = 1;
//			params.setPage(page);
//			
//		}
		System.out.println("pagecount--------------------------" + params.getPagesCount());
		if (page <= 0 || page > pagesCount) {
			log.error("Page number must be > 0 or page number cannot be greater then pages count");
		}
		
		int offset = (page - 1) * itemsPerPage;
		int endIndex = offset + itemsPerPage;

		if (endIndex > this.paginatedList.size()) {
			endIndex = this.paginatedList.size();
		}
		for (int i = offset; i < endIndex; i++) {
			subList.add(this.paginatedList.get(i));
		}
		System.out.println("sublist" + subList);
		return subList;
	}
	

//	private int getPagesCount() {
//		if (searchResult == null || searchResult.size() == 0) {
//			return 0;
//		}
//		return (int) ((getRowsCount() / getItemsPerPage()) 
//				+ (getRowsCount() % getItemsPerPage() > 0 ? 1 : 0));
//	}
//
//	public List<T> getSearchResult() {
//		return searchResult;
//	}
//
//	public void refresh(SearchParams params) {
//		paginatedList = paginatorService.getPaginatedResult(params);		
//		
//	}
	
	public void setPaginatedList(List<T> paginatedList) {
		this.paginatedList = paginatedList;
	}
}
