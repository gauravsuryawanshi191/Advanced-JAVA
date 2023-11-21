<%@page import="pojo.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation Page</title>
</head>
<%!//JSP declaration block to add variables and methods(implicitscope: private)
	HashMap<String, User> userMap;

	//overside jspInit
	public void jspInit() {
		System.out.println("in init" + Thread.currentThread());
		userMap = new HashMap<>();
		userMap.put("Gaurav Surya", new User("Gaurav Surya", "12345", 22));
		userMap.put("Vinayak", new User("Vinayak", "54321", 22));
	}%>
<body>
	<%
	System.out.println("in scriptlet" + Thread.currentThread());
	//read param
	String name = request.getParameter("name");
	String pass = request.getParameter("pass");
	User user = userMap.get(name);
	if (user != null) {
		if (pass.equals(user.getPassword())) {
			session.setAttribute("currentUser", user);
			response.sendRedirect("details.jsp");
		} else
			response.sendRedirect("temp.jsp");
	} else
		response.sendRedirect("temp.jsp");
	%>
</body>
<%!public void jspDestroy() {
		System.out.println("in destroy" + Thread.currentThread());
	}%>
</html>