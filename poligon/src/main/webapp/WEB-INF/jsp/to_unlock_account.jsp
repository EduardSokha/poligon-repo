<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Unlock account</title>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>

</head>

<body>

	<form action="controller" method="post">	
		<input type="hidden" name="command" value="unlock_account" /> 		
		<input type="text" id="idAccount" name="idAccount" value="6" size="25" maxlength="25" required/>
		<label for="idAccount">Id account</label><br>
		<input type="submit" value="Save" /><br>
	</form>
	
	
	<!-- <h1><%= request.getAttribute("toUnlockAccount")%></h1>-->
	<c:out value="${sessionScope.toUnlockAccount}"/>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_ADMIN_MAIN_ACCOUNT" /> 
		<input type="submit" value="Back" /><br>
	</form>
	
</body>
</html>

<!-- <input type="text" name="name" value="Roma" /><br>-->
		<!--  <input type="text" name="surname" value="Nilikovskiy" /><br>-->
		