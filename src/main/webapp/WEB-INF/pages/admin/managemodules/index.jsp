<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>CboS - Manage Modules</title>
	<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<script src="<c:url value='/resources/js/jquery-1.10.2.js' />"></script>
	<script src="<c:url value='/resources/js/jquery-ui-1.10.4.custom.min.js' />"></script>
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
	<%@ include file="menu.jsp" %>
	<div class="well"></div>
	<div class="container">
		<h1>Manage Modules</h1>
		<div class="ui-widget">
			<p>You can move every module in the following container.</p>
		</div>
		<div id="containment-wrapper">
		  <div id="stack-wrapper">

		    <div class="col-md-4 draggable">
		      <ul class="list-group">
		        <li class="list-group-item">
		            <div class="row">
		              <div class="col-md-4">
		                <a href="managemodules/update.html" class="btn btn-primary">Config</a>
		              </div>
		              <div class="col-md-4">
		                <h1 class="text-center">Mod<br></h1>
		              </div>
		              <div class="col-md-4">
		                <a href="#" class="btn pull-right btn-primary move">Move</a>
		              </div>
		            </div>
		          </li>
		        <li class="list-group-item">
		          <div class="media">
		            <a class="pull-left" href="#">    <img class="media-object" src="https://app.divshot.com/img/placeholder-64x64.gif">  </a>
		            <div class="media-body">
		              <h4 class="media-heading"><a href="#">Media heading</a></h4>
		              <p><a href="#">This is the content for your media.</a></p>
		            </div>
		          </div>
		        </li>
		        <li class="list-group-item">
		          <div class="media">
		            <a class="pull-left" href="#">    <img class="media-object" src="https://app.divshot.com/img/placeholder-64x64.gif">  </a>
		            <div class="media-body">
		              <h4 class="media-heading"><a href="#">More Media</a></h4>
		              <p><a href="#">This is the content for your media.</a></p>
		            </div>
		          </div>
		        </li>
		        <li class="list-group-item">
		          <div class="media">
		            <a class="pull-left" href="#">    <img class="media-object" src="https://app.divshot.com/img/placeholder-64x64.gif">  </a>
		            <div class="media-body">
		              <h4 class="media-heading"><a href="#">Even More Media</a></h4>
		              <p><a href="#">This is the content for your media.</a></p>
		            </div>
		          </div>
		        </li>
		        <li class="list-group-item">
		          <a href="managecontent/create.html" class="btn btn-primary">Add Entry</a>
		        </li>
		      </ul>
		    </div>

		    <div class="col-md-8 draggable">
		      <ul class="list-group">
		        <li class="list-group-item">
		          <div class="row">
		            <div class="col-md-4">
		              <a href="managemodules/update.html" class="btn btn-primary">Config</a>
		            </div>
		            <div class="col-md-4">
		              <h1 class="text-center">My Blog</h1>
		            </div>
		            <div class="col-md-4">
		              <a href="#" class="btn pull-right btn-primary move">Move</a>
		            </div>
		          </div>
		        </li>
		        <li class="list-group-item">
		          <div class="media">
		            <a class="pull-left" href="#">    <img class="media-object" src="https://app.divshot.com/img/placeholder-64x64.gif">  </a>
		            <div class="media-body">
		              <h4 class="media-heading"><a href="#">Media heading</a></h4>
		              <p><a href="#">This is the content for your media.</a></p>
		            </div>
		          </div>
		        </li>
		        <li class="list-group-item">
		          <p><a href="managecontent/update.html">Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</a></p>
		        </li>
		        <li class="list-group-item">
		          <p><a href="#">Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</a></p>
		        </li>
		        <li class="list-group-item">
		          <div class="media">
		            <a class="pull-left" href="#">    <img class="media-object" src="https://app.divshot.com/img/placeholder-64x64.gif">  </a>
		            <div class="media-body">
		              <h4 class="media-heading"><a href="#">I shot new photos!</a></h4> 
		              <p><a href="#">Lorem ipsum dolor sit amet, consectetur adipisici elit, sed eiusmod tempor incidunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat.</a></p>
		            </div>
		          </div>
		        </li>
		        <li class="list-group-item">
		          <a href="managecontent/create.html" class="btn btn-primary">Create new Entry</a>
		        </li>
		      </ul>
		    </div>

		  </div>
		</div>
	</div>
</body>
</html>
