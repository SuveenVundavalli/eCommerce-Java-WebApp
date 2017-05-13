<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Product</title>
</head>
<body>
	<div class="container">
		<div class="h2">Manage Products</div>
		<c:url var="addAction" value="/manage-product-add?${_csrf.parameterName}=${_csrf.token}"></c:url>
		<form:form action="${addAction}" commandName="product" enctype="multipart/form-data" method="post" cssClass="form-horizontal">
			<div class="form-group">
				<form:label path="id" cssClass="control-label col-sm-3">
					<spring:message text="Product Id" />
				</form:label>

				<c:choose>
					<c:when test="${!empty product.id}">
						<div class="col-sm-9">
							<form:input path="id" value="" disabled="true" readonly="true" cssClass="form-control" />
						</div>
					</c:when>

					<c:otherwise>
						<div class="col-sm-9">
							<form:input path="id" pattern=".{5,20}" required="true" title="id should contains 5 to 20 characters" cssClass="form-control" />
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="form-group">
				<form:input path="id" hidden="true" />
				<form:label path="name" cssClass="control-label col-sm-3">
					<spring:message text="Product Name" />
				</form:label>
				<div class="col-sm-9">
					<form:input path="name" required="true" cssClass="form-control" />
				</div>
			</div>

			<div class="form-group">
				<form:label path="price" cssClass="control-label col-sm-3">
					<spring:message text="Product Price" />
				</form:label>
				<div class="col-sm-9">
					<form:input path="price" required="true" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="quantity" cssClass="control-label col-sm-3">
					<spring:message text="Product Quantity" />
				</form:label>
				<div class="col-sm-9">
					<form:input path="quantity" required="true" cssClass="form-control" />
				</div>
			</div>

			<div class="form-group">
				<form:label path="description" cssClass="control-label col-sm-3">
					<spring:message text="Product Description" />
				</form:label>
				<div class="col-sm-9">
					<form:input path="description" required="true" cssClass="form-control" />
				</div>
			</div>

			<div class="form-group">
				<form:label path="category.name" cssClass="control-label col-sm-3">
					<spring:message text="Product Category" />
				</form:label>
				<div class="col-sm-9">
					<form:select path="category.name" items="${categoryList}" itemValue="name" itemLabel="name" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="supplier.name" cssClass="control-label col-sm-3">
					<spring:message text="Product Supplier" />
				</form:label>
				<div class="col-sm-9">
					<form:select path="supplier.name" items="${supplierList}" itemValue="name" itemLabel="name" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<form:label path="image" cssClass="control-label col-sm-3">
					<spring:message text="Product Image" />
				</form:label>
				<div class="col-sm-9">
					<form:input type="file" name="image" path="image" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<td colspan="2"><c:if test="${!empty product.name}">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" value="<spring:message/>" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Update Product</button>
						</div>
					</c:if> <c:if test="${empty product.name}">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" value="<spring:message/>" class="btn btn-success"><i class="fa fa-plus" aria-hidden="true"></i> Add Product</button>
						</div>
					</c:if>
			</div>

			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

		</form:form>
		<br>


		<!-- Show Products -->
		<div class="h3">Product List</div>
		<c:if test="${!empty productList}">
			<table class="table table-striped">
				<tr>
					<th>Product ID</th>
					<th>Product Image</th>
					<th>Product Description</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Category</th>
					<th>Supplier</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.id}</td>
						<td><img height="50px" width="75px" src="<c:url value="/resources/img/${product.id}.jpeg" />" alt="${product.name}" /></td>
						<td>${product.description}</td>
						<td>${product.name}</td>
						<td>${product.price}</td>
						<td>${product.category.name}</td>
						<td>${product.supplier.name}</td>

						<td><a href="<c:url value='manage-product-edit/${product.id}' />" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</a> 
						<a href="<c:url value='manage-product-delete/${product.id}' />" class="btn btn-danger"><i class="fa fa-trash-o fa-lg"></i> Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>

	</div>


</body>
</html>