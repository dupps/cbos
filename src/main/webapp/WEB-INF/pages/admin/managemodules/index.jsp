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
		#containment-wrapper { width: 100%; height:800px; border:2px solid #ccc; padding: 10px; position: relative; }
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
				              <div class="col-md-4"><h1 class="text-center">${module.type} (${module.moduleId})<br></h1></div>
				              <div class="col-md-4"></div>
				              <div class="col-md-4">
				                <a href="#" class="btn pull-right btn-primary move">Move</a>
				              </div>
				            </div>
				            <div>
				            	<% Textcontainer textcontainer = (Textcontainer) pageContext.getAttribute("module");
				            	   List<Paragraph> paragraphs = textcontainer.getParagraphs();
				            	   pageContext.setAttribute("paragraphs",paragraphs);%>
				            	<c:forEach var="paragraph" items="${paragraphs}"> 
								<div class="container"> 
										<span>This is a sample paragraph!</span> 
									</div> 
								</c:forEach>
				            </div>
				        </li>
				        <li class="list-group-item">
				          <a href="${page.pageName}/${module.moduleId}/addTextcontainer" class="btn btn-primary">Add Paragraph</a>
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
				            <div>
				            	<% Guestbook guestbook = (Guestbook) pageContext.getAttribute("module");
				            		List<GuestbookEntry> entries = guestbook.getGuestbookEntries();
				            		pageContext.setAttribute("guestbookEntries",entries); %>
				            	<c:forEach var="guestbookEntries" items="${guestbookEntries}"> 
								<div class="container"> 
										<span>This is a sample guestbookEntry!</span> 
									</div> 
								</c:forEach>
				            </div>
				            <div class="col-md-4">
				              <a href="#" class="btn pull-right btn-primary move">Move</a>
				            </div>
				          </div>
				        </li>
				        <li class="list-group-item">
				          <a href="${page.pageName}/${module.moduleId}/addGuestbookEntry" class="btn btn-primary">Add Entry</a>
				        </li>
				      </ul>
				    </div>
				<!-- EOF Guestbook -->
				</c:if>
				
				<c:if test="${module.type == 'navigation'}">
					<%  Navigation navigation = (Navigation) pageContext.getAttribute("module");
						List<Link> links = navigation.getLinks();
/*  					System.out.println(navigation.getLinks().get(0).getLink()) */;  
 						pageContext.setAttribute("links",links); 
						pageContext.setAttribute("type",navigation.getType());%>
						<p>${type}</p>
					<c:forEach var="link" items="${links}"> 
						<div class="container"> 
							<span>hallo</span> 
						</div> 
					</c:forEach>
				</c:if>
			</c:forEach>

		</div>
	</div>
	<form:form name="positionForm" id="positionForm" method="POST" action="${page.pageName}/save" />
</body>
</html>
