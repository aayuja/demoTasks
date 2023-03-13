<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<title>Registration Form</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-7 offset-md-2">

				<form  action="storePass" method="post">
					<h2>
						<center>Set Up Your Password</center>
					</h2>

					<div class="form-row mt-5 ">
						<div class="form-group col-md-6">
							<label>PassWord</label> <input onclick="demo()" type="password" id="password"
								name="password" class="form-control" placeholder="password"  >
						</div>
						<div class="form-group col-md-6">
							<label>Conform PassWord</label> <input type="password" id="ConPass"
								name="ConPass" class="form-control" placeholder="Conform your Password" onmouseout="demo()">
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function demo(){
	var x = document.getElementById("password").value;
	var y = document.getElementById("ConPass").value;
	if(x != y){
		alert("Password is not same");
		document.getElementById('ConPass').value = '';
		
	}
	
}

</script>
</html>

