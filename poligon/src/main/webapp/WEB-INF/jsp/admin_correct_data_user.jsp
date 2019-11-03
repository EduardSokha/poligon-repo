<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Correction data users</title>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>

</head>



<body>

	<form action="controller" method="post">
			<input type="hidden" name="command" value="CORRECT_SERIES_NUMB_PASSPORT" />
			
			<input id="newSerNumbPassp" type="text" id="seriesPassport" name="newSeriesNumbPassport" value="VV36985" size="25" maxlength="25" required/> 	
			<label for="newSerNumbPassp">newSeriesNumbPassport</label><br>
			<input id="idUser" type="text" id="idUser" name="idUser" value="" size="25" maxlength="25" required/> 
			<label for="idUser">Id user</label><br>
			
			<input type="submit" value="Save"/>
	</form>
	
	<!--<c:out value="${requestScope.resp}"/>-->
	<c:out value="${sessionScope.correctionSeriesNumberPassport}"/>
	<br>
	
	<form action="controller" method="post">
			
			<input type="hidden" name="command" value="CORRECT_IDENTIFIC_NUMB_PASSPORT" />
			
			<input type="text" id="newIdentNumbPassp" name="newIdentificNumbPassport" value="35923v36" size="25" maxlength="25" required/> 
			<label for="newIdentNumbPassp">New identification number passport</label><br>
			<input type="text" id="idUser" name="idUser" value="" size="25" maxlength="25" required/> 		
			<label for="idUser">Id user</label><br>
			<input type="submit" value="Save"/>
	
	</form>
	
	
	<!--<c:out value="${requestScope.resp1}"/>-->
	<c:out value="${sessionScope.correctIdentificNumbPassp}"/>
	
	
	<form action="controller" method="get">	
		<input type="hidden" name="command" value="GO_TO_ADMIN_MAIN_ACCOUNT" /> 
		<input type="submit" value="Back" /><br>	
	</form>
	
</body>
</html>