<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>CboS - Home</title>
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <style>
        #containment-wrapper { width: 100%; height:800px; border:0; padding: 0; position: relative; }
        .module { position: absolute; }
    </style>
</head>
<body>
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
    <div class="well"></div>
    <div class="container">
      <div id="containment-wrapper">
        <c:forEach var="module" items="${modules}">

            <c:if test="${module.type == 'textcontainer'}">
            <!-- Textcontainer -->
                <div class="col-md-4 module draggable" id="${module.type}-${module.moduleId}" style="left:${module.leftPosition}px; top:${module.topPosition}px;">
                  <ul class="list-group">
                    <li class="list-group-item">
                        <div class="row">
                          <div class="col-md-4"><h1 class="text-center">${module.type} (${module.moduleId})<br></h1></div>
                          <div class="col-md-4"></div>
                          <div class="col-md-4"></div>
                        </div>
                    </li>
                    <li class="list-group-item">
                      <a href="" class="btn btn-primary">Add Paragraph</a>
                    </li>
                  </ul>
                </div>
            <!-- EOF Textcontainer -->
            </c:if>

            <c:if test="${module.type == 'guestbook'}">
            <!-- Guestbook -->
                <div class="col-md-8 module draggable" id="${module.type}-${module.moduleId}" style="left:${module.leftPosition}px; top:${module.topPosition}px;">
                  <ul class="list-group">
                    <li class="list-group-item">
                      <div class="row">
                        <div class="col-md-4"></div>
                        <div class="col-md-4">
                          <h1 class="text-center">${module.type} (${module.moduleId})</h1>
                        </div>
                        <div class="col-md-4"></div>
                      </div>
                    </li>
                    <li class="list-group-item">
                      <a href="" class="btn btn-primary">Add Entry</a>
                    </li>
                  </ul>
                </div>
            <!-- EOF Guestbook -->
            </c:if>

        </c:forEach>
      </div>
    </div>
</body>
</html>