<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding a player</title>
</head>
<body>
<h3> Welcome 2 Web App with Hibernate @ <%= new Date() %></h3>
<jsp:setProperty property="*" name="player"/>
<!--<jsp:setProperty property="*" name="team"/> -->
<h3>Status : ${sessionScope.player.addNewPlayer()}</h3>
</body>
</html>