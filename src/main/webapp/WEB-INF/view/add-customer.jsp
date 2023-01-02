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





	<div class="container">
		<h1>Add New Customer</h1>
		<form:form action="persist" modelAttribute="customer" method="POST">
			<!--  need to associate this data with customer id -->
			<form:hidden path="id" />
			<label>First Name</label>
			<form:input path="firstName" id="fname" />

			<label for="lname">Last Name</label>
			<form:input path="firstName" id="lname" />

			<label>Email</label>
			<form:input path="email" id="fname" />

			<label>Number</label>
			<form:input path="number" id="fname" />
			<input type="submit" value="Submit">
		</form:form>
	</div>

</body>
</html>