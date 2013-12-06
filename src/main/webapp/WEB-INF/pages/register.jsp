<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CboS - Register</title>
	<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
      <header>
        <ul class="nav navbar-nav pull-right">
          <li>
            <a href="home.html">Home</a>
          </li>
          <li class="active">
            <a href="register.html">Register</a>
          </li>
          <li>
            <a href="https://github.com/dupps/CboS">Github</a>
          </li>
          <li>
            <a href="mailto:cbos@dupps.it">Contact</a>
          </li>
        </ul>
      </header>
    </div>
    <div class="well"></div>
    <div class="container">
    	<form:form method="POST" action="register" commandName="userDummy">
	      <h1>Register</h1>
	      <div class="form-group">
	        <label class="control-label">Full Name *</label>
	        <div class="controls">
	          <form:input placeholder="Fill in Username..." name="username" path="fullName" maxlength="100" class="form-control" type="text"/>
	          <div><form:errors path="fullName"/></div>
	        </div>
	      </div>
	      <div class="form-group">
	        <label class="control-label">E-Mail *</label>
	        <div class="controls">
	          <form:input maxlength="100" name="email" path="email" placeholder="Enter correct E-Mail-Address..." class="form-control" type="email"/>
	          <div><form:errors path="email"/></div>
	        </div>
	      </div>
	      <div class="form-group">
	        <label class="control-label">City</label>
	        <div class="controls">
	          <form:input maxlength="100" name="city" path="city" placeholder="Enter your city..." class="form-control" type="text"/>
	          <div><form:errors path="city"/></div>
	        </div>
	      </div>
	      <div class="form-group">
	        <label class="control-label">Birthday</label>
	        <div class="controls">
	          <form:input maxlength="100" name="birth" path="birthday" placeholder="Enter date of birth..." class="form-control" type="text"/>
	          <div><form:errors path="birthday"/></div>
	        </div> 
	      </div> 
	      <input type="submit" value="Register" class="btn btn-primary" />
		</form:form>
    </div>
</body>
</html>
