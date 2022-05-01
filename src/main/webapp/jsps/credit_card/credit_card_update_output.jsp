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
  <h1>Update Credit Card</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Credit Card Number ：<input type="text" name="credit_card_number" value="${credit_card.getCreditcardnumber() }" disabled/>
	<br/>
	CVV：<input type="text" name="cvv" value="${credit_card.getCvv() }" disabled/>
	<br/>
	Expiration Date	：<input type="text" name="expiration_date" value="${credit_card.getExpirationdate() }" disabled/>
	<br/>
	 Credit Card Owner Name ：<input type="text" name="credit_card_owner_name" value="${credit_card.getCreditcardname() }" disabled/>
	<br/>
</form>

<h1>Update the values below</h1>
<form action="<c:url value='/CreditCardServletUpdate'/>" method="post">
		<input type="hidden" name="method" value="update"/>
	Credit Card Number ：<input type="text" name="credit_card_number" value="${form.getCreditcardnumber() }" disabled/>
	<br/>
	CVV：<input type="text" name="cvv" value="${form.getCvv() }" disabled/>
	<br/>
	Expiration Date	：<input type="text" name="expiration_date" value="${form.getExpirationdate() }" disabled/>
	<br/>
	 Credit Card Owner Name ：<input type="text" name="credit_card_owner_name" value="${form.getCreditcardname() }" disabled/>
	<br/>
	<input type="submit" value="Update Credit Card"/>
</form>

</body>
</html>
