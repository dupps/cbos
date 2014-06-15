<%@page import="de.cbos.model.content.Paragraph"%>
<%@page import="de.cbos.model.module.Textcontainer"%>
<%@page import="de.cbos.model.content.GuestbookEntry"%>
<%@page import="de.cbos.model.module.Guestbook"%>
<%@page import="de.cbos.model.content.Link"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="de.cbos.service.module.ModuleService"%>
<%@page import="de.cbos.model.module.Navigation"%>
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
										stack: "#containment-wrapper",
										scroll: false,
										revert: false,
										handle: "a.move",
										grid: [10, 10],
										stop: function(e, ui) {
											var currentPos, id, left, top, posLeftContainer, posTopContainer, idContainer;

											currentPos = ui.helper.position();
											id = e.target.id;
											left = currentPos.left;
											top = currentPos.top;

								            posLeftContainer = '<input type="hidden" name="left" id="left" value="'+left+'"/>';
								            posTopContainer = '<input type="hidden" name="top" id="top" value="'+top+'"/>';
								            idContainer = '<input type="hidden" name="id" id="id" value="'+id+'"/>';

								            $('#positionForm').append(posLeftContainer);
								            $('#positionForm').append(posTopContainer);
								            $('#positionForm').append(idContainer);
								            $('#positionForm').submit();
								        }
							});
		});
	</script>
	<style>
		#containment-wrapper { width: 100%; height:800px; border:1px solid #ccc; padding: 0; position: relative; }
		.module { position: absolute; }
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
		</div>
		<div id="containment-wrapper">

		  	<c:forEach var="module" items="${modules}">

				<c:if test="${module.type == 'textcontainer'}">
				<!-- Textcontainer -->
					<div class="col-md-4 module draggable" id="${module.type}-${module.moduleId}" style="left:${module.leftPosition}px; top:${module.topPosition}px;">
				      <ul class="list-group">
				        <li class="list-group-item">
				            <div class="row">
				              <div class="col-md-4"></div>
				              <div class="col-md-4"></div>
				              <div class="col-md-4">
				                <a href="#" class="btn pull-right btn-primary move">Move</a>
				              </div>
				            </div>
				            <div>
				            	<%	Textcontainer textcontainer = (Textcontainer) pageContext.getAttribute("module");
				            		List<Paragraph> paragraphs = textcontainer.getParagraphs();
				            		pageContext.setAttribute("paragraphs",paragraphs);%>
				            	<c:forEach var="paragraph" items="${paragraphs}"> 
								<div class="container">
									<%  Paragraph paragraph = (Paragraph) pageContext.getAttribute("paragraph");
										pageContext.setAttribute("contentId", paragraph.getId());
										pageContext.setAttribute("contentType", paragraph.getContentType());%> 
									<span>${contentType} (${contentId})</span> 
								</div> 
								</c:forEach>
				            </div>
				        </li>
				        <li class="list-group-item">
				          <a href="${page.pageName}/${module.moduleId}/addParagraph" class="btn btn-primary">Add Paragraph</a>
				          <h4 class="text-center pull-right">${module.type} (${module.moduleId})</h4>
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
				            <div class="col-md-10">
				            	
				            	<%  Guestbook guestbook = (Guestbook) pageContext.getAttribute("module");
				            		List<GuestbookEntry> entries = guestbook.getGuestbookEntries();
				            		pageContext.setAttribute("guestbookEntries",entries); %>
				            	<c:forEach var="guestbookEntry" items="${guestbookEntries}"> 
								<div class="container"> 
									<% GuestbookEntry guestbookEntry = (GuestbookEntry) pageContext.getAttribute("guestbookEntry");
									   pageContext.setAttribute("contentId", guestbookEntry.getId());
									   pageContext.setAttribute("contentType", guestbookEntry.getContentType());%>
									<span>${contentType} (${contentId})</span> 
									
								</div> 
								</c:forEach>
				            </div>
				            <div class="col-md-2">
				              <a href="#" class="btn pull-right btn-primary move">Move</a>
				            </div>
				          </div>
				        </li>
				        <li class="list-group-item">
				          <a href="${page.pageName}/${module.moduleId}/addGuestbookEntry" class="btn btn-primary">Add Entry</a>
				          <h4 class="text-center pull-right">${module.type} (${module.moduleId})</h4>
				        </li>
				      </ul>
				    </div>
				<!-- EOF Guestbook -->
				</c:if>
				
				<c:if test="${module.type == 'navigation'}">
				<!-- Navigation -->
				<nav class="navbar navbar-default module draggable" role="navigation" style="left:${module.leftPosition}px; top:${module.topPosition}px;">
				  <div class="container-fluid">
				    <!-- Brand and toggle get grouped for better mobile display -->
				    <div class="navbar-header">
				      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
				      <a class="navbar-brand move" href="#">Navigation</a>
				    </div>
				    <!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
				      	<%  /* Navigation navigation = (Navigation) pageContext.getAttribute("module");
							List<Link> links = navigation.getLinks();
	 						pageContext.setAttribute("links",links); 
							pageContext.setAttribute("type",navigation.getType()); */%>
						<c:forEach var="link" items="${links}">
							<% /* Link link = (Link) pageContext.getAttribute("link");
								pageContext.setAttribute("linkString", link.getLink()) */;%>
				        	<li><a href="${link.link}">${link.link}</a></li>
				        </c:forEach>
				      </ul>
				    </div><!-- /.navbar-collapse -->
				  </div><!-- /.container-fluid -->
				</nav>
				<!-- EOF Navigation -->
				</c:if>

			</c:forEach>

		</div>
	</div>
	<form:form name="positionForm" id="positionForm" method="POST" action="${page.pageName}/save" />
</body>
</html>