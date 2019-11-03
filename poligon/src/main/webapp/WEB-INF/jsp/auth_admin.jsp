<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">

<title>Admin account</title>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>
<fmt:message bundle="${loc}" key="local.message" var="message"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>

<fmt:message bundle="${loc}" key="local.locbutton.admin_account.registr_admin" var="registr_admin"/>
<fmt:message bundle="${loc}" key="local.locbutton.admin_account.lock_account" var="lock_account"/>
<fmt:message bundle="${loc}" key="local.locbutton.admin_account.unlock_account" var="unlock_account"/>
<fmt:message bundle="${loc}" key="local.locbutton.admin_account.refill_account" var="refill_account"/>
<fmt:message bundle="${loc}" key="local.locbutton.admin_account.correct_cards" var="correct_cards"/>
<fmt:message bundle="${loc}" key="local.locbutton.admin_account.list_users" var="list_users"/>
<fmt:message bundle="${loc}" key="local.locbutton.admin_account.list_cards" var="list_cards"/>
<fmt:message bundle="${loc}" key="local.locbutton.admin_account.list_accounts" var="list_accounts"/>
<fmt:message bundle="${loc}" key="local.locbutton.admin_account.correct_data_users" var="correct_data_users"/>

<fmt:message bundle="${loc}" key="local.locbutton.quit" var="quit"/>



<style type="text/css">
	input {
	width: 150px;
	}
</style>

</head>

<body>

	<h1>Hello admin</h1>
	
	<!-- ----------------------------------------------------- -->
	<form action="controller" method="post">
	
	<input type="hidden" name="command" value="localization" /> 
	<input type="hidden" name="local" value="ru" />
	<input type="hidden" name="page" value="adminPage" />  
	<input type="submit" value="${ru_button}" /><br>
	
	</form>
	
	<form action="controller" method="post">
	
	<input type="hidden" name="command" value="localization" /> 
	<input type="hidden" name="local" value="en" /> 
	<input type="hidden" name="page" value="adminPage" />   
	<input type="submit" value="${en_button}"/><br>
	
	</form>
	
	<c:out value="${message}"/>
	
	
	<!-- ----------------------------------------------------- -->
	
	
	
	<a href="registration_admin">Registration Admin</a>
	<form action="controller" method="get">
			<input type="hidden" name="command" value="GO_TO_REGISTRATION_ADMIN" /> 		
			<input type="submit" value="${registr_admin}"  /><br>
	</form>
		
		
	<a href="to_lock_account">toLockAccount</a>
	<form action="controller" method="get">
			<input type="hidden" name="command" value="GO_TO_LOCK_ACCOUNT" /> 		
			<input type="submit" value="${lock_account}"  /><br>
	</form>
	
	
	<!-- <a href="delete_user">deleteUser</a>
	<form action="controller" method="post">
			<input type="hidden" name="command" value="GO_TO_LOCK_ACCOUNT" /> 		
			<input type="submit" value="не нажимать" /><br>
	</form>-->
	
	
	<a href="to_unlock_account">toUnlockAccount</a>
	<form action="controller" method="get">
			<input type="hidden" name="command" value="GO_TO_UNLOCK_ACCOUNT" /> 		
			<input type="submit" value="${unlock_account}" /><br>
	</form>
	
	
	<a href="refill">Refill Account</a>
	<form action="controller" method="get">
			<input type="hidden" name="command" value="GO_TO_REFILL" /> 		
			<input type="submit" value="${refill_account}"  /><br>
	</form>
	
	<form action="controller" method="get">
			<input type="hidden" name="command" value="GET_ALL_NAME_CARD" /> 
			<input type="submit" value="${correct_cards}"  /><br />
	</form>
	
	<form action="controller" method="get">
			<input type="hidden" name="command" value="GET_USERS" /> 
			<input type="submit" value="${list_users}" /><br />
	</form>
	
	<form action="controller" method="get">
			<input type="hidden" name="command" value="GET_CARDS" /> 
			<input type="submit" value="${list_cards}"  /><br/>
	</form>
	
	<form action="controller" method="get">
			<input type="hidden" name="command" value="GET_ACCOUNTS" /> 
			<input type="submit" value="${list_accounts}"  /><br/>
	</form>
	
	<form action="controller" method="get">
			<input type="hidden" name="command" value="GO_TO_ADMIN_CORRECTION_DATA" /> 		
			<input type="submit" value="${correct_data_users}"  /><br>
	</form>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_MAIN" /> 
		<input type="submit" value="${quit}"/><br>
	</form>

</body>
</html>