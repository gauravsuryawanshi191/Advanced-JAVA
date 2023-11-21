<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admission Form</title>
</head>
<body>
	<form action="validation.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="fname" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="lname" /></td>
			</tr>
			<tr>
				<td>Enter Test Score</td>
				<td><input type="text" name="marks" /></td>
			</tr>
			<tr>
				<td>Select Course</td>
				<td><select name="course" id="course">
						<option value="DAC">DAC</option>
						<option value="DBDA">DBDA</option>
						<option value="DIOT">DIOT</option>
						<option value="DAI">DAI</option>
				</select></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>