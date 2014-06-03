<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<p><a href="admin/manageusers/">Manage Users</a><p><!-- Dead Link -->
		<p><a href="admin/managemodules/">Manage Modules</a><p>
	</div>
</body>
</html>