<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Forget password</title>


<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>
<fmt:message bundle="${loc}" key="local.message" var="message"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>

<fmt:message bundle="${loc}" key="local.registration.identific_numb_passport" var="identific_numb_passport"/>
<fmt:message bundle="${loc}" key="local.registration.series_numb_passport" var="series_numb_passport"/>
<fmt:message bundle="${loc}" key="local.registration.codeword" var="codeword"/>

<fmt:message bundle="${loc}" key="local.locbutton.get_passw" var="get_passw"/>
<fmt:message bundle="${loc}" key="local.locbutton.back" var="back"/>


<style type="text/css">
input {
width: 150px;
}
</style>

</head>

<!-- ----------------------------------------------------- -->

<body>

<form action="controller" method="post">
<input type="hidden" name="command" value="localization" /> 
<input type="hidden" name="local" value="ru" />
<input type="hidden" name="page" value="forgetPasswPage" />  
<input type="submit" value="${ru_button}"/><br>
</form>

<form action="controller" method="post">

<input type="hidden" name="command" value="localization" /> 
<input type="hidden" name="local" value="en" /> 
<input type="hidden" name="page" value="forgetPasswPage" />   
<input type="submit" value="${en_button}" /><br>

</form>

<c:out value="${message}"/>


<!-- ----------------------------------------------------- -->


<!--<c:out value="${requestScope.resp}"/>

<c:out value="${sessionScope.resp1}"/>
<c:out value="${requestScope.resp}"/>-->

<form action="controller" method="post">
		<input type="hidden" name="command" value="FORGET_PASSWORD"/>
		<input type="text" id="identificNumberPassport" name="identificNumberPassport" value="" size="25" maxlength="25"/> 
		<label for="identificNumberPassport">${identific_numb_passport}</label><br>
		<input type="text" id="seriesNumberPassport" name="seriesNumberPassport" value="" size="25" maxlength="25"/>
		<label for="seriesNumberPassport">${series_numb_passport}</label><br>
		<input type="text" id="codeword" name="codeword" value="" size="25" maxlength="25"/>		
		<label for="codeword">${codeword}</label><br>
		<input type="submit" value="${get_passw}" />
</form>

<c:out value="${sessionScope.forgetPassword}"/>


<form action="controller" method="get">
	<input type="hidden" name="command" value="GO_TO_MAIN_LOC"/> 
	<input type="submit" value="${back}"/><br>
</form>

</body>
</html>