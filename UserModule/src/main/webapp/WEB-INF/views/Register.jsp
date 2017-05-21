<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="well">
			<div class="h2">Register</div>
			<form action="JoinUs" class="form-horizontal">
				<div class="form-group">
					<label class="control-label col-sm-2">Full Name:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="name" placeholder="Name" pattern=".{5,40}" title="Name must have 5 to 40 characters" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Mobile:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="contact" placeholder="Mobile" pattern="[789][0-9]{9}" title="Mobile number should have 10 digits and should start with 7/8/9" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Username:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="id" placeholder="Username" pattern=".{5,15}" title="Username must have 5 to 15 characters" required/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">Password:</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password" placeholder="Password" pattern=".{5,15}" title="Password must have 5 to 15 characters" required/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-warning">
							<i class="fa fa-user-plus" aria-hidden="true"></i> Join Us
						</button>
					</div>
				</div>
			</form>

		</div>
	</div>
</body>
</html>