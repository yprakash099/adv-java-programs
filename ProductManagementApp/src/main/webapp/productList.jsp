<%@page import="com.sathy.servlet.ProductDao" 
import = "java.util.Base64"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<!DOCTYPE html>
<html>
<head>

<title>Product list</title>

<!-- Bootsrap CDn link to get the support of bootstrap-->
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<h1 class="text-center font-italic text-success">List Of Available Products..</h1>

<div>
<a href="Add-product.html" class="btn btn-success">Save Product </a>
</div><br>

<div>
	<input type="search" placeholder="search">
</div><br>



<div>
<a:if test="${saveResult==1}">
<h3 class="text-center font-italic text-success">Data inserted successfully..</h3>
</a:if>
</div>

<div>
<a:if test="${deleteResult==1}">
<h3 class="text-center font-italic text-danger">Data Deleted successfully..</h3>
</a:if>

<a:if test="${deleteResult==0}">
<h3 class="text-center font-italic text-danger">Data Deletion Fail..</h3>
</a:if>
</div>
<div>
<a:if test="${updateResult==1}">
<h3 class="text-center font-italic text-success">Data updated successfully..</h3>
</a:if>
</div>


<table class="table table-bordered table-striped">
<thead class="thead-dark">
	<tr>
	<th>Product Id</th>
	<th>Product Name</th>
	<th>Product Price</th>
	<th>Product Brand</th>
	<th>Product MadeIn</th>
	<th>ProManfDate</th>
	<th>ProExpDate</th>
	<th>Product Image</th>
	<th>Product Audio</th>
	<th>Product Vedio</th>
	<th>Actions</th>
	</tr>
</thead>
<tbody>
	<a:forEach var="product" items="<%= new ProductDao().findAll()%>">
	
	<tr>
		<td>${product.proId}</td>
		<td>${product.proName}</td>
		<td>${product.proPrice}</td>
		<td>${product.proBrand}</td>
		<td>${product.proMadeIn}</td>
		<td>${product.proManfDate}</td>
		<td>${product.proExpDate}</td>
		<td><img alt="product image" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.proImage)}" style="max-width: 100px; max-height: 100px;">
		</td>
		
		<td><audio controls><source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(product.proAudio)}"          
		type ="audio/mpeg"></audio></td>
    
    <td>
     <video  controls width="250"><source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(product.proVideo)}"
     type = "video/mp4"></video>
    </td>
		<td>
		<a class="btn btn-primary" href="./DeleteProductServlet?proId=${product.proId }">Delete</a>
		<a class="btn btn-primary" href="./EditProductServlet?proId=${product.proId }">Edit</a>
		</td>
	</tr>
	</a:forEach>	
</tbody>
</table>
</body>
</html>

		
    
 
	