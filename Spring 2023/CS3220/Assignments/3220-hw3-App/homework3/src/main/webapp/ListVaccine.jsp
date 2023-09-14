<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Vaccine</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<br>
			<h1>Vaccine List</h1>
		<br> 
		
		

		<a href="NewVaccine" class="btn btn-primary">New Vaccine</a> 
		<a href="NewDose" class="btn btn-primary">New Doses</a>
		
		<br> <br>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Vaccine</th>
					<th>Doses Required</th>
					<th>Days Between Doses</th>
					<th>Total Doses Received</th>
					<th>Total Doses Left</th>
					<th>Edit</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="vaccine" items="${vaccines}">
					<tr>
						<td>${vaccine.vaccineName}</td>
						<td>${vaccine.doseRequired}</td>
						<td>${vaccine.daysBetweenDose}</td>
						<td>${vaccine.totalDoseReceived}</td>
						<td>${vaccine.totalDoseLeft}</td>
						<td><a href="EditVaccine?id=${vaccine.vaccineId}">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>