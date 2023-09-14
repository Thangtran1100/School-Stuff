
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create Poll</title>
</head>
<body>
	<h1>Create Poll</h1>
	<form action="CreatePoll" method="post">
		<label for="question">Question:</label>
		<input type="text" id="question" name="question"><br>
		<label for="single-choice">Single-Choice</label>
		<input type="checkbox" id="single-choice" name="choice"><br>
		<input type="submit" value="Create">
	</form>
</body>
</html>
