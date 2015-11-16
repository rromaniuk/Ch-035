<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var = "order" value = "asc"/>
<c:if test="${sessionScope['scopedTarget.UserSearchParams'].direction == null || sessionScope['scopedTarget.UserSearchParams'].direction == 'asc'}">
<c:set var = "order" value = "desc"/>
</c:if>
<c:if test="${!empty users}">
<nav class="navbar navbar-default">
    <div class="container-fluid">
       <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Find</button>
      </form>
      <div class="nav navbar-nav navbar-right">
								<label for="pageSize">Rows:</label> 
									<select id="pageSize" class="form-control input-sm" >
											<option value="3"><c:out value="${sessionScope['scopedTarget.userSearchParams'].page}" /></option>
											<option value="5">5</option>
											<option value="10">10</option>
											<option value="15">15</option>
									</select>
								</div>
    </div>
</nav>
	<table class="table table-bordered table-hover">
		<thead>
			<tr class="success">
				<th ><spring:message code="crsms.text.id" /></th>
				<th> <spring:message code="crsms.admin.email" />
					<a href="<c:url value="?page=${page}
											&sortparam=${email}
											&direction=${order}"/>">
					<i class="glyphicon glyphicon-sort" aria-hidden="true"></i>
					</a>
				</th>
				<th><spring:message code="crsms.admin.password" /></th>
				<th><spring:message code="crsms.admin.role" />
					<a href="<c:url value="?page=${page}
											&sortparam=${role}
											&direction=${order}"/>">
					<i class="glyphicon glyphicon-sort" aria-hidden="true"></i>
					</a>
				</th>
				<th colspan="2"><spring:message code="crsms.admin.management" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr class="active">
					<th >${user.id}</th>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td>${user.role.name}</td>
					<td class="managementCell">
						<c:url var="editUser"	value="edit/${user.id}" /> 
							<a href="${editUser}" class="btn btn-success btn-sm" 
								data-toggle="tooltip"
								title="<spring:message code="crsms.button.edit" />">
								<span	class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</a>
					</td>
					<td class="managementCell">
						<c:url var="deleteUser"	value="delete/${user.id}" /> 
							<a href="${deleteUser}"
								class="btn btn-danger btn-sm" 
								data-toggle="tooltip"
								title="<spring:message code="crsms.button.delete" />"> 
								<span	class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>

<!-- Paging block -->
<div class="paginationlogic">
	<ul class="pagination">
		<c:choose>
			<c:when test="${page == 1}">
				<li class="disabled">
					<a href="<c:url value="#"/>" 
						data-toggle="tooltip"
						title="<spring:message code="crsms.paginationlogic.tooltip.first" />"> 
						<spring:message	code="crsms.paginationlogic.navigation.first" />
					</a>
				</li>
				<li class="disabled">
					<a href="<c:url value="#"/>" 
						data-toggle="tooltip"
						title="<spring:message code="crsms.paginationlogic.tooltip.previous" />"> 
						<spring:message	code="crsms.paginationlogic.navigation.previous" />
					</a>
				</li>
			</c:when>
			<c:when test="${page > 1}">
				<li>				
					<a href="<c:url value="/admin?page=${1}&sortparam=${sessionScope['sortparam']}
											&direction=${sessionScope['direction']}"/>" 
						data-toggle="tooltip"
						title="<spring:message code="crsms.paginationlogic.tooltip.first" />"> 
						<spring:message	code="crsms.paginationlogic.navigation.first" />
					</a>
				</li>
				<li>
					<a	href="<c:url value="/admin?page=${page - 1}
											&sortparam=${sessionScope['sortparam']}
											&direction=${sessionScope['direction']}"/>" 
						data-toggle="tooltip"
						title="<spring:message code="crsms.paginationlogic.tooltip.previous" />"> 
						<spring:message	code="crsms.paginationlogic.navigation.previous" />
					</a>
				</li>
			</c:when>
		</c:choose>
			<c:forEach var="p" begin="1" end="${pagesCount}">
				<li	<c:choose>
						<c:when test="${p == page}"> 
							class = "active"
						</c:when>
					</c:choose>>
					<a href="<c:url value="/admin?page=${p}&sortparam=${sessionScope['sortparam']}
											&direction=${sessionScope['direction']}"/>">
						<c:out	value="${p}"/>
					</a>
				</li>			
			</c:forEach>
			<c:choose>
			<c:when test="${page == pagesCount}">
				<li class="disabled">
					<a	href="<c:url value="#"/>"	
						data-toggle="tooltip"
						title="<spring:message code="crsms.paginationlogic.tooltip.next" />"> 
						<spring:message	code="crsms.paginationlogic.navigation.next" />
					</a>
				</li>
				<li class="disabled">
					<a href="<c:url value="#"/>" 
						data-toggle="tooltip"
						title="<spring:message code="crsms.paginationlogic.tooltip.last" />"> 
						<spring:message	code="crsms.paginationlogic.navigation.last" />
					</a>
				</li>
			</c:when>		
			<c:when test="${page < pagesCount}">
				<li>
					<a	href="<c:url value="/admin?page=${page + 1}&sortparam=${sessionScope['sortparam']}
											&direction=${sessionScope['direction']}"/>" 
						data-toggle="tooltip"
						title="<spring:message code="crsms.paginationlogic.tooltip.next" />">
					 	<spring:message	code="crsms.paginationlogic.navigation.next" />
					</a>
				</li>
				<li>
					<a href="<c:url value="/admin?page=${pagesCount}&sortparam=${sessionScope['sortparam']}
											&direction=${sessionScope['direction']}"/>"  
						data-toggle="tooltip"
						title="<spring:message code="crsms.paginationlogic.tooltip.last" />"> 
						<spring:message	code="crsms.paginationlogic.navigation.last" />
					</a>
				</li>
			</c:when>
		</c:choose>
	</ul>
</div>
<!-- End Paging block -->

<c:url var="createUser" value="adduser" />
<a class="btn btn-success" href="${pageContext.request.contextPath}/signUp"><spring:message
		code="crsms.admin.createNew" /></a>
		


