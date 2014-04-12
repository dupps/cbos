<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login Page For Security</title>
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body onload='document.f.j_username.focus();'>
    <%@ include file="menu.jsp" %>
    <div class="well"></div>
    <div class="container">
		<h3>Please Login</h3>
		<c:if test="${not empty error}">
		   <div class="alert alert-danger">
		       Your login attempt was not successful, try again.<br>
		       Caused : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		   </div>
		</c:if>
		<form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
			<div class="form-group">
			   <label class="control-label">Username</label>
			       <div class="controls">
			           <input type='text' name='j_username' value='' class="form-control" />
			       </div>
			</div>
			<div class="form-group">
			   <label class="control-label">Password</label>
		       <div class="controls">
		           <input type='password' name='j_password' class="form-control" />
		       </div>
			</div>
			<input name="submit" type="submit" value="login" class="btn btn-primary" />
		</form>
	</div>
</body>
</html>