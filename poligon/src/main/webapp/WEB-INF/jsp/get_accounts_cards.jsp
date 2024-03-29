<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>List accounts and cards user</title>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>

</head>

<!-- ----------------------------------------------------- -->

<body>

	<h1>Get accounts</h1>
	
	<c:forEach var="name" items="${requestScope.getAccountsAndCards}">
		<c:out value="${name.idAccount}"/>
		<c:out value="${name.balance}"/>
		<c:out value="${name.statusAccount}"/>
		<c:out value="${name.creationDateAccount}"/>
		<c:out value="${name.currency}"/>
		<c:out value="${name.idCard}"/>
		<c:out value="${name.typePaySyst}"/>
		<c:out value="${name.nameCard}"/>
		<br>
	</c:forEach>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_MAIN_ACCOUNT" /> 
		<input type="submit" value="Back" /><br>
	</form>

</body>
</html>