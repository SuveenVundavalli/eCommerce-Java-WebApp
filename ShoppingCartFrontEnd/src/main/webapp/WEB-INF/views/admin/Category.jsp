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

		<!-- isAdminClickedManageCategoryEdit -->
		<!-- Update Category -->
		<c:if test="${isAdminClickedManageCategoryEdit=='true'}">
			<div id="UpdateCategory">
				<div class="h3">Update Category</div>

				<form class="form-horizontal" action="manage-category-update" method="get">

					<div class="form-group">
						<label class="control-label col-sm-3" for="cId">Category Id:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="cId" placeholder="Enter Category Id" name="cId" value="${selectedCategory.id}" pattern=".{5,15}" title="Category Id must have 5 to 15 characters" required readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="cName">Category Name:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="cName" placeholder="Enter Category Name" name="cName" value="${selectedCategory.name}" pattern=".{5,40}" title="Category Name must have 5 to 40 characters" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="cDescription">Category Description:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="cDescription" placeholder="Enter Category Description" name="cDescription" value="${selectedCategory.description}" pattern=".{5,}" title="Category Description must have minimum of 5 characters" required>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Update Category</button>
						</div>
					</div>
				</form>
			</div>
		</c:if>
		<!-- Create Category -->
		<c:if test="${!isAdminClickedManageCategoryEdit=='true'}">
				<!-- Add Category -->
				<div id="CreateCategory">
					<div class="h3">Create Category</div>

					<form class="form-horizontal" action="manage-category-add">
						<div class="form-group">
							<label class="control-label col-sm-3" for="cId">Category Id:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="cId" placeholder="Enter Category Id" name="cId" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="cName">Category Name:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="cName" placeholder="Enter Category Name" name="cName" required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-3" for="cDescription">Category Description:</label>
							<div class="col-sm-9">
								<input type="text" class="form-control" id="cDescription" placeholder="Enter Category Description" name="cDescription" required>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-9">
								<button type="submit" class="btn btn-success"><i class="fa fa-plus" aria-hidden="true"></i> Create Category</button>
							</div>
						</div>
					</form>
				</div>
		</c:if>
 
		<!-- Show Category -->
		<div id="ShowCategories">
			<div class="h3">Show Categories</div>
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
						<%-- <td><a href="manage-category-delete/${category.id}" class="btn btn-danger">Delete</a>  --%>
						<%-- <a href="manage-category-edit/${category.id}" class="btn btn-info">Edit</a></td> --%>
						<td><a href="manage-category-delete/${category.id}" class="btn btn-danger"><i class="fa fa-trash-o fa-lg"></i> Delete</a> <a href="manage-category-edit/${category.id}" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>