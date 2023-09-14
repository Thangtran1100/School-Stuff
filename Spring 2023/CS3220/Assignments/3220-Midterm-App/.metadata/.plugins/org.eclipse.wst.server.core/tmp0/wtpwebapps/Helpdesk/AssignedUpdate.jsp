<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Update Request Status</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<br> <br>
		<form action="AssignedUpdate" method="post">
			<input type="hidden" name="requestId"
				value="${selectedHelpdeskEntry.requestId}"> <input
				type="hidden" name="customerName"
				value="${selectedHelpdeskEntry.customerName}">

			<p>Computers Service requested by
				${selectedHelpdeskEntry.customerName} at
				${selectedHelpdeskEntry.requestTime}</p>
			<br>
			<br>

			<p>Status: Assigned to ${selectedHelpdeskEntry.assignedEmployeeName}</p>
			<br>
			<br>

			<p>Reason:</p>
			<br>

			<p>${selectedHelpdeskEntry.reason}</p>
			<br>
			<br>

			<p>
				Change the status to Completed?
				<input type="submit" name="status" value="Yes" /> Yes
				<input type="submit" name="status" value="No" /> No
				<input type="submit" name="status" value="Cancelled" /> Cancelled
			</p>



		</form>
	</div>

</body>
</html>
