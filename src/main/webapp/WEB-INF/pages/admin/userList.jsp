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
	<div class="container">
		<header>
			<ul class="nav navbar-nav pull-right">
				<li class="active"><a href="home.html">Home</a></li>
				<li><a href="j_spring_security_logout">Logout</a></li>
				<li><a href="https://github.com/dupps/CboS">Github</a></li>
				<li><a href="mailto:cbos@dupps.it">Contact</a></li>
			</ul>
		</header>
	</div>
	<div class="well"></div>
	<div class="container">
		<p>${message}</p>
		<a href="/CboS/admin/manageusers/add" class="btn btn-block btn-primary"> Create new User</a>
		<br/>
		<ul class="list-group">
		<c:forEach var="User" items="${users}">
			<li class="list-group-item">
			 <a href="/CboS/admin/manageusers/${User.userName}">${User.userName}</a></td>
			</li>
		</c:forEach>
		</ul>
	</div>
</body>
</html>