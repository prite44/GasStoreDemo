<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="/public/lib/jquery/jquery-1.11.3.min.js"></script>

<script src="/public/lib/angularjs/angular.min.js"></script>

<link href="/public/lib/bootstrap-3.3.6-dist/css/bootstrap.css"
	rel="stylesheet">

<link href="/public/lib/bootstrap-3.3.6-dist/css/bootstrap.min.css"
	rel="stylesheet">

<script src="/public/lib/bootstrap-3.3.6-dist/js/bootstrap.js"></script>

<script src="/public/lib/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>

<style type="text/css">

/* Override some defaults */
html, body {
	background-color: #eee;
}

body {
	padding-top: 40px;
}

.container {
	width: 300px;
}

/* The white background content wrapper */
.container>.content {
	background-color: #fff;
	padding: 20px;
	margin: 0 -20px;
	-webkit-border-radius: 10px 10px 10px 10px;
	-moz-border-radius: 10px 10px 10px 10px;
	border-radius: 10px 10px 10px 10px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
}

.login-form {
	margin-left: 65px;
}

legend {
	margin-right: -50px;
	font-weight: bold;
	color: #404040;
}
</style>
<title>Gas Store</title>s
</head>
<body class="security-app">
	<div class="details"></div>

	<form action="/login" method="post">

		<div class="container">
			<div class="content">
			<div class="form-group">
				<center><h2>GAS STORE</h2></center>
				</div>
				<div class="form-group">
					<label for="username">username :</label> <input type="text"
						class="style-4" name="username" placeholder="User Name" />
				</div>
				<div class="form-group">
					<label for="username">password :</label> <input type="password"
						class="style-4" name="password" placeholder="Password" />
				</div>
				<div class="form-group">
					<button class="btn btn-primary center-block" type="submit">Sign in</button>
					<a href="/signup">New User</a>
				</div>
				<c:if test="${param.error ne null}">
					<div class="alert-danger">Invalid username and password.</div>
				</c:if>
				<c:if test="${param.logout ne null}">
					<div class="alert-info">You have been logged out.</div>
				</c:if>
			</div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
</body>
</html>