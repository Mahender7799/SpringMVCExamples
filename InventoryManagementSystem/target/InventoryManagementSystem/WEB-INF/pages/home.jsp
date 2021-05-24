<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inventory Management System</title>
</head>
<body>
	<div align="center">
		<h1>Stock In Inventory</h1>
		<form action="searchProduct">
			<input type="text" name="query"/>
			<button >Submit</button>
		
		</form>
		<table border="1">
			
			<th>Product Name</th>
			<th>Category</th>
			<th>Invoice ID</th>
			<th>Price</th>
			<th>Date of Addition</th>
			<th>Action</th>

			<c:forEach var="product" items="${listProduct}">
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
		<h4>
			Add new Product <a href="addProduct">here</a>
		</h4>
	</div>
	
	<form action="filterByDate">
		<input pattern="(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/[0-9]{4}" title="dd/MM/yyyy" name="startDate" />
		<input pattern="(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/[0-9]{4}" title="dd/MM/yyyy" name="endDate" />
		<button >Filter By Date</button>
	</form>
	
	<form action="filterByCategory">
		<input type="radio" name="category" value="Electronics">Electronics<br>
		<input type="radio" name="category" value="Furniture">Furniture<br>
		<input type="radio" name="category" value="Heavy Electrical">Heavy Electrical<br>
		<input type="radio" name="category" value="Clothes">Clothes<br>
		<button >Filter By Category</button>
	</form>
</html>