<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edit cards data</title>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>

</head>

<!-- ----------------------------------------------------- -->

<body>

	<c:forEach var="name" items="${requestScope.getAllNameCard}">
		<c:out value="${name.idNameCard}"/>
		<c:out value="${name.nameCard}"/>
		<br>
	</c:forEach>
	<br>
	
	<form action="controller" method="post">
		<input type="hidden" name="command" value="ADD_NEW_NAME_CARD"/>
		<input type="text" id="addNewNameCard" name="newNameCard" value="" size="25" maxlength="25" required/> 		
		<label for="addNewNameCard">Add new name card</label><br>
		<input type="submit" value="Add" />
	</form>
	
	<c:out value="${sessionScope.addNewNameCard}"/>
	<br>
	
	<form action="controller" method="post">
		<input type="hidden" name="command" value="DELETE_NAME_CARD"/> 
		<input type="text" id="deleteName" name="idNameCard" value="" size="25" maxlength="25" required/> 		
		<label for="deleteName">Delete name card</label><br>
		<input type="submit" value="Delete" />
	</form>
	
	<c:out value="${sessionScope.deleteNameCard}"/>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_ADMIN_MAIN_ACCOUNT" /> 
		<input type="submit" value="Back" /><br>
	</form>

</body>
</html>