<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="controller" method="post">
		<input type="hidden" name="command" value="delete_user" />
		<input type="text" name="name" value="Roma" /><br>
		<input type="text" name="surname" value="Nilikovskiy" /><br>
		<input type="submit" value="Sign in" /><br />
	</form>

</body>
</html>