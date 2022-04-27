<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Meat</title>
    
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
  <h1>Delete Meat</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/MeatServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="product_id" value="${meat.product_id }" disabled/>
	Meat Name :<input type="text" name="meat_name" value="${form.meat_name }" disabled/>
	<span style="color: red; font-weight: 900">${errors.meat_name }</span>
	<br/>
	Meat Price：<input type="text" name="meat_price" value="${form.meat_price }" disabled/>
	<span style="color: red; font-weight: 900">${errors.meat_price }</span>
	<br/>
	Meat Weight	：<input type="text" name="meat_weight" value="${form.meat_weight }" disabled/>
	<span style="color: red; font-weight: 900">${errors.meat_weight }</span>
	<br/>
	Product ID	：<input type="text" name="product_id" value="${form.product_id }" disabled/>
	<span style="color: red; font-weight: 900">${errors.product_id }</span>
	<br/>
	Meat Picture	：<input type="text" name="meat_picture" value="${form.meat_picture }" disabled/>
	<span style="color: red; font-weight: 900">${errors.meat_picture }</span>
	<br/>
	<input type="submit" value="Delete Meat"/>
</form>

</body>
</html>
