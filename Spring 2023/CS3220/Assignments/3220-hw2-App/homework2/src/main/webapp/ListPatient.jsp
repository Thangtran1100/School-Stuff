<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>

	<div class="container mt-3">
		<h1>Patient List</h1>
		<br> <a href="AddPatient" class="btn btn-primary">New Patient</a>
		<br> <br>
		<div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						
						<th>ID</th>
						<th>Name</th>
						<th>Vaccine</th>
						
						<th>1st Dose</th>
						<th>2nd Dose</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patientEntries}" var="patient">
						<c:set var="vaccineEntry" value="${null}" />
						<c:forEach items="${entries}" var="entry">
							<c:if
								test="${ patient.getVaccineName() eq entry.getVaccineName() }">
								<c:set value="${entry}" var="vaccineEntry" />
							</c:if>
						</c:forEach>


						<tr>
							
							<td>${patient.getPatientId()}</td>
							<td>${patient.getPatientName()}</td>
							<td>${patient.getVaccineName()}</td>
							
							<td>${patient.getFirstDoseDate()}<c:choose>

								<c:when test="${vaccineEntry.getDoseRequired() == 1}">
									
									<c:choose>
									<c:when test="${vaccineEntry.getTotalDoseLeft() <= 0}">
													<td>Out of Stock</td>
									</c:when>
									<c:otherwise>
										<td>-</td>
									</c:otherwise>
									</c:choose>
								</c:when>


								<c:when test="${vaccineEntry.getDoseRequired() == 2}">
									<c:choose>
										<c:when test="${patient.checkSecondDose() == true}">
											<td>${patient.getSecondDoseDate()}</td>
										</c:when>



										<c:when test="${patient.checkSecondDose() == false}">
											<c:choose>
												<c:when test="${vaccineEntry.getTotalDoseLeft() <= 1}">
													<td>Out of Stock</td>
												</c:when>
												
												
												<c:when test="${vaccineEntry.getTotalDoseLeft() > 0}">
													<td>
														<form action="ListPatient" method="post">
															<input type=hidden name="patientId"
																	value="${patient.getPatientId()}" />
																<input type=hidden name="vaccineName"
																	value="${patient.getVaccineName() }" />
															<button type=submit class="btn btn-primary">Received</button>
														</form>
													</td>
												</c:when>
											</c:choose>

										</c:when>
									</c:choose>
								</c:when>





							</c:choose>
						
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>