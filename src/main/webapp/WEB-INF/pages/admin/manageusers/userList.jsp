<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CboS - Manage Users</title>
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="menu1.jsp" %>
	<div class="well"></div>
	<div class="container">
		<p>${message}</p>
		<div class="col-md-6">
			<ul class="list-group">
				<a href="/CboS/admin/manageusers/add" class="btn btn-block btn-primary">Create new User</a>
				<li class="list-group-item">
					<ul class="list-group">
					<c:forEach var="User" items="${users}">
						<li class="list-group-item">
						 <a href="/CboS/admin/manageusers/${User.userName}">${User.userName}</a>
						</li>
					</c:forEach>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>