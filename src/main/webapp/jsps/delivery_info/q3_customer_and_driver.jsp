<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Customer and Driver Info </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>Customer First Name</th>
		<th>Driver ID</th>
		<th>Vehicle Type</th>
	</tr>
<c:forEach items="${CustomerAndDriverList}" var="customer_driver">
	<tr>
		<td>${customer_driver.first_name}</td>
		<td>${customer_driver.driver_id}</td>
		<td>${customer_driver.vehicle_type}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
