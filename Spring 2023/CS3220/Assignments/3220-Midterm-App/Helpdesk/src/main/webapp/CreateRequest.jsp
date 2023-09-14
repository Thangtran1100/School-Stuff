<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Form</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<br><br>
		
		<form action="CreateRequest" method="post">

			<div class="form-group row">
				<label for="customerName" class="col-form-label control-label">Your Name:</label>
				<div >
					<input type="text" name="customerName" class="form-control" id="customerName">
				</div>
			</div>
			
			<div class="form-group row">
				<label for="departmentName"
					class="col-form-label control-label">Department:</label>
				<div>
					<select name="departmentName" class="form-control" id="departmentName">
					<option value="Computers">Computers</option>
					<option value="Video Games">Video Games</option>
					<option value="Appliances">Appliances</option>
					<option value="Movies">Movies</option>
				</select>
				</div>
			</div>
			
			<div class="form-group row">
				<label for="reason" class="col-form-label control-label">Reason:</label>
				<div >
					<input type="text" name="reason" class="form-control" id="reason">
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Create</button>
		</form>
	</div>
</body>
</html>
