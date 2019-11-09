<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>To lock account</title>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>

</head>

<!-- ----------------------------------------------------- -->

<body>

	<form action="controller" method="post">
		<input type="hidden" name="command" value="lock_account" />		
		<input type="text" id="idAccount" name="idAccount" value="" size="25" maxlength="25" required/>
		<label for="idAccount">Id account</label><br>		
		<input type="submit" value="Save" /><br>
	</form>
		
		<c:out value="${sessionScope.toLockAccount}"/>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_ADMIN_MAIN_ACCOUNT" /> 
		<input type="submit" value="Back" /><br>
	</form>

</body>
</html>
