<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Data base all cards</title>

	<style type="text/css">
		input {
		width: 150px;
		}
	</style>

</head>

<!-- ----------------------------------------------------- -->

<body>

	<c:forEach var="card" items="${requestScope.getCards}">
		<c:out value="${card.idCard}"/>
		<c:out value="${card.creationDate}"/>
		<c:out value="${card.status}"/>
		<c:out value="${card.idAccount}"/>
		<c:out value="${card.typePaymSystCard}"/>
		<c:out value="${card.nameCard}"/>
		<br>
	</c:forEach>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_ADMIN_MAIN_ACCOUNT"/> 
		<input type="submit" value="Back"/><br>
	</form>

</body>
</html>