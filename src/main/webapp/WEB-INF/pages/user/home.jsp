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
	<style>
		#containment-wrapper { width: 100%; height:800px; border:0; padding: 0; position: relative; }
		.module { position: absolute; }
		.break-word { word-wrap: break-word; }
		.autoscroll { max-height: 400px; overflow: auto; }
	</style>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="well"></div>
	<div class="container">
		<p>${message}</p>
	</div>

	<div class="container">
		<div id="containment-wrapper">

		  	<c:forEach var="module" items="${modules}">

				<c:if test="${module.type == 'textcontainer'}">
				<!-- Textcontainer -->
					<div class="col-md-4 module" id="${module.type}-${module.moduleId}" style="left:${module.leftPosition}px; top:${module.topPosition}px;">
				      <ul class="list-group">
				        <li class="list-group-item">
				            <div class="row">
				              <div class="col-md-4"></div>
				              <div class="col-md-4"></div>
				              <div class="col-md-4"></div>
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
									<p class="break-word">${paragraph.getText()}</p> 
								  </div> 
								</c:forEach>
				            </div>
				        </li>
				      </ul>
				    </div>
				<!-- EOF Textcontainer -->
				</c:if>

				<c:if test="${module.type == 'guestbook'}">
				<!-- Guestbook -->
					<div class="col-md-8 module" id="${module.type}-${module.moduleId}" style="left:${module.leftPosition}px; top:${module.topPosition}px;">
				      <ul class="list-group">
				        <li class="list-group-item">
				          <div class="row">
				            <div class="col-md-10 autoscroll">
				            	
				            	<%  Guestbook guestbook = (Guestbook) pageContext.getAttribute("module");
				            		List<GuestbookEntry> entries = guestbook.getGuestbookEntries();
				            		pageContext.setAttribute("guestbookEntries",entries); %>
				            	<c:forEach var="guestbookEntry" items="${guestbookEntries}"> 
								  <div class="container"> 
									<% GuestbookEntry guestbookEntry = (GuestbookEntry) pageContext.getAttribute("guestbookEntry");
									   pageContext.setAttribute("contentId", guestbookEntry.getId());
									   pageContext.setAttribute("contentType", guestbookEntry.getContentType());%>
									<span class="break-word"><strong>${guestbookEntry.getAuthor().getUserName()}:</strong> ${guestbookEntry.getEntry()}</span> 
								  </div>
								</c:forEach>
				            </div>
				            <div class="col-md-2"></div>
				          </div>
				        </li>
				        <form:form name="gbForm" id="gbForm" method="POST" action="${page.pageName}/${module.moduleId}/addGuestbookEntry">
				          <li class="list-group-item">
				            <label for="gbContent">Insert text</label>
				            <input type="text" name="gbContent" id="gbContent" class="form-control">
				          </li>
				          <li class="list-group-item">
				            <input type="submit" class="btn btn-primary" value="Add Entry">
				          </li>
				        </form:form>
				      </ul>
				    </div>
				<!-- EOF Guestbook -->
				</c:if>
				
				<c:if test="${module.type == 'navigation'}">
				<!-- Navigation -->
				<nav class="navbar navbar-default module" id="${module.type}-${module.moduleId}" role="navigation" style="left:${module.leftPosition}px; top:${module.topPosition}px;">
				  <div class="container-fluid">
				    <!-- Brand and toggle get grouped for better mobile display -->
				    <div class="navbar-header">
				      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
				      <a class="navbar-brand" href="#">Navigation</a>
				    </div>
				    <!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
						<c:forEach var="link" items="${links}">
				        	<li><a href="${link.link}">${link.link}</a></li>
				        </c:forEach>
				      </ul>
				    </div>
				  </div>
				</nav>
				<!-- EOF Navigation -->
				</c:if>

			</c:forEach>

		</div>
	</div>
	<form:form name="positionForm" id="positionForm" method="POST" action="${page.pageName}/save" />
</body>
</html>