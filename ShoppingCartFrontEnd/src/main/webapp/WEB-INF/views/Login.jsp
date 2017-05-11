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
  <h2>Login</h2>
   <c:url var="action" value="/j_spring_security_check"/> 
  <form name="loginForm" class="form-horizontal" action="${action}" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="id">Username:</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="id" id="id" placeholder="Enter Username" pattern=".{5,15}" title="Username must have 5 to 15 characters" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="password">Password:</label>
      <div class="col-sm-10">          
        <input type="password" class="form-control" name="password" id="password" placeholder="Enter password" pattern=".{5,15}" title="Password must have 5 to 15 characters" required>
      </div>
    </div>
    <!-- <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox"> Remember me</label>
        </div>
      </div>
    </div> -->
    <div class="form-group">  
    <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />      
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-warning">Submit</button>
      </div>
    </div>
  </form>
</div>

</body>
</html>