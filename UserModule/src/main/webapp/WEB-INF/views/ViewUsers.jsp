<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="h2">Show Users</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>Name</td>
					<td>Image</td>
					<td>Contact</td>
					<td>ID</td>
					<!-- <td>Password</td> -->
					<td>Role</td>
				</tr>
			</thead>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.name}</td>
					<td><img height="50px" width="75px" src="<c:url value="/resources/img/${user.id}.jpeg" />" alt="${user.name}" /></td>
					<td>${user.contact}</td>
					<td>${user.id}</td>
					<%-- <td>${user.password}</td> --%>
					<td>${user.role}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>