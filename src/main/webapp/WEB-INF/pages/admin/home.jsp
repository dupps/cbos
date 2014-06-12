<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CboS - Home</title>
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="well"></div>
	<div class="container">
		<h1>CboS</h1>
		<h3>CMS based on Spring.</h3>
		<p>${message}</p>
		<p><a href="admin/manageusers">Manage Users</a><p>
	</div>
	<div class="container">
		<p>Manage your pages:</p>
		<form:form method="POST" action="admin" commandName="pageContainer">
			<form:input type="text" name="pagename" id="pagename" path="pageName" maxlength="100" class="form-control"
				placeholder="Enter page name..."/>
			<input type="submit" class="btn btn-block btn-primary" value="Create new Page"/>
			<div>
				<form:errors path="pageName" />
			</div>
		</form:form>
		<br>
		<ul class="list-group">
			<c:forEach var="page" items="${pages}">
				<li class="list-group-item">
					<a href="admin/page/${page.pageName}">Manage Modules for page ${page.pageName}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>