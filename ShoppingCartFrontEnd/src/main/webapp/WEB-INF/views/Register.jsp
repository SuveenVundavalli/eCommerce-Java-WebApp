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
  <h2>Register</h2>
  <form class="form-horizontal" action="Register" method="POST">
    <div class="form-group">
      <label class="control-label col-sm-2" for="fName">Full Name:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="fName" placeholder="Enter Full Name" name="uName">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uName">Username:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="uName" placeholder="Enter Username" name="uId">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uContact">Mobile:</label>
      <div class="col-sm-10">          
        <input type="number" class="form-control" id="uContact" placeholder="Enter Mobile Number" name="uContact">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uPassword">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="uPassword" placeholder="Enter Password" name="uPassword">
      </div>
    </div>
   
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-warning">Register</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>