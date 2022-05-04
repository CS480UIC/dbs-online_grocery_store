<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Delivery Info Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Driver ID</th>
		<th>Username</th>
		<th>Driver Proximity</th>
		<th>Vehicle Type</th>
	</tr>
<c:forEach items="${DeliveryInfoList}" var="delivery_info">
	<tr>
		<td>${delivery_info.driver_id}</td>
		<td>${delivery_info.username}</td>
		<td>${delivery_info.driver_proximity}</td>
		<td>${delivery_info.vehicle_type}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
