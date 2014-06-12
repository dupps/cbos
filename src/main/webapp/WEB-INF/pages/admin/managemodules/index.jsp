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

				<!-- Textcontainer -->
				<c:if test="${module.type == 'textcontainer'}">
					<div class="col-md-4 draggable">
				      <ul class="list-group">
				        <li class="list-group-item">
				            <div class="row">
				              <div class="col-md-4">
				                <a href="" class="btn btn-primary">Config</a>
				              </div>
				              <div class="col-md-4">
				                <h1 class="text-center">${module.type} (${module.moduleId})<br></h1>
				              </div>
				              <div class="col-md-4">
				                <a href="#" class="btn pull-right btn-primary move">Move</a>
				              </div>
				            </div>
				        </li>
				        <li class="list-group-item">
				          <a href="" class="btn btn-primary">Add Paragraph</a>
				        </li>
				      </ul>
				    </div>
				</c:if>
				<!-- EOF Textcontainer -->

				<!-- Guestbook -->
				<c:if test="${module.type == 'guestbook'}">
					<div class="col-md-8 draggable">
				      <ul class="list-group">
				        <li class="list-group-item">
				          <div class="row">
				            <div class="col-md-4">
				              <a href="" class="btn btn-primary">Config</a>
				            </div>
				            <div class="col-md-4">
				              <h1 class="text-center">${module.type} (${module.moduleId})</h1>
				            </div>
				            <div class="col-md-4">
				              <a href="#" class="btn pull-right btn-primary move">Move</a>
				            </div>
				          </div>
				        </li>
				        <li class="list-group-item">
				          <a href="" class="btn btn-primary">Add Entry</a>
				        </li>
				      </ul>
				    </div>
				</c:if>
				<!-- EOF Guestbook -->

			</c:forEach>

		  </div>
		</div>
	</div>
</body>
</html>
