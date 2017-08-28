<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Contact Us</title>
</head>
<body>

	<div class="container">
		<div class="h2">Manage ContactUs</div>

		<!-- Show Category -->
		<div id="ShowContactUs">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Contact Id</td>
						<td>Contact Name</td>
						<td>Contact Email</td>
						<td>Contact Mobile</td>
						<td>Contact Message</td>
						<td>Manage</td>

					</tr>
				</thead>
				<c:forEach var="contact" items="${contactUsList}">
					<tr>
						<td>${contact.id}</td>
						<td>${contact.name}</td>
						<td>${contact.email}</td>
						<td>${contact.contact}</td>
						<td>${contact.message}</td>
						<%-- <td><a href="manage-category-delete/${category.id}" class="btn btn-danger">Delete</a>  --%>
						<%-- <a href="manage-category-edit/${category.id}" class="btn btn-info">Edit</a></td> --%>
						<td><a href="manage-contactus-delete/${contact.id}" class="btn btn-danger"><i class="fa fa-trash-o fa-lg"></i> Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>