<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border="1">

			<th>Product Name</th>
			<th>Category</th>
			<th>Invoice ID</th>
			<th>Price</th>
			<th>Date of Addition</th>
			<th>Action</th>

			<c:forEach var="product" items="${list}">
				<tr>

					<td>${product.product_name}</td>
					<td>${product.category}</td>
					<td>${product.invoice_id}</td>
					<td>${product.price}</td>
					<td>${product.product_add_date}</td>
					<td><a href="editProduct?id=${product.product_id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteProduct?id=${product.product_id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>