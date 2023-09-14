<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
<a href = "addtask">Add Task</a>

<table border = 1>
	<tr>
		<th>Task</th>
		<th>Details</th>
		<th>Status</th>
		<th>Assigned to</th>
		<th></th>
	</tr>
	
	<c:forEach items = "${entries}" var = "entries">
	<tr>
		<td>${entries.task}</td>
		<td>${entries.detail}</td>
		<td>${entries.stat}</td>
		
		<c:if test = "${'assign' == entries.tastodo}">
		<form action = "assigntodo" method="post">
			<td>
				<select name="assignto">
						<option value="john" >john</option>
						<option value = "jim">jim</option>
						<option value = "joe">joe</option>
			</select>
			</td>
			<td><input type ="hidden" name = "id" value = "${entries.id}"></input>   
			<input type="submit" name="assign" value = "assign"> </form>
			</td>
		</c:if>
		
		<c:if test = "${'complete' == entries.tastodo}"> 
		<td>${entries.assignto}</td>
		<td><form action = "complete" method="post"><input type ="hidden" name = "cid" value = "${entries.id}"></input>   
			<input type="submit" name="complete" value = "complete"> </form>
			</td>
		
		 </c:if>
	</tr>
	</c:forEach>
</table>

</body>
</html>