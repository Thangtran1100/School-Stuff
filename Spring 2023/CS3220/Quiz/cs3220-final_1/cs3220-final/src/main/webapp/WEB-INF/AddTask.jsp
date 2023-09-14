<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Task...</title>
<style>
	td, th {
		border-style: double;
		padding: 5pt;
	}
</style>
</head>
<body>
	<form action="AddTask" method="post">
		<table border='1'>
			<tr>
				<th><label>Task:</label></th>
				<td><input type='text' name="task"></input></td>
			</tr>
			<tr>
				<th><label>Details:</label></th>
				<td><input type='text' name="detail"></input></td>
			</tr>
			<tr>
				<td colspan=2><button type="submit">Add</button></td>
			</tr>
		</table>
	</form>
</body>
</html>