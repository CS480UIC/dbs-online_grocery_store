<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title> Create History </title>
    
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
  <h1>Create History </h1>
<form action="<c:url value='/HistoryServletCreate'/>" method="post">
	
	Order ID：<input type="text" name="order_id" value="${form.order_id }"/>
	<span style="color: red; font-weight: 900">${errors.order_id }</span>
	<br/>
	User name：<input type="text" name="username" value="${form.username }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	Items:<input type="text" name="items" value="${form.items }"/>
	<span style="color: red; font-weight: 900">${errors.items }</span>
	<br/>
	Order Date：<input type="text" name="order_date" value="${form.order_date }"/>
	<span style="color: red; font-weight: 900">${errors.order_date }</span>
	<br/>

	<input type="submit" value="Create History"/>
</form>
  </body>
</html>
