<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Registration admin</title>

	<style type="text/css">
		input {
		width: 150px;
		}
		select{
		width: 150px;
		}
	</style>

</head>

<!-- ----------------------------------------------------- -->

<body>

	<form action="controller" method="post">
		<input type="hidden" name="command" value="registration_admin" />		
		<input type="text" id="idUser" name="idUser" value="" size="25" maxlength="25" required/>
		<label for="idUser">Id user</label><br>
		<select name="role" id="role" id="nameCards">
	        <option value="1">ADMIN</option>
	        <option value="2">USER</option>
       	</select>
		<label for="role">Role</label><br>
		<input type="submit" value="Save" /><br />
	</form>
	
	<c:out value="${sessionScope.registrationAdmin}"/>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_ADMIN_MAIN_ACCOUNT" /> 
		<input type="submit" value="Back" /><br>
	</form>

</body>
</html>