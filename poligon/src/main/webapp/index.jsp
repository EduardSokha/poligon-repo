<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Main page</title>


<!-- ------------------------------------------------------------------ -->
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>
<fmt:message bundle="${loc}" key="local.message" var="message"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>

<fmt:message bundle="${loc}" key="local.locbutton.sign_in" var="sign_in"/>
<fmt:message bundle="${loc}" key="local.locbutton.authorization.login" var="login"/>
<fmt:message bundle="${loc}" key="local.locbutton.authorization.password" var="password"/>


<fmt:message bundle="${loc}" key="local.locbutton.registration" var="registration"/>
<fmt:message bundle="${loc}" key="local.locbutton.forget_password" var="forget_password"/>
<!------------------------------------------------------------------ -->


<style type="text/css">
input {
width: 150px;
}
</style>

</head>

<!-- ----------------------------------------------------------------- -->

<body>

<!-- ----------------------------------------------------------------- -->

<!--<form action="controller" method="post">

<select name="command" value="localization" id="listt">
                    <option name="local" value="ru">"${ru_button}"</option>
                    <option name="local" value="en" selected>"${en_button}"</option>
                </select>
                <input type="hidden" name="page" value="indexPage" /> 
</form>   --> 
                

<form action="controller" method="post">

<input type="hidden" name="command" value="localization" /> 
<input type="hidden" name="local" value="ru" /> 
<input type="hidden" name="page" value="indexPage" /> 
<input type="submit" value="${ru_button}" /><br>

</form>

<form action="controller" method="post">

<input type="hidden" name="command" value="localization" /> 
<input type="hidden" name="local" value="en" /> 
<input type="hidden" name="page" value="indexPage" /> 
<input type="submit" value="${en_button}" /><br>

</form>

<c:out value="${message}"/>


<!-- ----------------------------------------------------------------- -->


	<form action="controller" method="post">
		<input type="hidden" name="command" value="authorization" /> 		
		<input type="text" id="log"  name="login" value="" size="25" maxlength="25"  />
		<label for="log">${login}</label><br>
		<input type="password" id="passw" name="pass" value="" size="25" maxlength="25" /> 
		<label for="passw">${password}</label><br>	
		<input type="submit" value="${sign_in}" /><br>
	</form>
	
	<h1><%= request.getAttribute("noSuchUser")%></h1>
	<h1><%= request.getAttribute("user")%></h1>
	<a href="registration_user">Registration</a>
	
	<form action="controller" method="post">
		<input type="hidden" name="command" value="GO_TO_REGISTRATION" /> 		
		<input type="submit" value="${registration}" /><br>
	</form>
	
	<br>
	<c:out value="${sessionScope.user}"/>
	
	<!-- <c:if test="${requestScope.resp eq 'Your account was not found. You need to register.' }" >

	<c:out value="Your account was not found. You need to register."/>

	</c:if>-->
	
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_FORGET_PASSWORD" /> 		
		<input type="submit" value="${forget_password}" /><br>
	</form>


</body>
</html>