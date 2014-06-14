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
    <%@ include file="menu.jsp" %>
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
                      <span class="btn btn-default">Add Paragraph</span>
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
                      <span class="btn btn-default">Add Entry</span>
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