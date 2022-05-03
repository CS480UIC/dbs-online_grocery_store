<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delivery Info Create</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Delivery Info Create</h1>
<form action="<c:url value='/DeliveryInfoServletCreate'/>" method="post">

	Driver ID:<input type="text" name="driver_id" value="${form.driver_id }"/>
	<span style="color: red; font-weight: 900">${errors.driver_id }</span>
	<br/>
	User Name：<input type="text" name="user_id" value="${form.user_id }"/>
	<span style="color: red; font-weight: 900">${errors.user_id }</span>
	<br/>
	Driver Proximity	：<input type="text" name="driver_proximity" value="${form.driver_proximity }"/>
	<span style="color: red; font-weight: 900">${errors.driver_proximity }</span>
	<br/>
	Vehicle Type	：<input type="text" name="vehicle_type" value="${form.vehicle_type }"/>
	<span style="color: red; font-weight: 900">${errors.vehicle_type }</span>
	<br/>
	
	<input type="submit" value="Create Delivery Info"/>
	
</form>
  </body>
</html>
