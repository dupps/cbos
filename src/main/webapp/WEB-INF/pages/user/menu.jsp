<!DOCTYPE html>
<html>
<div class="container">
	<header>
		<ul class="nav navbar-nav pull-right">
	        <li><a href="">Home</a></li>
	        <% if (request.isUserInRole("ROLE_ADMIN")) { %>
	        <li><a href="<c:url value='/admin' />">Admin Area</a></li>
	        <% } %>
	        <li><a href="j_spring_security_logout">Logout</a></li>
	        <li><a href="https://github.com/cbos-team/cbos">Github</a></li>
	        <li><a href="mailto:cbos@dupps.it">Contact</a></li>
        </ul>
	</header>
</div>
</html>