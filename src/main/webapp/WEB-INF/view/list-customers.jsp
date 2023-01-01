<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

		<input type="button" class="add-button" value="Add Customer"
			onClick="window.location.href='showFormForAdd';return false" />
		<h3 class="total-customer">Total Customers
			(${fn:length(customers)})</h3>
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
									<c:url var="update" value="/updateForm">
										<c:param name="customerId" value="${customer.id }" />
									</c:url>
									<c:url var="delete" value="/delete">
										<c:param name="customerId" value="${customer.id }" />
									</c:url>
									<tr id="tr-content">
										<td>${customer.firstName}</td>
										<td>${customer.lastName}</td>
										<td>${customer.email}</td>
										<td>${customer.number}</td>
										<td><a class="actions" href="${update}">Update</a> | <a
											class="actions" href="${delete}"
											onClick="if (!(confirm ('Are you sure you want to delete this customer ?'))) return false">Delete</a></td>
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