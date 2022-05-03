<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Meat Output</title>
    
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
  <h1>Read Meat Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	
	Meat Name :<input type="text" name="meat_name" value="${meat.getMeatName() }" disabled/>
	<br/>
	Meat Price ：<input type="text" name="meat_price" value="${meat.getMeatPrice() }" disabled/>
	<br/>
	Meat Quantity	：<input type="text" name="meat_quantity" value="${meat.getMeatQuantity() }" disabled/>
	<br/>
	Product ID ：<input type="text" name="product_id" value="${meat.getProduct_id() }" disabled/>
	<br/>
	Meat Picture ：<input type="text" name="meat_picture" value="${meat.getMeatPicture() }" disabled/>
	<br/>
	
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
