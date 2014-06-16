<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CboS - Registered successfully</title>
<link rel="stylesheet"
    href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="menu2.jsp" %>
    <div class="well"></div>
    <div class="container">
		<p>Thank you for registering!</p>
		<p>${message}</p>
	   	<div>
			<a href="./" class="btn pull-left btn-default">Go back to home</a>
			&nbsp;<a href="user" class="btn btn-success">Login</a>
	   	</div>
	</div>
</body>
</html>