<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Fruit Create</title>
    
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
  <h1>Fruit Create</h1>
<form action="<c:url value='/FruitServletCreate'/>" method="post">
	Product ID    :<input type="text" name="productID" value="${form.productID }"/>
	<span style="color: red; font-weight: 900">${errors.productID }</span>
	<br/>
	Fruit Name：<input type="text" name="fruit_name" value="${form.fruit_name }"/>
	<span style="color: red; font-weight: 900">${errors.fruit_name}</span>
	<br/>
	Fruit Price	：<input type="text" name="fruit_price" value="${form.fruit_price}"/>
	<span style="color: red; font-weight: 900">${errors.fruit_price }</span>
	<br/>
	Quantity	：<input type="text" name="quantity" value="${form.quantity}"/>
	<span style="color: red; font-weight: 900">${errors.quantity }</span>
	<br/>
	Fruit Picture	：<input type="text" name="fruit_picture" value="${form.fruit_picture}"/>
	<span style="color: red; font-weight: 900">${errors.fruit_picture }</span>
	<br/>
	<input type="submit" value="Create Fruit"/>
</form>
  </body>
</html>
