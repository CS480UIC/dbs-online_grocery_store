<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Vegetable Output</title>
    
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
  <h1>Read Vegetable Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>

	Product ID: <input type="text" name="product_id" value="${vegetable.product_id }" disabled/>
	<br/>
	Vegetable Name: <input type="text" name="veg_name" value="${vegetable.veg_name }" disabled/>
	<br/>
	Vegetable price: <input type="text" name="veg_price" value="${vegetable.veg_price }" disabled/>
	<br/>
	Vegetable Quantity: <input type="text" name="veg_quantity" value="${vegetable.veg_quantity }" disabled/>
	<br/>
	Vegetable Picture: <input type="text" name="veg_picture" value="${vegetable.veg_picture }" disabled/>
	<br/>
	
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
