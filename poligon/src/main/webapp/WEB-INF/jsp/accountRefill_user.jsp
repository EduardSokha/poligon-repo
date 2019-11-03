<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<title>Refill account</title>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>

</head>



<body>
	<h1>Refill account</h1>

	<form action="controller" method="post">
		<input type="hidden" name="command" value="account_Refill" />		
		
		<input type="text" id="idCard"  name="idCard" value="6" size="25" maxlength="25"  required/>
		<label for="idCard">Id card</label><br>
		<input type="text" id="amount" name="amount" value="38" size="25" maxlength="25"  required/>
		<label for="amount">Payment amount</label><br>
		
		<!--  <input type="password" name="pass" value="" />--> 
		<input type="submit" value="Sign in" /><br>
	</form>

	<!--  <h1><%= request.getAttribute("accountRefill")%></h1>-->
	<c:out value="${sessionScope.accountRefill}"/>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_ADMIN_MAIN_ACCOUNT" /> 
		<input type="submit" value="Back" /><br>
	</form>

</body>
</html>