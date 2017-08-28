<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="h2">Manage Supplier</div>
	
		<c:if test="${isAdminClickedManageSupplierEdit=='true'}">
			<div id="UpdateSupplier">
			<div class="h3">Update Supplier</div>

				<form class="form-horizontal" action="manage-supplier-update" method="get">
					<div class="form-group">
						<label class="control-label col-sm-3" for="cId">Supplier Id:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="cId" placeholder="Enter Supplier Id" name="cId" value="${selectedSupplier.id}" pattern=".{5,15}" title="Supplier Id must have 5 to 15 characters" required readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="cName">Supplier Name:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="cName" placeholder="Enter Supplier Name" name="cName" value="${selectedSupplier.name}" pattern=".{5,40}" title="Supplier Name must have 5 to 40 characters" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="cDescription">Supplier Description:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="cDescription" placeholder="Enter Supplier Description" name="cDescription" value="${selectedSupplier.description}" pattern=".{5,}" title="Supplier Description must have 5 characters minimum" required>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Update Supplier</button>
						</div>
					</div>
				</form>
			</div>
		</c:if>

		<c:if test="${!isAdminClickedManageSupplierEdit=='true'}">
			<div id="CreateSupplier">
			<div class="h3">Create Supplier</div>

				<form class="form-horizontal" action="manage-supplier-add">
					<div class="form-group">
						<label class="control-label col-sm-3" for="sId">Supplier Id:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="sId" placeholder="Enter Supplier Id" name="sId" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="sName">Supplier Name:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="sName" placeholder="Enter Supplier Name" name="sName" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-3" for="sDescription">Supplier Description:</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="sDescription" placeholder="Enter Supplier Description" name="sDescription" required>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-9">
							<button type="submit" class="btn btn-success"><i class="fa fa-plus" aria-hidden="true"></i> Create Supplier</button>
						</div>
					</div>
				</form>
			</div>
		</c:if>




		<div id="ShowSupplier">
		<div class="h3">Show Suppliers</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<td>Supplier Id</td>
						<td>Supplier Name</td>
						<td>Supplier Description</td>
						<td>Action</td>
					</tr>
				</thead>
				<c:forEach var="supplier" items="${supplierList}">
					<tr>
						<td>${supplier.id}</td>
						<td>${supplier.name}</td>
						<td>${supplier.description}</td>
						<td><a href="manage-supplier-delete/${supplier.id}" class="btn btn-danger"><i class="fa fa-trash-o fa-lg"></i> Delete</a> <a href="manage-supplier-edit/${supplier.id}" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

</body>
</html>