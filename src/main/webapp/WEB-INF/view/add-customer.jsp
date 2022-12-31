<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
<title>Add Customer</title>
</head>
<body>


	<div class="add-form">
		<h1>Add New Customer</h1>
		<form:form action="persist" modelAttribute="customer"
			method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>First Name</label></td>
						<td><form:input path="firstName" /></td>

					</tr>
					<tr>

						<td><label>Last Name</label></td>
						<td><form:input path="lastName" /></td>

					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><form:input path="email" /></td>
					</tr>

					<tr>
						<td><label>Mobile No.</label></td>
						<td><form:input path="number" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>

	</div>

</body>
</html>