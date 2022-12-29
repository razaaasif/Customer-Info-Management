<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>CIMS</title>
</head>
<body>
	<div class="center">
		<div id="wrapper">
			<div id="header">
				<h2>Customer Information Management System - CIMS</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
				<div class="outer-wrapper">

					<div class="table-wrapper">
						<table>

							<thead>
								<tr>
									<th>First Name</th>
									<th>Last Name</th>
									<th>Email</th>
									<th>Mobile No.</th>
									<th>Actions</th>
								</tr>
							</thead>
							<!-- loop over and print on html -->
							<tbody>
								<c:forEach var="customer" items="${customers }">
									<tr id="tr-content">
										<td>${customer.firstName}</td>
										<td>${customer.lastName}</td>
										<td>${customer.email}</td>
										<td>${customer.number}</td>
										<td>Update | Delete</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>

					</div>
				</div>

			</div>
		</div>
	</div>
	<footer id="footer">
		<p>@CIMS - Customer Information management System</p>
	</footer>
</body>
</html>