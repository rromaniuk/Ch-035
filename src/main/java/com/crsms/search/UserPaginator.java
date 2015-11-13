package com.crsms.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crsms.domain.User;

//@Scope(value ="session")
public class UserPaginator {
	
//	@Autowired
//	private UserSearchParams userSearchParams;
//	
//	public UserPaginator sessionParams(){
//	Long rowsCount = userSearchParams.getRowsCount();
//	int offset = userSearchParams.getOffset();
//	int lastpage = (int) (rowsCount / userSearchParams.getItemsPerPage());
//	if (rowsCount > (lastpage * userSearchParams.getItemsPerPage())) {
//		lastpage++;
//	}
//	
//	if (session.getAttribute("direction") == null) {
//		session.setAttribute("direction", direction);
//	}
//
//	String order = (String) session.getAttribute("direction");
//	if (session.getAttribute("sortparam") != null ) {
//		order = direction;
//		session.setAttribute("direction", order);
//	} 
//	
//	String sortingField = (String) session.getAttribute("sortparam");
//	if (sortingField == null) {
//		session.setAttribute("sortparam", sortParam);
//		sortingField = (String) session.getAttribute("sortparam");
//	} else {
//		session.setAttribute("sortparam", sortParam);
//		sortingField = (String) session.getAttribute("sortparam");
//	}
//	
//	
//	System.out.println("startposition in getPagingUsers: " + offset);
//	System.out.println("sortingField in getPagingUsers: " + sortingField);
//	System.out.println("order in getPagingUsers: " + order);
//	
//	
//	}

	
}
