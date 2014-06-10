<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CboS - Update user confirmation</title>
<link rel="stylesheet"
    href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="menu2.jsp" %>
    <div class="well"></div>
    <div class="container">
		<p>Are you really sure you want to update the user ${User.userName}?</p>
	   	<!-- Post method giving back ${User.userName} -->
	   	<div>
	   		<form:form name="submitForm" method="PATCH" action="../manageusers" commandName="userDummy">
	   			<form:input value="${User.userName}" name="username" id="username"
						path="userName" maxlength="100" class="form-control" type="hidden" />
				<form:input maxlength="100" name="email" id="email" path="email"
					value="${User.email}" class="form-control"
					type="hidden" />
				<form:input maxlength="100" name="city" id="city" path="city"
						value="${User.city}" class="form-control" type="hidden" />
				<form:input maxlength="100" name="birth" id="birthday" path="birthday"
						value="${User.birthday}" class="form-control" type="hidden" />
				<a href="${User.userName}" class="btn pull-left btn-danger">Cancel</a>
			    <a href="javascript:document.submitForm.submit()" class="btn pull-right btn-danger">Update User</A>
			</form:form>
	   	</div>
	</div>
</body>
</html>