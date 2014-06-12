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
		<p><a href="admin/manageusers">Manage Users</a><p>
	</div>
	<div class="container">
		<h1>Manage your pages</h1>
		<h3>Add new page</h3>
		<form:form method="POST" action="admin" commandName="pageContainer">
			<form:input type="text" name="pagename" id="pagename" path="pageName" maxlength="100" class="form-control"
				placeholder="Enter page name..."/>
			<div>
				<form:errors path="pageName" cssClass="error" element="div" />
			</div>
			<input type="submit" class="btn btn-block btn-primary" value="Create new page"/>
		</form:form>
		<br>
		<h3>Manage Modules for page</h3>
		<ul class="list-group">
			<c:forEach var="page" items="${pages}">
				<li class="list-group-item">
					<a href="admin/page/${page.pageName}">${page.pageName}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>