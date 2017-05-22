<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="Home">UserModule</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="Home">Home</a></li>
			<c:if test="${isUser=='true'}">
				<li><a href="ViewUsers">View Users</a></li>
			</c:if>
			<li><a href="AboutUs">About Us</a></li>
			
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:if test="${!isUser=='true' && !isAdmin=='true'}">
				<li><a href="Register">
						<span class="glyphicon glyphicon-user"></span> Sign Up
					</a></li>
				<li><a href="Login">
						<span class="glyphicon glyphicon-log-in"></span> Login
					</a></li>
			</c:if>
			<c:if test="${isUser=='true' || isAdmin=='true'}">
				<li><a href="secure_logout">
						<span class="glyphicon glyphicon-user"></span> Sign Out
					</a></li>
			</c:if>

		</ul>
	</div>
	</nav>
</body>
</html>