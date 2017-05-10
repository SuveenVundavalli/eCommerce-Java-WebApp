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
        <input type="text" class="form-control" id="fName" placeholder="Enter Full Name" name="uName" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uName">Username:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" id="uName" placeholder="Enter Username" name="uId" pattern=".{5,15}" title="Username must have 5 to 15 characters" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uContact">Mobile:</label>
      <div class="col-sm-10">          
        <input type="text" class="form-control" id="uContact" placeholder="Enter Mobile Number" name="uContact"  pattern="[789][0-9]{9}" title="Mobile number should have 10 digits and should start with 7/8/9" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="uPassword">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" id="uPassword" placeholder="Enter Password" name="uPassword" pattern=".{5,15}" title="password must have 5 to 15 characters" required >
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