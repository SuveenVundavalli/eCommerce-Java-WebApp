<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script> -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="Home">Shopping Cart Web App</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="Home">Home</a></li>

				<!-- Dropdown of category -->


				<c:forEach var="category" items="${categoryList}">
					<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">${category.name} <span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<c:forEach var="product" items="${productList}">
								<c:if test="${product.category_id == category.id}">
									<li><a href="#">${product.name}</a></li>
								</c:if>

								<!-- <li><a href="#">${product.name}</a></li> -->
							</c:forEach>


						</ul></li>
				</c:forEach>



				<%-- Toggle Product--%>
				<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">All Products <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">

						<c:forEach var="product" items="${productList}">
							<li><a href="#">${product.name}</a></li>

						</c:forEach>
					</ul></li>
				<%----%>
				<li><a href="#">Men</a></li>
				<li><a href="#">Women</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="RegistrationPage"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="LoginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">${message}</div>

</body>
</html>
