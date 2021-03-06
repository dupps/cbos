<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CboS - Delete user confirmation</title>
<link rel="stylesheet"
    href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="menu3.jsp" %>
    <div class="well"></div>
    <div class="container">
		<p>Are you really sure you want to delete ${User.userName}?</p>
	   	<!-- Post method giving back ${User.userName} -->
	   	<div>
	   		<form:form name="submitForm" method="DELETE" action="../../manageusers">
			    <input type="hidden" name="userToDelete" value="${User.userName}">
				<a href="../${User.userName}" class="btn pull-left btn-default">Cancel</a>
			    <a href="javascript:document.submitForm.submit()" class="btn pull-right btn-danger">Delete User</A>
			</form:form>
	   	</div>
	</div>
</body>
</html>