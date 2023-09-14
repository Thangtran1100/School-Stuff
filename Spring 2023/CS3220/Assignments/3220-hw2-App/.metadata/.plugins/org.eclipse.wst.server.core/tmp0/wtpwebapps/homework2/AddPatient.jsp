<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Patient</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<h1>New Patient</h1>
		<form action="AddPatient" method="post">

			<div class="form-group row">
				<label for="patient">Patient Name</label> 
				<input type="text"
					class="form-control" name="patient" id="patient">
			</div>

			<div class="form-group row">
				<label for="vaccine">Vaccine</label> <select class="form-control"
					id="vaccine" name="vaccine">
					<c:forEach items="${entries}" var="entry">
						<c:if test="${entry.getTotalDoseLeft() > 0}">
							<option value="${entry.vaccineName}">${entry.vaccineName}</option>
						</c:if>


					</c:forEach>
				</select>
			</div>

			<button type="submit" class="btn btn-primary">Add</button>
		</form>
	</div>
</body>
</html>
