<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="container">
		
		<div class="container">
			<div class="col-xs-offset-5 col-xs-2" style="padding-left: 0px; padding-right: 0px;">
				<img src="<c:url value="/resources/images/checkMark.png" />" class="img-responsive">
			</div>
		</div>

		<div class="h2 text-success text-center">You are awesome!</div>
		<div class="h2 text-center">Thank you for checking out. The amount of <b class="text-success"><i class="fa fa-inr" aria-hidden="true"></i> ${totalAmount}</b> has been received.</div>
		<div class="h2 text-center">The product will be delivered in 2-3 business days.</div>

		<img src="<c:url value="/resources/images/ThankYou.gif" />" alt="Thank You GIF" class="img-responsive center-block" />

	</div>
</body>
</html>