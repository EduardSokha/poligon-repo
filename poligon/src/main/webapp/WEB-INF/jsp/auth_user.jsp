<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Account</title>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>
<fmt:message bundle="${loc}" key="local.message" var="message"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>

<fmt:message bundle="${loc}" key="local.locbutton.user_account.go_to_payment" var="payment"/>
<fmt:message bundle="${loc}" key="local.locbutton.user_account.go_to_add_card" var="go_to_add_card"/>
<fmt:message bundle="${loc}" key="local.locbutton.user_account.go_to_correct_data" var="go_to_correct_data"/>
<fmt:message bundle="${loc}" key="local.locbutton.user_account.get_acounts_cards" var="get_acounts_cards"/>
<fmt:message bundle="${loc}" key="local.locbutton.user_account.go_to_correction_passw" var="go_to_correction_passw"/>
<fmt:message bundle="${loc}" key="local.locbutton.user_account.go_to_correction_data" var="go_to_correction_data"/>
<fmt:message bundle="${loc}" key="local.locbutton.user_account.go_to_transfer_between_cards" var="go_to_transfer_between_cards"/>

<fmt:message bundle="${loc}" key="local.locbutton.quit" var="quit"/>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>
	
</head>
<body>

	<h1>Hello</h1>
	
	<form action="controller" method="post">
		<input type="hidden" name="command" value="localization" /> 
		<input type="hidden" name="local" value="ru" />
		<input type="hidden" name="page" value="userPage" />  
		<input type="submit" value="${ru_button}" /><br>
	</form>
	
	<form action="controller" method="post">
		<input type="hidden" name="command" value="localization" /> 
		<input type="hidden" name="local" value="en" /> 
		<input type="hidden" name="page" value="userPage" />   
		<input type="submit" value="${en_button}" /><br>
	</form>
	
	<c:out value="${message}"/>
	
	<!-- ----------------------------------------------------- -->
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_PAYMENT" /> 		
		<input type="submit" value="${payment}" /><br>
	</form>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_ADD_CARD_USER" /> 		
		<input type="submit" value="${go_to_add_card}" /><br>
	</form>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_CORRECT_DATA" /> 		
		<input type="submit" value="${go_to_correct_data}"/><br>
	</form>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GET_ACCOUNTS_CARDS" /> 
		<input type="submit" value="${get_acounts_cards}"/><br />
	</form>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_CORRECTION_PASSWORD" /> 		
		<input type="submit" value="${go_to_correction_passw}" /><br>
	</form>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_TRANSFER_BETWEEN_CARDS" /> 		
		<input type="submit" value="${go_to_transfer_between_cards}"/><br>
	</form>

	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_MAIN" /> 
		<input type="submit" value="${quit}"/><br>
	</form>

</body>
</html>