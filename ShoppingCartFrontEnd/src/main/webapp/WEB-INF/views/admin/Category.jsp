<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Categories</title>
</head>
<body>



	<div class="container">
		<div class="h2">Manage Categories</div>

		<!-- Add Category -->
		<div id="CreateCategory">
			<form class="form-horizontal" action="manage_category_add">
				<div class="form-group">
					<label class="control-label col-sm-3" for="cId">Customer Id:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="cId" placeholder="Enter Customer Id" name="cId" required>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="cName">Customer Name:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="cName" placeholder="Enter Customer Name" name="cName" required>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="cDescription">Customer Description:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="cDescription" placeholder="Enter Customer Description" name="cDescription" required>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-9">
						<button type="submit" class="btn btn-success">Create Category</button>
					</div>
				</div>
			</form>
		</div>

		<div id="UpdateCategory">
			<form class="form-horizontal" action="manage_category_update">
				<div class="form-group">
					<label class="control-label col-sm-3" for="cId">Customer Id:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="cId" placeholder="Enter Customer Id" name="cId" value="${selectedCategory.id}" required>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="cName">Customer Name:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="cName" placeholder="Enter Customer Name" name="cName" value="${selectedCategory.name}" required>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-3" for="cDescription">Customer Description:</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="cDescription" placeholder="Enter Customer Description" name="cDescription" value="${selectedCategory.description}" required>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-9">
						<button type="submit" class="btn btn-warning">Update Category</button>
					</div>
				</div>
			</form>
		</div>

		<!-- Show Category -->
		<div id="ShowCategories">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Category Id</td>
						<td>Category Name</td>
						<td>Category Description</td>
						<td>Action</td>
					</tr>
				</thead>
				<c:forEach var="category" items="${categoryList}">
					<tr>
						<td>${category.id}</td>
						<td>${category.name}</td>
						<td>${category.description}</td>
						<td><a href="manage-category-delete/${category.id}" class="btn btn-danger">Delete</a> 
						<a href="manage-category-edit/${category.id}" class="btn btn-info">Edit</a></td>
						<%-- <td><a href="<c:url value='manage-category-delete/${category.id}'/>" class="btn btn-danger">Delete</a>
						<a href="<c:url value='manage-category-edit/${category.id}'/>" class="btn btn-info">Edit</a></td> --%>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>