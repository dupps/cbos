<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CboS - Create a Module</title>
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
		<form:form method="POST" action="moduleForm" commandName="moduleContainer">
			<h1>Create Module</h1>
			<div class="form-group">
				<label class="control-label">Module Name *</label>
				<div class="controls">
					<form:input placeholder="Fill in module name..." name="modulename" id="modulename"
						path="moduleName" maxlength="100" class="form-control" type="text" />
					<div>
						<form:errors path="moduleName" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">Type *</label>
				<div class="controls">
					<form:input maxlength="100" name="type" id="type" path="type"
						placeholder="Choose type" class="form-control"
						type="text" />
					<div>
						<form:errors path="type" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">X coordinate</label>
				<div class="controls">
					<form:input maxlength="100" name="xKoord" id="xKoord" path="xKoord"
						placeholder="Set the x coordinate" class="form-control" type="text" />
					<div>
						<form:errors path="xKoord" />
					</div>
				</div>
			</div>
						<div class="form-group">
				<label class="control-label">Y coordinate</label>
				<div class="controls">
					<form:input maxlength="100" name="yKoord" id="yKoord" path="yKoord"
						placeholder="Set the y coordinate" class="form-control" type="text" />
					<div>
						<form:errors path="yKoord" />
					</div>
				</div>
			</div>
						<div class="form-group">
				<label class="control-label">Height</label>
				<div class="controls">
					<form:input maxlength="100" name="height" id="height" path="height"
						placeholder="Set the height" class="form-control" type="text" />
					<div>
						<form:errors path="height" />
					</div>
				</div>
			</div>
						<div class="form-group">
				<label class="control-label">Width</label>
				<div class="controls">
					<form:input maxlength="100" name="width" id="width" path="width"
						placeholder="Set width" class="form-control" type="text" />
					<div>
						<form:errors path="width" />
					</div>
				</div>
			</div>
			<input type="submit" value="Create" class="btn btn-primary" id="moduleForm" />
		</form:form>
	</div>
</body>
</html>