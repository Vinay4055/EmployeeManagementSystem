<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form class="form-horizontal" method="POST"
			action="/employeeManagement/editEmployee" modelAttribute="updatedEmployee">
			<div class="form-group">
				<label class="control-label col-sm-2">Employee Code</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" 
						value="${employee.code }" readonly="readonly" path="code" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Employee Name:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" 
						value="${employee.name }" path="name"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Location:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" 
						value="${employee.location }" path="location"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Email:</label>
				<div class="col-sm-10">
					<form:input type="text" class="form-control" 
						value="${employee.emailId }" path="emailId"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Date of Birth:</label>
				<div class="col-sm-10">
					<form:input type="date" id="dob" class="form-control" 
						value="${employee.dobInString }" path="dobInString"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>