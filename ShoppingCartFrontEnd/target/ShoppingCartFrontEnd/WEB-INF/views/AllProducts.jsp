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
  <div class="text-center">
  	<hr />
    <div class="h2">View All Products</div>
    <p class="bg-success">${successMessage}</p>
  </div>
  <hr />
  <c:forEach var="product" items="${productList}">
    <div class="col-md-4 col-sm-12">
      <div class="panel panel-default text-center">
        <div class="panel-heading">
          <div class="h3">${product.name}</div>
        </div>
        <div class="panel-body" >
          <img height="220px" width="250px" src="<c:url value="/resources/img/${product.id}.jpeg" />" alt="${product.name}" />
        </div>
        <div class="panel-footer">
 		<%-- <h3>${product.description}</h3>
          <hr /> --%>
	          <div class="row">
	          	<div class="col-md-5 col-sm-12 h5"><i class="fa fa-inr" aria-hidden="true"></i> ${product.price}</div>
	          	<div class="col-md-7 col-sm-12"><a href="myCart/add/${product.id}" class="btn btn-success">Add to cart <i class="fa fa-cart-plus" aria-hidden="true"></i></a></div>
	          </div>
        </div>
      </div>      
    </div>  
   </c:forEach>   
</div>


<%-- <div class="container">
	<div class="h2">View All Products</div>
	<hr>
	<table>
		<c:forEach var="product" items="${productList}">
		<tr>
			<td>
				<img alt="${product.name}" width="25%" src="<c:url value="/resources/img/${product.id}.jpeg" />">
			</td>
			<td>
				<a href="mycart/add/${product.id}">Add to Cart</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	
</div> --%>

</body>
</html>