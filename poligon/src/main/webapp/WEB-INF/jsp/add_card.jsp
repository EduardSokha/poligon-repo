<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add card</title>


	<style type="text/css">
		input {
		width: 200px;
		}
		select{
		width: 200px;
		}
	</style>

</head>

<body>

	<form action="controller" method="post">

		<input type="hidden" name="command" value="add_Card" />

 		<select name="currency" id="currenc">
                    <option value="1">USD</option>
                    <option value="2">BYN</option>
                    <option value="3">RUB</option>
        </select>
        <label for="currenc">Currency</label><br>
        
		<select name="paySystCard" id="paySyst">
                    <option value="1">VISA</option>
                    <option value="2">MASTERCARD</option>
                    <option value="3">BELCARD</option>
        </select>
        <label for="paySyst">Payment system</label><br>
        
		<select name="nameCard" id="nameCards">
                    <option value="1">GOLD</option>
                    <option value="2">PRIME</option>
                    <option value="3">GUIDE</option>
                    <option value="4">HOTPOTATO</option>
        </select>
        <label for="nameCards">Name card</label><br>
		
		<input type="submit" value="Create new card"/>
		
		<!--  <input type="text" id="log" name="login" value="Dmitr" size="25" maxlength="25" required/>
		<label for="log">Login</label><br>
		<input type="password" id="passw" name="password" value="111" size="25" maxlength="25" required/>
		<label for="passw">Password</label><br>		
		<input type="submit" value="Sign in" /><br> -->
	</form>
	
	<!--  <h1><%= request.getAttribute("addCard")%></h1>-->
	<c:out value="${sessionScope.addCard}"/>
	
	<form action="controller" method="get">	
		<input type="hidden" name="command" value="GO_TO_MAIN_ACCOUNT" /> 
		<input type="submit" value="Back" /><br>	
	</form>
	

</body>
</html>