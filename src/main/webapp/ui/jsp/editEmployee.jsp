<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Edit Employee Details</h2>
		<form class="form-horizontal" method="POST"
			action="/employeeManagement/editEmployee">
			<div class="form-group">
				<label class="control-label col-sm-2">Employee Code</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="code"
						value="${employee.code }" readonly="readonly"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Employee Name:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="name"
						value="${employee.name }" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Location:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="location"
						value="${employee.location }" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Email:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="emailId"
						value="${employee.emailId }" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Date of Birth:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="dobInString"
						value="${employee.dobInString }" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>