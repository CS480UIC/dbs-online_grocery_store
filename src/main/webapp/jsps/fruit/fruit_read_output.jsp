<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Fruit</title>
    
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
  <h1>Read Fruit Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Product ID    :<input type="text" name="productID" value="${fruit.productID }" disabled/>
	<br/>
	Fruit Name：<input type="text" name="fruit_name" value="${fruit.fruit_name }" disabled />
	<br/>
	Fruit Price	：<input type="text" name="fruit_price" value="${fruit.fruit_price}" disabled/>
	<br/>
	Quantity	：<input type="text" name="quantity" value="${fruit.quantity}" disabled/>
	<br/>
	Fruit Picture	：<input type="text" name="fruit_picture" value="${fruit.fruit_picture}" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
