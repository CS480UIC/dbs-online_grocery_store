<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Person Output</title>
    
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
  <h1>Read Person Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	
	User Name   :<input type="text" name="username" value="${person.username }" disabled/>
	<br/>
	First Name：<input type="text" name="first_name" value="${person.first_name }" disabled/>
	<br/>
	Last Name：<input type="text" name="last_name" value="${person.last_name }" disabled/>
	<br/>
	Address：<input type="text" name="address" value="${person.address }" disabled/>
	<br/>
	Email：<input type="text" name="email" value="${person.email }" disabled/>
	<br/>
	Password：<input type="password" name="password" value="${person.password }" disabled/>
	<br/>
	Credit Card Number：<input type="text" name="credit_card_number" value="${person.password }" disabled/>
	<br/>
	
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>
