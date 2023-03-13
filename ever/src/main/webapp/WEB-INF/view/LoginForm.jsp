<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%@include file="./base.jsp"%>
<title>Ground</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<!-- Section: Design Block -->
	<section class="text-center text-lg-start">
		<style>
.cascading-right {
	margin-right: -50px;
}

@media ( max-width : 991.98px) {
	.cascading-right {
		margin-right: 0;
	}
}
</style>

		<!-- Jumbotron -->
		<div class="container py-4">
			<div class="row g-0 align-items-center">
				<div class="col-lg-6 mb-5 mb-lg-0">
					<div class="card cascading-right"
						style="background: hsla(0, 0%, 100%, 0.55); backdrop-filter: blur(30px);">
						<div class="card-body p-5 shadow-5 text-center">
							<h2 class="fw-bold mb-5">Login now</h2>
							<form id="userLogin" action="userLogin" method="POST">
								<!-- 2 column grid layout with text inputs for the first and last names -->


								<!-- Email input -->
								<div>
									<label class="form-label" for="email">Email address</label> <input
										type="email" id="email" name="email" class="form-control" />
								</div>

								<!-- Password input -->
								<div class="form-outline mb-4">
									<label class="form-label" for="password">Password</label> <input
										type="password" name="password" id="password"
										class="form-control" />

								</div>

								<!-- Submit button -->
								<button type="submit" class="btn btn-primary btn-block mb-4">
									Login</button>

							</form>
							<!-- Register buttons -->
							<div class="text-center">
								<a href="/openUserForm">Create Account</a>
								<p>or Login with:</p>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-facebook-f"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-google"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-twitter"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-github"></i>
								</button>
							</div>

						</div>
					</div>
				</div>

				<div class="col-lg-6 mb-5 mb-lg-0">
					<img
						src="https://mdbootstrap.com/img/new/ecommerce/vertical/004.jpg"
						class="w-100 rounded-4 shadow-4" alt="" />
				</div>
			</div>
		</div>
		<!-- Jumbotron -->
	</section>

	<!-- Section: Design Block -->
	<script>
		$(document).ready(function() {
			$("#userLogin").sumbit(function() {
				$.ajax({
					url : "/userLogin",
					type : "POST"
				 /* success : function() {
				    window.location.href = "http://localhost:8081/gro";

				},
				error : function() {
					 window.location.href = "http://localhost:8081/openLoginForm";
				} 
				}); */
			});
		});
	</script>
	
</body>

</html>