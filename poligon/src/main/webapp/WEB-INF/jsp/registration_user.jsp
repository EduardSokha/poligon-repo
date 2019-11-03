<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">

<title>Registration user</title>

	<fmt:setLocale value="${sessionScope.local}"/>
	<fmt:setBundle basename="localization.local" var="loc"/>
	<fmt:message bundle="${loc}" key="local.message" var="message"/>
	<fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_button"/>
	<fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_button"/>
	
	<fmt:message bundle="${loc}" key="local.registration.login" var="login"/>
	<fmt:message bundle="${loc}" key="local.registration.passw" var="passw"/>
	<fmt:message bundle="${loc}" key="local.registration.user_name" var="user_name"/>
	<fmt:message bundle="${loc}" key="local.registration.user_surname" var="user_surname"/>
	<fmt:message bundle="${loc}" key="local.registration.address" var="address"/>
	<fmt:message bundle="${loc}" key="local.registration.series_numb_passport" var="series_numb_passport"/>
	<fmt:message bundle="${loc}" key="local.registration.identific_numb_passport" var="identific_numb_passport"/>
	<fmt:message bundle="${loc}" key="local.registration.codeword" var="codeword"/>
	<fmt:message bundle="${loc}" key="local.registration.phone_number" var="phone_number"/>
	<fmt:message bundle="${loc}" key="local.registration.residence_registr" var="residence_registr"/>
	
	<fmt:message bundle="${loc}" key="local.locbutton.send" var="send"/>
	<fmt:message bundle="${loc}" key="local.locbutton.back" var="back"/>



	<style type="text/css">
		input {
		width: 200px;
		}
	</style>

</head>

<!-- ----------------------------------------------------- -->

<body>
<h1>Hello visitor</h1>


	<form action="controller" method="post">
	
	<input type="hidden" name="command" value="localization" /> 
	<input type="hidden" name="local" value="ru" />
	<input type="hidden" name="page" value="registrPage" />  
	<input type="submit" value="${ru_button}" /><br>
	
	</form>
	
	<form action="controller" method="post">
	
	<input type="hidden" name="command" value="localization" /> 
	<input type="hidden" name="local" value="en" /> 
	<input type="hidden" name="page" value="registrPage" />   
	<input type="submit" value="${en_button}" /><br>
	
	</form>
	
	<c:out value="${message}"/>


<!-- ----------------------------------------------------- -->


	<form action="controller" method="post">
		<input type="hidden" name="command" value="registration"/> 
		
		<input type="text" id="log" name="login" value="Nilik" size="25" maxlength="25" required/>
		<label for="log">${login}</label><br>
		<input type="password" id="passw"  name="pass" value="" size="25" maxlength="25" required/> 
		<label for="passw">${passw}</label><br>	
		<input type="text" id="userName" name="name" value="Roma" size="25" maxlength="25" required/>
		<label for="userName">${user_name}</label><br>	
		<input type="text" id="userSurname" name="surname" value="Nilikovskiy" size="25" maxlength="25" required/>
		<label for="userSurname">${user_surname}</label><br>	
		<input type="text" id="addressUser" name="address" value="Dolgobrodskaya 2, flat 20" size="25" maxlength="25" required/>
		<label for="addressUser">${address}</label><br>
		<input type="text" id="seriesNumbPassp" name="seriesNumberPassport" value="BB26898" size="25" maxlength="25" required/>
		<label for="seriesNumbPassp">${series_numb_passport}</label><br>
		<input type="text" id="identifNumbPassp" name="identificNumberPassport" value="46646v66" size="25" maxlength="25" required/>
		<label for="identifNumbPassp">${identific_numb_passport}</label><br>
		<input type="text" id="Codeword_user" name="codeWord" value="коваль" size="25" maxlength="25" required/>
		<label for="Codeword_user">${codeword}</label><br>
		<input type="text" id="phoneNumb" name="phoneNumber" value="+37293697841" size="25" maxlength="25" required/>
		<label for="phoneNumb">${phone_number}</label><br>
		<input type="text" id="residenceRegistration" name="residenceRegistr" value="Dolgobrodskaya 2, flat 20" size="25" maxlength="25" required/>
		<label for="residenceRegistration">${residence_registr}</label><br>
		
		<input type="submit" value="${send}"/><br />
	</form>

	<!--  <h1><%=request.getAttribute("registrationUser")%></h1>
	<h1><%=session.getAttribute("registrationUser")%></h1>-->
	<c:out value="${sessionScope.registrationUser}"/>
	
	<form action="controller" method="get">
		<input type="hidden" name="command" value="GO_TO_MAIN_LOC" /> 
		<input type="submit" value="${back}"/><br>
	</form>

</body>
</html>