<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Entity Output</title>
    
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
  <h1>Read Delivery Info Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	
	Driver ID:<input type="text" name="driver_id" value="${delivery_info.getDriver_id() }" disabled/>
	<br/>
	User Name：<input type="text" name="username" value="${delivery_info.getUsername() }" disabled/>
	<br/>
	Driver Proximity	：<input type="text" name="driver_proximity" value="${delivery_info.getDriver_proximity() }" disabled/>
	<br/>
	Vehicle Type	：<input type="text" name="vehicle_type" value="${delivery_info.getVehicle_type() }" disabled/>
	<br/>
	
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
