<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Credit card Create</title>
    
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
  <h1>Credit_card Create</h1>
<form action="<c:url value='/CreditCardServletCreate'/>" method="post">

	Credit Card Number    :<input type="text" name="credit_card_number" value="${form.credit_card_number }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	CVV：<input type="text" name="cvv" value="${form.cvv }"/>
	<span style="color: red; font-weight: 900">${errors.cvv }</span>
	<br/>
	Expiration Date	：<input type="text" name="expiration_date" value="${form.expiration_date }"/>
	<span style="color: red; font-weight: 900">${errors.expiration_date }</span>
	<br/>
	 credit card owner name 	：<input type="text" name="credit_card_owner_name" value="${form.credit_card_owner_name }"/>
	<span style="color: red; font-weight: 900">${errors.credit_card_owner_name }</span>
	<br/>
	
	<input type="submit" value="Credit Card"/>
</form>
  </body>
</html>
