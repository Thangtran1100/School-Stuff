<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Request Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<div class="container">

		<br> <br>

		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Request Time</th>
					<th>Scheduled For</th>
					<th>Department</th>
					<th>Status</th>
					<th>Assigned To</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="entry" items="${entries}">
					<tr>
						<td>${entry.requestTime}</td>
						<td>${entry.customerName}</td>
						<td>${entry.departmentName}</td>
						<td>${entry.requestStatus}</td>
						<td>${entry.assignedEmployeeName}</td>


						<c:choose>

							<c:when test="${entry.getRequestStatus() eq 'Completed'}">
								<td></td>
							</c:when>
							
							<c:when test="${entry.getRequestStatus() eq 'Cancelled'}">
								<td></td>
							</c:when>

							<c:when test="${entry.getRequestStatus() eq 'Created'}">
										<td>
									<a href="CreatedUpdate?requestId=${entry.requestId}">Update</a>
								</td>
									</c:when>
									
									<c:when test="${entry.getRequestStatus() eq 'Assinged'}">
										<td>
									<a href="AssingedUpdate?requestId=${entry.requestId}">Update</a>
								</td>
									</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<br>
		<a href="CreateRequest" class="btn btn-primary">Create Service
			Request</a>

	</div>

</body>
</html>