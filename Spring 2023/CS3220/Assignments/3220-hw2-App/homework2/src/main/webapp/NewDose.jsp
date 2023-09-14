<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>New Dose</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">

		<h2>New Dose</h2>

		<form action="NewDose" method="post">



			<div class="form-group row">
				<label for="dose"
					class="col-lg-4 font-weight-bold col-form-label control-label">Vaccine</label>

				<div class="col-lg-8">
					<select class="form-control" id="dose" name="dose">
						<c:forEach items="${entries}" var="entry">
							<option value="${entry.vaccineName}">${entry.vaccineName}</option>
						</c:forEach>
					</select>
				</div>

			</div>

			<div class="form-group row">
				<label for="newDose"
					class="col-lg-4 font-weight-bold col-form-label control-label">New
					Doses Received</label>

				<div class="col-lg-8">
					<input type="text" class="form-control" id="newDose" name="newDose">
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Add</button>
		</form>
	</div>
</body>
</html>