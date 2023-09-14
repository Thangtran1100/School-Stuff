<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Vaccine</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>New Vaccine</h1>
		
		
		<form action="NewVaccine" method="post">

			<div class="form-group row">
				<label for="name"
					class="col-lg-4 font-weight-bold col-form-label control-label">Name</label>
				<div class="col-lg-8">
					<input type="text" name="name" class="form-control" id="name">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="dose"
					class="col-lg-4 font-weight-bold col-form-label control-label">Doses Required</label>
				<div class="col-lg-8">
					<select name="dose" class="form-control" id="dose">
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
				</select>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="dose"
					class="col-lg-4 font-weight-bold col-form-label control-label">Days Between Doses</label>
				<div class="col-lg-8">
					<input type="text" name="days" class="form-control" id="days">
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Add</button>
		</form>
	</div>
</body>
</html>