<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<c:if test="${isAdminClickedEditUser=='true'}">
			<div class="h2">Update User</div>

			<!-- Update User -->
			<form action="manage-user-update" class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-2">Full Name:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="name" placeholder="Name" value="${selectedUser.name}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Mobile:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="contact" placeholder="Mobile" value="${selectedUser.contact}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Username:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="id" placeholder="Username" value="${selectedUser.id}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Password:</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password" placeholder="Password" value="${selectedUser.password}" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Role:</label>
					<div class="col-sm-10">
						<select name="role" class="form-control" selected="${selectedUser.role}">
							<option value="ROLE_USER">User</option>
							<option value="ROLE_ADMIN">Admin</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-warning">
							<i class="fa fa-user-plus" aria-hidden="true"></i> Update User
						</button>
					</div>
				</div>

			</form>
		</c:if>
		<c:if test="${!isAdminClickedEditUser=='true'}">
			<!-- Create User -->
			<div class="h2">Add User</div>
			<form action="manage-user-add" class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-2">Full Name:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="name" placeholder="Name" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Mobile:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="contact" placeholder="Mobile" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Username:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="id" placeholder="Username" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Password:</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password" placeholder="Password" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Role:</label>
					<div class="col-sm-10">
						<select name="role" class="form-control" selected="${selectedUser.role}">
							<option value="ROLE_USER">User</option>
							<option value="ROLE_ADMIN">Admin</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-warning">
							<i class="fa fa-user-plus" aria-hidden="true"></i> Add User
						</button>
					</div>
				</div>
			</form>
		</c:if>


		<div class="h2">Show Users</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<td>Name</td>
					<td>Contact</td>
					<td>ID</td>
					<td>Password</td>
					<td>Role</td>
					<td>Manage</td>
				</tr>
			</thead>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.name}</td>
					<td>${user.contact}</td>
					<td>${user.id}</td>
					<td>${user.password}</td>
					<td>${user.role}</td>
					<td>
						<a href="manage-user-delete/${user.id}" class="btn btn-danger"><i class="fa fa-trash-o fa-lg"></i> Delete</a> 
						<a href="manage-user-edit/${user.id}" class="btn btn-info"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>