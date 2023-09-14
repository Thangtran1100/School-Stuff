<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Task</title>
</head>
<body>
	<a href=" ">TASK MANAGEMENT</a> - ADD Task
	<table border=1>
		<form action="addtask" method="post">
			<tr>
				<td>Task : </td>
				<td><input type="text" name = "task"></input></td>
			</tr>
			<tr>
				<td>Details : </td>
				<td><input type="text" name="detail"></input></td>
			</tr>
			<tr>
				<td colspan = 2><input type="submit" name="add" value="Add" /></td>
			</tr>
		</form>
	</table>
</body>
</html>