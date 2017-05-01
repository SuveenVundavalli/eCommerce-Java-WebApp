<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Categories</title>
</head>
<body>
	<div class="container">
		<div class="h2">Manage Categories</div>
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
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>

	</div>

</body>
</html>