<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<div class="h2">Manage Supplier</div>
		<form class="form-horizontal" action="manage_supplier_add">
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
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>

	</div>

</body>
</html>