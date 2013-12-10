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
	<div class="container">
		<header>
			<ul class="nav navbar-nav pull-right">
				<li class="active"><a href="home.html">Home</a></li>
				<li><a href="register.html">Register</a></li>
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
	</div>
</body>
</html>