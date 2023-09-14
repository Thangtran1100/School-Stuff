<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Answer</title>
</head>
<body>

<p>${poll.question }</p>
<c:forEach items="${poll.answers}" var="answer">

<div>
	
	${answer}


</div>

</c:forEach>

<form action="AddAnswer" method="post">
	<input type="text" name="answer"> <button>Add</button>

</form>


<a href="DisplayPoll">Display Poll</a>
</body>
</html>