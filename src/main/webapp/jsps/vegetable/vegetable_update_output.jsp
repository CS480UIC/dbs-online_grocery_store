<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
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
  <h1>Update Vegetable</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Product ID: <input type="text" name="product_id" value="${vegetable.product_id() }" disabled/>
	<br/>
	Vegetable Name: <input type="text" name="veg_name" value="${vegetable.getVegName() }" disabled/>
	<br/>
	Vegetable price: <input type="text" name="veg_price" value="${vegetable.getVegPrice() }" disabled/>
	<br/>
	Vegetable Quantity: <input type="text" name="veg_quantity" value="${vegetable.getVegQuantity() }" disabled/>
	<br/>
	Vegetable Picture: <input type="text" name="veg_picture" value="${vegetable.getVegPicture() }" disabled/>
	<br/>
</form>

<h1>Update the values below</h1>
<form action="<c:url value='/VegetableServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
	Product ID: <input type="text" name="product_id" value="${form.product_id() }" />
	<br/>
	Vegetable Name: <input type="text" name="veg_name" value="${form.getVegName() }" />
	<br/>
	Vegetable price: <input type="text" name="veg_price" value="${form.getVegPrice() }" />
	<br/>
	Vegetable Quantity: <input type="text" name="veg_quantity" value="${form.getVegQuantity() }" />
	<br/>
	Vegetable Picture: <input type="text" name="veg_picture" value="${form.getVegPicture() }" />
	<input type="submit" value="Update Vegetable"/>
</form>

</body>
</html>
