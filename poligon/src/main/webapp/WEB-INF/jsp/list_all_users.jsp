<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Data base all users</title>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>

</head>

<!-- ----------------------------------------------------- -->

<body>

	<c:forEach var="user" items="${requestScope.getUsers}">
		<c:out value="${user.id}"/>
		<c:out value="${user.login}"/>
		<c:out value="${user.name}"/>
		<c:out value="${user.surname}"/>
		<c:out value="${user.address}"/>
		<c:out value="${user.roleStr}"/>
		<c:out value="${user.seriesNumberPassport}"/>
		<c:out value="${user.identificNumberPassport}"/>
		<c:out value="${user.codeWord}"/>
		<c:out value="${user.phoneNumber}"/>
		<c:out value="${user.residenceRegistr}"/>	
		<br>
	</c:forEach>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_ADMIN_MAIN_ACCOUNT"/> 
		<input type="submit" value="Back"/><br>
	</form>

</body>
</html>