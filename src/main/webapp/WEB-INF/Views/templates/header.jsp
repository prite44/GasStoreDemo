<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gas Store</title>
<link href="/public/lib/bootstrap-3.3.6-dist/css/bootstrap.css"
	rel="stylesheet">
<script src="/public/lib/jquery/jquery-1.11.3.min.js"></script>
<link href="/public/lib/bootstrap-3.3.6-dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/public/lib/angularjs-toaster/toaster.min.css">
<script src="/public/lib/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
<script src="/public/lib/angularjs/angular.min.js"></script>
<script src="/public/lib/spin.js/spin.js"></script>
<script src="/public/lib/angular-animate/angular-animate.min.js"></script>
<script src="/public/lib/angularjs-toaster/toaster.min.js"></script>
<script src="/public/lib/angular-spinner/angular-spinner.min.js"></script>
<script src="/public/lib/ngInfiniteScroll/build/ng-infinite-scroll.min.js"></script>
<!-- Bootstrap -->


</head>
<body>
	<!-- insert code here by prite -->
	<div id="custom-bootstrap-menu"
		class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/main">Gas Store</a>
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-menubuilder">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse navbar-menubuilder">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Manage <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/inventory/index"><span class="glyphicon glyphicon-home"></span>
									inventory</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="/customer/index"><span class="glyphicon glyphicon-user"></span>
									customer</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="/receipt/index"><span
									class="glyphicon glyphicon-list-alt"></span> receipt</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><span class="glyphicon glyphicon-cog"></span>
							<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/logout">Username : <c:out
										value="${pageContext.request.remoteUser}"></c:out></a></li>
							<li role="separator" class="divider"></li>
							<li><a href="/logout"><span
									class="glyphicon glyphicon-off"></span> Logout</a></li>
						</ul></li>
				</ul>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('.dropdown-toggle').dropdown()
		});
	</script>