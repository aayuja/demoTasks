<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<title>Registration Form</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-7 offset-md-2">

				<form id="userForm" action="user" method="post">
					<h2>
						<center>Registration Form</center>
					</h2>

					<div class="form-row mt-5 ">
						<div class="form-group col-md-6">
							<label>First Name</label> <input type="text" id="firstName"
								name="firstName" class="form-control" placeholder="First Name">
						</div>
						<div class="form-group col-md-6">
							<label>last_name</label> <input type="text" id="lastName"
								name="lastName" class="form-control" placeholder="Last Name">
						</div>
					</div>
					<!-- Email input -->
					<div class="form-group">
						<label for="inputAddress">Email Address</label> <input
							type="email" id="form3Example3" class="form-control" name="email"
							placeholder="Email Address" />
					</div>
					<!-- Pass input -->
					<div class="form-group">
						<label for="inputAddress">Password</label> <input type="password"
							id="form3Example3" class="form-control" name="password"
							placeholder="Enter your password " />
					</div>
					<div class="form-group">
						<label for="inputAddress">address</label> <input type="text"
							id="address" class="form-control" name="address"
							placeholder="Address">
					</div>
					<div class="form-row mt-4 ">

						<div class="form-group col-md-6">
							<label for="inputState">contact_number</label> <input
								type="number" id="contactNumber" name="contactNumber"
								placeholder="Contact Number" class="form-control">
						</div>

						<div class="form-group col-md-6">
							<label for="inputState">gender</label> <select name="gender"
								id="gender" class="form-control">
								<option selected>Choose...</option>
								<option>Male</option>
								<option>Female</option>
							</select>
						</div>
					</div>
					<div class="form-row mt-4">
						<div class="form-group col-md-6">
							<label for="inputCity">city</label> <input type="text" id="city"
								name="city" class="form-control" id="inputCity"></input>
						</div>
						<div class="form-group col-md-4">
							<label for="inputState">state</label> <input type="text"
								id="state" name="state" class="form-control" id="inputCity"></input>
						</div>
						<div class="form-group col-md-2">
							<label for="inputZip">pin_code</label> <input type="number"
								id="pinCode" name="pinCode" class="form-control" id="inputZip"></input>
						</div>
					</div>

					<button type="submit" class="btn btn-primary">Next</button>
				</form>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$("#userForm").sumbit(function() {
				$.ajax({
					url : "/user",
					type : "POST"
				/* success : function(responseData) {
					$("#ajaxResponse").text(responseData);
				},
				error : function() {
					alert("Error while processing AJAX request");
				} */
				});
			});
		});
	</script>
</body>

</html>
