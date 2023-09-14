<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Polls</title>
</head>
<body>
<p><a href="CreatePoll">Create Poll</a></p>

<table border = "1">

<c:forEach items="${polls}" var="poll">
<tr>
	<td><a href="DisplayPoll?id=${poll.id}">${poll.question }</a></td>
	<td><a href="AddAnswer?id=${poll.id}">Add Answers</a></td>
</tr>
</c:forEach>



</table>

</body>
</html>