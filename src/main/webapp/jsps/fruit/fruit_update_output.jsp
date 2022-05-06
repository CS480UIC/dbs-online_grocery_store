<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Fruit</title>
    
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
  <h1>Update Fruit</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Product ID    :<input type="text" name="product_id" value="${fruit.product_id }" disabled/>
	<br/>
	Fruit Name：<input type="text" name="fruit_name" value="${fruit.fruit_name }" disabled />
	<br/>
	Fruit Price	：<input type="text" name="fruit_price" value="${fruit.fruit_price}" disabled/>
	<br/>
	Quantity	：<input type="text" name="fruit_quantity" value="${fruit.fruit_quantity}" disabled/>
	<br/>
	Fruit Picture	：<input type="text" name="fruit_picture" value="${fruit.fruit_picture}" disabled/>
	<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/FruitServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
	Product ID    :<input type="text" name="product_id" value="${form.product_id }"/>
	<span style="color: red; font-weight: 900">${errors.productID }</span>
	<br/>
	Fruit Name：<input type="text" name="fruit_name" value="${form.fruit_name }"/>
	<span style="color: red; font-weight: 900">${errors.fruit_name}</span>
	<br/>
	Fruit Price	：<input type="text" name="fruit_price" value="${form.fruit_price}"/>
	<span style="color: red; font-weight: 900">${errors.fruit_price }</span>
	<br/>
	Quantity	：<input type="text" name="fruit_quantity" value="${form.fruit_quantity}"/>
	<span style="color: red; font-weight: 900">${errors.quantity }</span>
	<br/>
	Fruit Picture	：<input type="text" name="fruit_picture" value="${form.fruit_picture}"/>
	<span style="color: red; font-weight: 900">${errors.fruit_picture }</span>
	<br/>
	<input type="submit" value="Update Fruit"/>
</form>

</body>
</html>
