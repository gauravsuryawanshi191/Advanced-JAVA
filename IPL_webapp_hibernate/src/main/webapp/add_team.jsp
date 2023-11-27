<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="team" class="beans.TeamBean" scope="session" />
<jsp:useBean id="player" class="beans.PlayerBean" scope="session" />
<body>
	<form action="process_form.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Select Team</td>
				<td><select name="myTeam">

						<option value="default" selected disabled>--select a
							team--</option>
						<option value="MI">MI</option>
						<option value="CSK">CSK</option>
						<option value="RCB">RCB</option>
						<option value="GT">GT</option>
						<option value="RR">RR</option>
						<option value="KKR">KKR</option>
						<option value="DC">DC</option>
						<option value="PK">PK</option>
						<option value="LSG">LSG</option>
				</select></td>
			</tr>
			<!-- <tr>
				<td>Other that options above:</td>
				<td><input type="text" name="myTeam" /></td>
			</tr> -->
			<tr>
				<td>Add Team</td>
				<td><input type="text" name="teamName" /></td>
			</tr>

			<tr>
				<td>Enter max age: </td>
				<td><input type="date" name="age" /></td>
			</tr>
			<tr>
				<td>Enter Batting Average</td>
				<td><input type="number" value="0.00" step="0.01" name="avg" /></td>
			</tr>
			<tr>
				<td>Enter No Of Wickets Taken</td>
				<td><input type="number" name="wickets" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add A Player" /></td>
			</tr>
		</table>
	</form>
</body>


</html>