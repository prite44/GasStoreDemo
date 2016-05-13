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
<script src="/public/app/signup.js"></script>
<script src="/public/controller/SignupController.js"></script>
<script src="/public/service/SignupService.js"></script>
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
<title>Gas Store</title>
</head>
<body class="">
	<div class="details" ng-app="Signup">
		<div class="container" ng-controller="SignupController">
			<div class="content">
			<div class="form-group">
				<center><h2>Registration</h2></center>
				</div>
				<div class="form-group">
					<label for="username">username :</label> 
					<input type="text" class="style-4" ng-model="signup.user" ng-blur="CheckUsername(signup.user)" placeholder="User Name" />
				</div>
				<div class="form-group">
					<label for="password">password :</label> <input type="password"
						class="style-4" ng-model="signup.password" placeholder="Password" />
				</div>
				<div class="form-group">
					<button class="btn btn-primary center-block" ng-click="process(signup)">Sign up</button>
					<a href="/login">Login</a>
				</div>
			</div>
		</div>
		</div>
</body>
</html>