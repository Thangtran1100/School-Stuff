<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Task Manager</title>
	<style>
		td, th {
			border-style: double;
			padding: 5pt;
		}
	</style>
</head>
<body>
	<h2>Task Management</h2>
	<p>
		<a href='AddTask'>New Task</a>
	</p>
	<form action="AddTask" method="post">
		<table border='1'>
			<tr>
				<th>Task</th>
				<th>Details</th>
				<th>Status</th>
				<th>Assigned To</th>
				<th></th>
			</tr>
			<c:forEach items="${taskEntries}" var="task">
				<tr>
					<td>${task.getTask()}</td>
					<td>${task.getDetail()}</td>
					<td>${task.getStatus()}</td>
					<td>
					<c:forEach items="${userEntries}" var="user">
						<c:if test="${user.getId() == (task.getUserId())}">
							${user.getName()}
						</c:if>
					</c:forEach>
						<c:if test="${task.getUserId() == 0}">
							<select name='id'>
								<c:forEach items="${userEntries}" var="user">
									<option value='${user.getId()}'>${user.getName()}</option>
								</c:forEach>
							</select>
						</c:if>
					</td>
					
					<c:if test="${task.getUserId() == 0}">
						<td><a href=${"AssignUser?id="}${task.getId()}>Assign</a></td>
					</c:if>
					<c:if test="${task.getUserId() > 0}">
						<td><a href=${"CompleteTask?id="}${task.getId()}>Complete</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</form>	
</body>
</html>