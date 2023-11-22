<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation Page</title>
</head>
<%--create JB instance n add it under session --%>
<jsp:useBean id="user" class="beans.UserBean" scope="session" />
<%--transfer clnt's conversation state to JB --%>
<jsp:setProperty property="*" name="user" />
<%--Invoke B.L from JB --%>
<h4>Route : ${sessionScope.user.validateUser()}</h4>
<body>

</body>
</html>