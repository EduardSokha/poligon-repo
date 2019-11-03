<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Transfer between cards</title>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>

</head>

<!-- ----------------------------------------------------- -->

<body>
	<p>Transfer</p>
	
	<form action="controller" method="post">
			<input type="hidden" name="command" value="TRANSFER_BETWEEN_USERS_CARDS" />
			<input type="text" id="cardFrom" name="cardFrom" value="" size="25" maxlength="25" required/>
			<label for="cardFrom">Card from</label><br>
			<input type="text" id="cardTo" name="cardTo" value="" size="25" maxlength="25" required/>
			<label for="cardTo">Card to</label><br>
			<input type="text" id="amount" name="amount" value="" size="25" maxlength="25" required/>
			<label for="amount">Amount</label><br>
			<input type="submit" value="Transfer" />
	</form>
	
	<c:out value="${sessionScope.transferBetweenUsersCards}"/>
	
	<form action="controller" method="get">
			<input type="hidden" name="command" value="GO_TO_MAIN_ACCOUNT" /> 
			<input type="submit" value="Back" /><br>
	</form>

</body>
</html>