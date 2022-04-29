<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Meat Create</title>
    
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
  <h1>Meat Create</h1>
<form action="<c:url value='/MeatServletCreate'/>" method="post">
	Meat Name :<input type="text" name="meat_name" value="${form.meat_name }"/>
	<span style="color: red; font-weight: 900">${errors.meat_name }</span>
	<br/>
	Meat Price：<input type="text" name="meat_price" value="${form.meat_price }"/>
	<span style="color: red; font-weight: 900">${errors.meat_price }</span>
	<br/>
	Meat Quantity	：<input type="text" name="meat_quantity" value="${form.meat_quantity }"/>
	<span style="color: red; font-weight: 900">${errors.meat_quantity }</span>
	<br/>
	Product ID	：<input type="text" name="product_id" value="${form.product_id }"/>
	<span style="color: red; font-weight: 900">${errors.product_id }</span>
	<br/>
	Meat Picture	：<input type="text" name="meat_picture" value="${form.meat_picture }"/>
	<span style="color: red; font-weight: 900">${errors.meat_picture }</span>
	<br/>
	<input type="submit" value="Create Meat"/>
</form>
  </body>
</html>
