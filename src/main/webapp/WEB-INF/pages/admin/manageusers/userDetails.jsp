<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CboS - User details</title>
	<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	 <script>
		$(function() {
			$("#birthday").datepicker({
				changeMonth: true,
				changeYear: true
			});
		});
	</script>
	<style>
		.error { color: #ff0000; }
	</style>
</head>
<body>
	<%@ include file="menu2.jsp"%>
	<div class="well"></div>
	<div class="container">
		<form:form method="POST" action="../manageusers/update"
			commandName="userDummy">
			<h1>Edit User</h1>
			<div class="col-md-6">
				<ul class="list-group">
					<li class="list-group-item">
						<div class="form-group">
							<label class="control-label">Name *</label>
							<div class="controls">
								<form:input value="${user.userName}" name="username" id="username"
									path="userName" maxlength="100" class="form-control" type="text" readonly="${true}"/>
								<div>
									<form:errors path="userName" cssClass="error" element="div" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">E-Mail *</label>
							<div class="controls">
								<form:input maxlength="100" name="email" id="email" path="email"
									value="${user.email}" class="form-control" type="email" />
								<div>
									<form:errors path="email" cssClass="error" element="div" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">City</label>
							<div class="controls">
								<form:input maxlength="100" name="city" id="city" path="city"
									value="${user.city}" class="form-control" type="text" />
								<div>
									<form:errors path="city" cssClass="error" element="div" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label">Birthday</label>
							<div class="controls">
								<form:input maxlength="100" name="birth" id="birthday"
									path="birthday" value="${user.birthday}" class="form-control"
									type="text" />
								<div>
									<form:errors path="birthday" cssClass="error" element="div" />
								</div>
							</div>
						</div>
					</li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-md-3">
								<input type="submit" value="update" class="btn btn-primary"
									id="${user.userName}" />
							</div>
							<div class="col-md-3">
								<a href="/CboS/admin/manageusers" class="btn btn-default">Cancel</a>
							</div>
							<div class="col-md-3">
								<a href="/CboS/admin/manageusers/resetpw/${user.userName}"
									class="btn btn-warning">Reset Password</a>
							</div>
							<div class="col-md-3">
								<a href="/CboS/admin/manageusers/delete/${user.userName}"
									class="btn pull-right btn-danger">Delete User</a>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</form:form>
	</div>
</body>
</html>