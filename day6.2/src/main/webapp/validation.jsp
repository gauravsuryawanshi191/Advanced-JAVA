<%@page import="pojo.Student"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation</title>
</head>
<%!//enum
	enum Course {
		DAC(90), DBDA(85), DIOT(80), DAI(75);

		private int marks;

		public int getMarks() {
			return this.marks;
		}

		private Course(int marks) {
			this.marks = marks;
		}
	}

	//JSP declaration block
	HashMap<String, Student> studentMap;

	public Student addstudent(String fname, String lName, int marks, String selectedCourse) {
		if (marks > Course.valueOf(selectedCourse).getMarks()) {
			Student currentStudent = new Student(fname, lName, marks, selectedCourse);
			studentMap.put("fname", currentStudent);
			return currentStudent;
		}
		return null;
	}%>
<body>
	<%
	String fname = request.getParameter("fname");
	String lastname = request.getParameter("lname");
	int marks = Integer.parseInt(request.getParameter("marks"));
	String selectedCoure = request.getParameter("course");
	Student student = addstudent(fname, lastname, marks, selectedCoure);
	session.setAttribute("currentStudent", student);
	response.sendRedirect("result.jsp");
	%>
</body>
</html>