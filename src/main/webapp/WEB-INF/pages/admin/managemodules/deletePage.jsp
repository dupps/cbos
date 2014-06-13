<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>CboS - Delete user confirmation</title>
<link rel="stylesheet"
    href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="menu2.jsp" %>
    <div class="well"></div>
    <div class="container">
		<p>Are you really sure you want to delete the page ${page.pageName}?</p>
	   	<!-- Post method giving back ${User.userName} -->
	   	<div>
	   		<form:form name="submitForm" method="DELETE" action="../../">
			    <input type="hidden" name="pageToDelete" value="${Page.pageName}">
				<a href="../../" class="btn pull-left btn-default">Cancel</a>
			    <a href="javascript:document.submitForm.submit()" class="btn pull-right btn-danger">Delete Page</A>
			</form:form>
	   	</div>
	</div>
</body>
</html>