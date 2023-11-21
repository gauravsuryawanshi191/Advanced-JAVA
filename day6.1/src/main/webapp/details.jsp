<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
<h3>User Details:</h3>
<h4>Name: ${sessionScope.currentUser.userName}</h4>
<h4>Age: ${sessionScope.currentUser.age}</h4>
<h4><a href="logout.jsp">Logout</a></h4>
</body>
</html>