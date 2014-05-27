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
	<%@ include file="menu.jsp" %>
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
			<!-- http://www.mkyong.com/spring-mvc/spring-mvc-dropdown-box-example/ -->
			<%-- <div class="form-group">
				<form:select path="modules">
				    <form:options items="${moduleList}" />
				</form:select>
			</div> --%>
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
			<input type="submit" value="Create" class="btn btn-primary" id="moduleForm" />
		</form:form>
	</div>
</body>
</html>