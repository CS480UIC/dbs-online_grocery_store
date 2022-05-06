<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Fruit Orders </h3>
	<table border="1" width="60%" align="center">
	<tr>
		<th>User</th>
		<th>Fruit Ordered</th>
		<th>Quantity</th>
	</tr>
<c:forEach items="${OrderList}" var="order">
	<tr>
		<td>${order.user}</td>
		<td>${order.fruit}</td>
		<td>${order.quantity}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
