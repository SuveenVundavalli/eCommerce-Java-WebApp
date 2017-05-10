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
	<div class="h2">View All Products</div>
	<hr>
	<table>
		<c:forEach var="product" items="${productList}">
		<tr>
			<td>
				<img alt="${product.name}" width="25%" src="<c:url value="/resources/img/${product.id}.jpeg" />">
			</td>
			<td>
				<a href="">Add to Cart</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	
</div>

</body>
</html>