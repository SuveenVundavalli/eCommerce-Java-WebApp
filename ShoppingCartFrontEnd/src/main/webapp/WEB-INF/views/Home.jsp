<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
<link rel="stylesheet" href="src/main/webapp/WEB-INF/resources/css/bootstrap.css">
<script src="src/main/webapp/WEB-INF/resources/js/jquery-3.2.0.js"></script>
<script src="src/main/webapp/WEB-INF/resources/js/bootstrap.js"></script>
</head>
<body>
	<center>
		<h1>Shopping Cart Web site</h1>
	</center>

	<hr color="green">
	<jsp:include page="Menu.jsp"></jsp:include>


	<c:if test="${isUserClickedLogin=='true'}">
		<jsp:include page="Login.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedRegistration=='true'}">
		<jsp:include page="Register.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedMain=='true'}">
		<jsp:include page="Main.jsp"></jsp:include>
	</c:if>
</body>
</html>