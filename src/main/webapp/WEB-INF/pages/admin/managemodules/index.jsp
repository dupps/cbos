<%@page import="java.util.List"%>
<%@page import="de.cbos.model.module.Module"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>CboS - ${page.pageName}</title>
	<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<script src="<c:url value='/admin/resources/js/jquery-1.10.2.js'/>" type="text/javascript"></script>
	<script src="<c:url value='/admin/resources/js/jquery-ui-1.10.4.custom.min.js'/>" type="text/javascript"></script>
	<script>
		$(function() {
			$(".draggable").draggable({ containment: "#containment-wrapper",
										stack: "#stack-wrapper",
										scroll: false,
										revert: false,
										handle: "a.move",
										grid: [20, 20]
							});
			/* .resizable({ containment: "#containment-wrapper",
										   animate: true,
										   minHeight: 200,
										   minWidth: 300,
						   				   grid: 20
			}); */
		});
	</script>
	<style>
		#containment-wrapper { width: 100%; height:800px; border:2px solid #ccc; padding: 10px; }
		/* .ui-resizable-helper { border: 1px dotted gray; } */
	</style>
</head>
<body>
	<%@ include file="menu1.jsp" %>
	<div class="well"></div>
	<div class="container">
		<p><a href="${page.pageName}/create" class="btn pull-right btn-primary">Create new Module</a></p>
		<h1>Manage Modules</h1>
		<div class="ui-widget">
			<p>You can move every module in the following container.</p>
		</div>
		<div id="containment-wrapper">
		  <div id="stack-wrapper">

		  	<c:forEach var="module" items="${modules}">
				<div>
					<c:if test="${module.type == 'textcontainer'}">
						<p>I am a ${module.type} (${module.moduleId})</p>				
					</c:if>
					<c:if test="${module.type == 'guestbook'}">
						<p>I am a ${module.type} (${module.moduleId})</p>				
					</c:if>
					
	
				</div>
			</c:forEach>

		  </div>
		</div>
	</div>
</body>
</html>
