<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Module</title>

<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/cloud-zoom.css" />" rel="stylesheet">


<script src="<c:url value="/resources/js/jquery-3.2.0.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
<script src="<c:url value="/resources/js/CustomJS.js" />"></script>


</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="container-fluid">
		<marquee>
		<strong class="text-primary">${message} </strong>
		<strong class="text-success">${successMessage} </strong>
		<strong class="text-danger">${errorMessage} </strong>
		</marquee>
	</div>
	<c:if test="${isUserClickedLogin=='true'}">
		<jsp:include page="Login.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedRegister=='true'}">
		<jsp:include page="Register.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedViewUsers=='true'}">
		<jsp:include page="ViewUsers.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserAtHome=='true'}">
		<jsp:include page="Carousel.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedAboutUs=='true'}">
		<jsp:include page="AboutUs.jsp"></jsp:include>
	</c:if>
	<c:if test="${isAdmin=='true'}">
		<jsp:include page="Admin/ManageUsers.jsp"></jsp:include>
	</c:if>
	
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>