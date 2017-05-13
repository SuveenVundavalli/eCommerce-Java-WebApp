<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="container-margin">
			<div class="col-md-offset-1 col-md-10">
				<div class="carousel slide" id="carousel1" data-ride="carousel">

					<ol class="carousel-indicators">
						<li data-target="#carousel1" data-slide-to="0" class="active"></li>
						<li data-target="#carousel1" data-slide-to="1"></li>
						<li data-target="#carousel1" data-slide-to="2"></li>
						<li data-target="#carousel1" data-slide-to="3"></li>
						<li data-target="#carousel1" data-slide-to="4"></li>
					</ol>

					<div class="carousel-inner">
						<div class="item active">
							<a href="showProductByCategory/Canon">
								<img src="<c:url value="/resources/images/1.jpg" />" alt="Image 1">
							</a>

						</div>
						<div class="item">
							<a href="viewProduct/Canon1300D">
								<img src="<c:url value="/resources/images/2.jpg" />" alt="Image 2">
							</a>
						</div>
						<div class="item">
							<a href="showProductByCategory/Nikon">
								<img src="<c:url value="/resources/images/3.jpg" />" alt="Image 3">
							</a>
						</div>
						<div class="item">
							<a href="showProductByCategory/Olympus">
								<img src="<c:url value="/resources/images/4.jpg" />" alt="Image 4">
							</a>
						</div>
						<div class="item">
							<a href="showProductByCategory/Sony">
								<img src="<c:url value="/resources/images/5.jpg" />" alt="Image 5">
							</a>
						</div>

					</div>

					<a href="#carousel1" data-slide="prev" class="left carousel-control">
						<span class="glyphicon glyphicon-chevron-left"></span>
					</a>
					<a href="#carousel1" data-slide="next" class="right carousel-control">
						<span class="glyphicon glyphicon-chevron-right"></span>
					</a>

				</div>
			</div>
		</div>
	</div>
</body>
</html>