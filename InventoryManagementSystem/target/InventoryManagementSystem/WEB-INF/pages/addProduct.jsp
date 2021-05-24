<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<title>Add Product</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Inventory</h1>
		<form:form action="saveProduct" method="post" modelAttribute="product">
			
			<table>
				<form:hidden path="product_id" />


				<tr>
					<td>Product Name:</td>
					<td><form:input type="text" path="product_name" /></td>
				</tr>
				<tr>
					<td>Product Category:</td>
					<td><form:input type="text" path="category" /></td>
				</tr>
				<tr>
					<td>Invoice ID:</td>
					<td><form:input path="invoice_id" /></td>
				</tr>
				<tr>
					<td>Price of Product:</td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td>Date of Product Addition:</td>
					<td><form:input pattern="(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/[0-9]{4}" title="dd/MM/yyyy" path="product_add_date" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>