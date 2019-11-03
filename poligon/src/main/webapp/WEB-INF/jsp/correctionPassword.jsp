<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Correction password</title>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>

</head>

<!-- ----------------------------------------------------------------- -->

<body>

	<form action="controller" method="post">
			<input type="hidden" name="command" value="CORRECTION_PASSWORD"/>
			<input type="password" id="oldPassw" name="oldPassword" value="" size="25" maxlength="25" required/> 
			<label for="oldPassw">Old password</label><br>
			<input type="password" id="newPassw1" name="newPassword1" value="" size="25" maxlength="25" required/> 
			<label for="newPassw1">New password</label><br>
			<input type="password" id="newPassw2" name="newPassword2" value="" size="25" maxlength="25" required/>
			<label for="newPassw2">Repeat new password</label><br>
			<input type="submit" value="Save new password"/>
	</form>
	
	<!--<c:out value="${requestScope.resp}"/>-->
	
	<c:out value="${sessionScope.correctionPassword}"/>
	<c:out value="${requestScope.mistake}"/>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_MAIN_ACCOUNT" /> 
		<input type="submit" value="Back" /><br>
	</form>

</body>
</html>