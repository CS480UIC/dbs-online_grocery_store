<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Vegetable</title>
    
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
  <h1>Create Vegetable</h1>
<form action="<c:url value='/VegetableServletCreate'/>" method="post">
	Product ID: <input type="text" name="product_id" value="${form.product_id }"/>
	<span style="color: red; font-weight: 900">${errors.product_id }</span>
	<br/>
	Vegetable Name：<input type="text" name="veg_name" value="${form.veg_name }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	Vegetable Price：<input type="text" name="veg_price" value="${form.veg_price }"/>
	<span style="color: red; font-weight: 900">${errors.veg_price }</span>
	<br/>
	Vegetable Quantity：<input type="text" name="veg_quantity" value="${form.veg_quantity }"/>
	<span style="color: red; font-weight: 900">${errors.veg_quantity }</span>
	<br/>
	Vegetable Picture：<input type="text" name="veg_picture" value="${form.veg_picture }"/>
	<span style="color: red; font-weight: 900">${errors.veg_picture }</span>
	<br/>
	<input type="submit" value="Create Vegetable"/>
</form>
  </body>
</html>
