<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Person</title>
    
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
  <h1>Delete Person</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/PersonServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="username" value="${person.username }"/>
	User Name   :<input type="text" name="username" value="${person.getUsername() }" disabled/>
	<br/>
	First Name：<input type="text" name="first_name" value="${person.getFirstName() }" disabled/>
	<br/>
	Last Name：<input type="text" name="last_name" value="${person.getLastName() }" disabled/>
	<br/>
	Address：<input type="text" name="address" value="${person.getAddress() }" disabled/>
	<br/>
	Email：<input type="text" name="email" value="${person.getEmail() }" disabled/>
	<br/>
	Password：<input type="password" name="password" value="${person.getPassword() }" disabled/>
	<br/>
	Credit Card Number：<input type="text" name="credit_card_number" value="${person.getCreditCardNumber() }" disabled/>
	<br/>
	<input type="submit" value="Delete Person"/>
</form>

</body>
</html>
