<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>Employees Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>




</head>
<body>
	

	<div style="float:right;margin-right:250px">
	<jsp:include page="header.jsp" />
	<br>
	<br>
	<br>
	<br>
	<form action="/employeeManagement/addEmployee" method="GET">
	<input type="submit" name="Upload Employee Details" value="Upload Employee Details">
	</form>
	</div>
	<div class="container">
		
		<br>
		<br>
		<h2>Employees Details</h2>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>Employee Code</th>
					<th>Employee Name</th>
					<th>Location</th>
					<th>Email</th>
					<th>Date Of Birth</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employees" items="${employees }">
					<tr>
						<td>${employees.code }</td>
						<td>${employees.name }</td>
						<td>${employees.location }</td>
						<td>${employees.emailId }</td>
						<td>${employees.dobInString }</td>
						<td>
							<form action="/employeeManagement/editEmployee" method="GET">
								<input type="hidden" name="code" value="${employees.code }" />
								<input type="submit" name="edit" value="edit">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>