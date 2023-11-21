<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Page</title>
</head>
<body>
<h4>Thank you ${sessionScope.currentUser.userName }</h4>
	<h4>
		<a href="login.jsp">Visit Again</a>
	</h4>
</body>
</html>