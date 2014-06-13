<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="de.cbos.model.module.Module"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
										/* grid: [10, 10], */
										stop: function(e, ui) {
											var currentPos, id, left, top;

											currentPos = ui.helper.position();
											id = e.target.id;
											left = currentPos.left;
											top = currentPos.top;

								            console.info("id: " + id +
								            			 "\nleft: " + left +
								            			 "\ntop: " + top);

								            var modulePosContainer = '<input type="hidden" id="'+id+'" value="'+left+','+top+'"/>'
								            $('#positionForm').append(modulePosContainer);
								        }
							});
		});
	</script>
	<style>
		#containment-wrapper { width: 100%; height:800px; border:2px solid #ccc; padding: 10px; position: relative; }
		#menu-top { padding: 20px 0 20px; width: 100%; text-align: center; }
		.menu-item { display: inline-block; }
		.left { float: left; }
		.right { float: right; }
		.center { margin: 0 auto; }
	</style>
</head>
<body>
	<%@ include file="menu1.jsp" %>
	<div class="well"></div>
	
	<div class="container">
		<div id="menu-top">
			<div class="menu-item left">
				<a href="${page.pageName}/create" class="btn pull-left btn-primary">Add new Module</a>
			</div>
			<div class="menu-item center">
				<span>&nbsp;You can move every module in the following container.</span>
			</div>
			<div class="menu-item right">
				<form:form name="submitForm" id="positionForm" method="POST" action="">
				    <a href="${page.pageName}/save" class="btn pull-right btn-success">Save</a>
				</form:form>
			</div>
		</div>
		<div id="containment-wrapper">
		  <div id="stack-wrapper">

		  	<c:forEach var="module" items="${modules}">

				<!-- Textcontainer -->
				<c:if test="${module.type == 'textcontainer'}">
					<div class="col-md-4 draggable" id="${module.type}${module.moduleId}">
				      <ul class="list-group">
				        <li class="list-group-item">
				            <div class="row">
				              <div class="col-md-4"><h1 class="text-center">${module.type} (${module.moduleId})<br></h1></div>
				              <div class="col-md-4"></div>
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
					<div class="col-md-8 draggable" id="${module.type}${module.moduleId}">
				      <ul class="list-group">
				        <li class="list-group-item">
				          <div class="row">
				            <div class="col-md-4"></div>
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
