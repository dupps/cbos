<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CboS - Home</title>
	<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<style>
		.error {
			color: #ff0000;
		}
	</style>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="well"></div>
	<div class="container">
		<p>${message}</p>
	</div>

	<div class="container">
		<h1>Manage your pages</h1>
		<div class="col-md-6">
			<ul class="list-group">
				<li class="list-group-item">
					<h3>Add new page</h3>
					<form:form method="POST" action="admin" commandName="pageContainer">
						<form:input type="text" name="pagename" id="pagename" path="pageName" maxlength="100" class="form-control"
							placeholder="Enter page name..."/>
						<div>
							<form:errors path="pageName" cssClass="error" element="div" />
						</div>
						<input type="submit" class="btn btn-block btn-primary" value="Create new page"/>
					</form:form>
		        </li>
		        <li class="list-group-item">
		        	<h3>Manage Modules for page</h3>
					<ul class="list-group">
						<c:forEach var="page" items="${pages}">
							<li class="list-group-item">
								<a href="admin/page/${page.pageName}">${page.pageName}</a>
								<c:choose>
								    <c:when test="${page.pageName == 'home'}"></c:when>
								    <c:otherwise>
								    	<a href="admin/delete/${page.pageName}" class="pull-right error">Delete Page</a>
								    </c:otherwise>
								</c:choose>
							</li>
						</c:forEach>
					</ul>
		        </li>
		    </ul>
		</div>
	</div>
</body>
</html>