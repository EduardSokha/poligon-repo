<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Payment</title>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>

</head>

<!-- ----------------------------------------------------- -->

<body>

<h1>Payment</h1>

	<form action="controller" method="post">
		<input type="hidden" name="command" value="payment" />
		<input type="text" id="payAmount" name="paymentAmount" value="12" size="25" maxlength="25" required />
		<label for="payAmount">Payment amount</label><br>
		<input type="text" id="idAccount" name="idaccount" value="6" size="25" maxlength="25" required />
		<label for="idAccount">Id account</label><br>
		<input type="text" id="idAccountRecipient" name="idAccountRecipient" value="27" size="25" maxlength="25" required />
		<label for="idAccountRecipient">Id account recipient</label><br>
		<input type="text" id="sender" name="sender" value="sergey" size="25" maxlength="25" required />
		<label for="sender">Sender</label><br>
		<input type="submit" value="Pay" /><br />
	</form>
		
		<h1><c:out value="${sessionScope.payment}"/></h1>
		
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_MAIN_ACCOUNT" /> 
		<input type="submit" value="Back" /><br>	
	</form>

</body>
</html>