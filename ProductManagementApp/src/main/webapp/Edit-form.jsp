<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page   import = "java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
<!-- Bootsrap CDn link to get the support of bootstrap-->
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	
	<!-- this is java script validation code location  -->
	<script src="formvalidation.js"></script>
	
</head>
<body>
<div class="container mt-5 text-center">
<h2 class="text-center font-italic mb-2">Update Product Data..</h2>
<form method="post" action="./UpdateProductServlet" enctype="multipart/form-data" onsubmit="return validateForm()">
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="proId">Product Id :</label>
			<input type="text" class="form-control-sm" id="proId" name="proId" value="${existingProduct.proId }" required="required">
			</div>
			
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="proName">Product Name :</label>
			<input type="text" class="form-control-sm" id="proName" name="proName"  value="${existingProduct.proName }" required>
			</div>
			
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="proPrice">Product Price :</label>
			<input type="number" class="form-control-sm" id="proPrice" name="proPrice" value="${existingProduct.proPrice }" required>
			</div>
			
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="proBrand">Product Brand :</label>
			<input type="text" class="form-control-sm" id="proBrand" name="proBrand" value="${existingProduct.proBrand }" required>
			</div>
			
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="proMadeIn">Product MadeIn :</label>
			<input type="text" class="form-control-sm" id="proMadeIn" name="proMadeIn" value="${existingProduct.proMadeIn }" required>
			</div>
			
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="ProManfDate">ProManfDate :</label>
			<input type="date" class="form-control-sm" id="ProManfDate" name="ProManfDate" value="${existingProduct.proManfDate }" required>
			</div>
			
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="{ProExpDate">ProExpDate :</label>
			<input type="date" class="form-control-sm" id="ProExpDate" name="ProExpDate" value="${existingProduct.proExpDate }" required>
			</div>
			
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="proImage"> Current Product Image :</label>
			<img id="currentImage"
			src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.proImage) }" alt="current product image" style="max-width:100px; max-height:100px;">
			<input type="hidden" id="existingImage" name="existingImage" value ="${Base64.getEncoder().encodeToString(existingProduct.proImage) }" >
			</div>
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="newproImage"> New Product Image :</label>
			<input type="file" class="form-control-sm" id="newproImage" name="newproImage"  accept="image/*">
			</div>
			
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="proAudio"> Current Product Audio :</label>
			<audio  controls id="currentAudio">
			<source src="data:audio/mpeg;base64,${Base64.getEncoder().encodeToString(existingProduct.proAudio)}"          
		type ="audio/mpeg" ></audio>
		<input type="hidden" id="existingAudio" name="existingAudio" alt = " Current ProAudio" value ="${Base64.getEncoder().encodeToString(existingProduct.proAudio) }" >
			</div>
			
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="newproAudio"> New Product Audio :</label>
			<input type="file" class="form-control-sm" id="newproAudio" name="newproAudio"  accept="audio/*">
			</div>
			
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="proVideo"> Current Product Video :</label>
			<video  controls width="250">
			<source src="data:video/mp4;base64,${Base64.getEncoder().encodeToString(existingProduct.proVideo)}"
     type = "video/mp4"></video>
		<input type="hidden" id="existingVideo" name="existingVideo"  alt="Current proVideo" value ="${Base64.getEncoder().encodeToString(existingProduct.proVideo)}" >
			</div>
			
			<div class="form-group">
			<label class="font-italic font-weight-bold" for="newproVideo"> New Product Video :</label>
			<input type="file" class="form-control-sm" id="newproVideo" name="newproVideo"  accept="video/*">
			</div>
			
			<div>
				<input type="submit" class="btn btn-success" value="save product"/>
				<a href="productList.jsp" class="btn btn-primary">List of Products</a>
			</div>
</form>
</div>			
</body>
</html>
	
			
			
			