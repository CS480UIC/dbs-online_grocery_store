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
  <h1>Update Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Order ID：<input type="text" name="order_id" value="${history.getOrder_id() }" disabled/>
	<br/>
	User name：<input type="text" name="username" value="${history.getUsername() }" disabled/>
	<br/>
	Items:<input type="text" name="items" value="${history.getItems() }" disabled/>
	<br/>
	Order Date：<input type="text" name="order_date" value="${history.getOrder_date() }" disabled/>
	<br/>
</form>

<h1>Update the values below</h1>
<form action="<c:url value='/HistoryServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
	Order ID：<input type="text" name="order_id" value="${form.getOrder_id() }" disabled/>
	<br/>
	User name：<input type="text" name="username" value="${form.getUsername() }" disabled/>
	<br/>
	Items:<input type="text" name="items" value="${form.getItems() }" disabled/>
	<br/>
	Order Date：<input type="text" name="order_date" value="${form.getOrder_date() }" disabled/>
	<br/>
	<input type="submit" value="Update History"/>
</form>

</body>
</html>

