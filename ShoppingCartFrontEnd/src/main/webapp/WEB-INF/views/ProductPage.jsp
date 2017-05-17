<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="well">
			

			<div class="container">
				<div class="col-md-4 col-sm-12">
					<img class="img-responsive center-block" src="<c:url value="/resources/img/${selectedProduct.id}.jpeg" />" alt="${selectedProduct.name}" />
				</div>
				<div class="col-md-5 col-xs-7">
					<div class="h2">${selectedProduct.name}</div>
					<div class="h3">Product description: ${selectedProduct.description}</div>
					<div class="h4">Product category: ${selectedProduct.category_id}</div>
					<div class="h4">Product seller: ${selectedProduct.supplier_id}</div>
				</div>
				<div class="col-md-3 col-xs-5">
					
						<div class="h2">${selectedProduct.price}</div>
						<c:if test="${isUserLoggedIn=='true'}">
							<a href="myCart-add/${selectedProduct.id}" class="btn btn-success">
								Add to cart <i class="fa fa-cart-plus" aria-hidden="true"></i>
							</a>
						</c:if>
						<c:if test="${isAdmin=='true'}">
							<a href="secure_logout" class="btn btn-success">
								Login as user to add to cart <i class="fa fa-cart-plus" aria-hidden="true"></i>
							</a>
						</c:if>
						<c:if test="${!isUserLoggedIn=='true' && !isAdmin =='true'}">
							<a href="Login" class="btn btn-success">
								Login to add to cart <i class="fa fa-cart-plus" aria-hidden="true"></i>
							</a>
						</c:if>
				</div>
			</div>

		</div>
	</div>
</body>
</html>