<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Attractions</title>
</head>
<body>
<h2>Attractions</h2>
<a href="AddAttraction">Add an Attraction</a>
<table border="1">
<tr>
<td><b>Name</b></td>
<td><b>Phone Number</b></td>
</tr>
<c:forEach items="${attraction}" var="attraction">
    <tr>
        <td>${attraction.name}</td>
        <td>${attraction.number}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>