<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CboS - Add User</title>
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="well"></div>
	<div class="container">
		<form:form method="POST" action="add" commandName="userDummy">
			<h1>Add User</h1>
			<div class="form-group">
				<label class="control-label">Name *</label>
				<div class="controls">
					<form:input placeholder="Fill in Username..." name="username" id="username"
						path="userName" maxlength="100" class="form-control" type="text" />
					<div>
						<form:errors path="userName" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">E-Mail *</label>
				<div class="controls">
					<form:input maxlength="100" name="email" id="email" path="email"
						placeholder="Enter correct E-Mail-Address..." class="form-control"
						type="email" />
					<div>
						<form:errors path="email" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">City</label>
				<div class="controls">
					<form:input maxlength="100" name="city" id="city" path="city"
						placeholder="Enter your city..." class="form-control" type="text" />
					<div>
						<form:errors path="city" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label">Birthday</label>
				<div class="controls">
					<form:input maxlength="100" name="birth" id="birthday" path="birthday"
						placeholder="Enter date of birth..." class="form-control" type="text" />
					<div>
						<form:errors path="birthday" />
					</div>
				</div>
			</div>
			<input type="submit" value="Add" class="btn btn-primary" id="Add" />
		</form:form>
	</div>
</body>
</html>