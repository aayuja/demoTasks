<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="ISO-8859-1">
<title>Submitted</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">

			<div class="col-md-10 offset-md--1">

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">id</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Contact</th>
							<th scope="col">Email</th>
							<th scope="col">Address</th>
							<th scope="col">Gender</th>
							<th scope="col">City</th>
							<th scope="col">State</th>
							<th scope="col">Pin Code</th>
							<th scope="col"></th>
							<th scope="col">Action</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<!-- </thead> -->
					<tbody>
						<c:forEach items="${data}" var="lis">
							<tr>
								<td>${lis.id}</td>
								<td>${lis.firstName}</td>
								<td>${lis.lastName}</td>
								<td>${lis.contactNumber}</td>
								<td>${lis.email}</td>
								<td>${lis.address}</td>
								<td>${lis.gender}</td>
								<td>${lis.city}</td>
								<td>${lis.state}</td>
								<td>${lis.pinCode}</td>
								<td><a href="delete/${lis.id}"><button>Delete</button></a>
								</td>
								<td><a href="update/${lis.id}"><button>Update</button></a>
								</td>
								<%-- <td><a href="downloadFile/${lis.image}">view</a></td> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>