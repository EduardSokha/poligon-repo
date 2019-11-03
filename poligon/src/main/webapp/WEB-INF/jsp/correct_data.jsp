<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Correction data user</title>

	<style type="text/css">
		input {
		width: 200px;
		}
	</style>

</head>

<!-- ------------------------------------------------------------------ -->

<body>

	<h1>Correction data</h1>
	
	<!--<c:out value="${requestScope.resp}"/>
	
	<c:out value="${sessionScope.resp1}"/>
	<c:out value="${requestScope.resp}"/>-->
	
	<form action="controller" method="post">
			<input type="hidden" name="command" value="CORRECTION_LOGIN" />
			<input type="text" id="newLogin" name="newLogin" value="" size="25" maxlength="25"/> 
			<label for="newLogin">New login</label><br>	
			<input type="submit" value="Save new login" />
	</form>
	<c:out value="${sessionScope.correctionLogin}"/>
	<br>
	
	<form action="controller" method="post">
			<input type="hidden" name="command" value="CORRECTION_NAME" />
			<input type="text" id="newName" name="newName" value="" size="25" maxlength="25"/> 		
			<label for="newName">New name</label><br>
			<input type="submit" value="Save new name" />
	</form>
	<c:out value="${sessionScope.correctionName}"/>
	<br>
	
	<form action="controller" method="post">
			<input type="hidden" name="command" value="CORRECTION_SURNAME" />
			<input type="text" id="newSurname" name="newSurname" value="" size="25" maxlength="25"/> 
			<label for="newSurname">New surname</label><br>	
			<input type="submit" value="Save new surname" />
	</form>
	<c:out value="${sessionScope.correctionSurname}"/>
	<br>
	
	<form action="controller" method="post">
			<input type="hidden" name="command" value="CORRECTION_ADDRESS" />
			<input type="text" id="newAddress" name="newAddress" value="" size="25" maxlength="25"/> 		
			<label for="newAddress">New address</label><br>
			<input type="submit" value="Save new address" />
	</form>
	<c:out value="${sessionScope.correctionAddress}"/>
	<br>
	
	<form action="controller" method="post">
			<input type="hidden" name="command" value="CORRECTION_CODEWORD"/>
			<input type="text" id="newCodeword" name="newCodeword" value="" size="25" maxlength="25"/> 		
			<label for="newCodeword">New codeword</label><br>
			<input type="submit" value="Save new codeword" />
	</form>
	<c:out value="${sessionScope.correctionCodeWord}"/>
	<br>
	
	<form action="controller" method="post">
			<input type="hidden" name="command" value="CORRECTION_PHONE_NUMBER"/>		
			<input type="text" id="newPhoneNumber" name="newPhoneNumber" value="" size="25" maxlength="25"/> 		
			<label for="newPhoneNumber">New phone number</label><br>
			<input type="submit" value="Save new phone number"/>
	</form>
	<c:out value="${sessionScope.correctionPhoneNumber}"/>
	<br>
	
	<form action="controller" method="post">
			<input type="hidden" name="command" value="CORRECTION_RESIDENCE_REGISTRATION" />
			<input type="text" id="newResidenceRegistr" name="newResidenceRegistr" value="" size="25" maxlength="25"/> 		
			<label for="newResidenceRegistr">New residence registration</label><br>
			<input type="submit" value="Save new residence registration"/>
	</form>
	<c:out value="${sessionScope.correctionResidenceRegistr}"/>
	
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_MAIN_ACCOUNT" /> 
		<input type="submit" value="Back" /><br>
	</form>

</body>
</html>