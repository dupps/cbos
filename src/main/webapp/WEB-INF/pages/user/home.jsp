<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CboS - Home</title>
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
		<h1>CboS</h1>
		<h3>CMS based on Spring.</h3>
		<p>${message}</p>
		<% if (request.isUserInRole("ROLE_ADMIN")) { %>
		<a href="<c:url value='/admin' />">Admin Area</a>
		<% } %>
	</div>
</body>
</html>