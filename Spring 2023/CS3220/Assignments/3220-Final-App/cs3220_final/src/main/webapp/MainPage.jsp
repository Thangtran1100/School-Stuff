<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
</head>
<body>


	<div class="container mt-5">
		<h2>Please select a user:</h2>

		<form action="AddPatient" method="post">



			<div class="form-group row">
				<select class="form-control"
					id="user" name="userId">
					<c:forEach items="${users}" var="user">
						<option value="${user.getId()}">${user.name}</option>
					</c:forEach>
				</select>
				<a href="DisplayReading" class="btn btn-primary">Select</a>
			</div>


		</form>
	</div>
</body>
</html>