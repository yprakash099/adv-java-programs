function validateForm() {
	// Read the form data
	var prodId = document.getElementById("proId").value;
	var prodName = document.getElementById("proName").value;
	var prodPrice = document.getElementById("proPrice").value;
	var prodBrand = document.getElementById("proBrand").value;
	var prodMadeIn = document.getElementById("proMadeIn").value;
	var ProManfDate = document.getElementById("ProManfDate").value;
	var prodExpDate = document.getElementById("ProExpDate").value;

	// Check all fields datas are present or not 
	if (prodId.trim() === "" || prodName.trim() === "" || prodPrice.trim() === "" || prodBrand.trim() === "" || prodMadeIn.trim() === "") {
		alert("Please enter all values");
		return false;
	}

	// Check name and brand are less than 50 characters or not
	if (prodName.length > 50 || prodBrand.length > 50) {
		alert("Name or Brand can't be more than 50 characters..")
		return false;
	}

	// Check if Price is negative value
	if(prodPrice<0){
		alert("Price can't be a Negative value...")
		return false;
	}
	// Converting date of String format to date format
	var ProManfDate = new Date(ProManfDate);
	var expDate = new Date(prodExpDate);

	// Checking Manufacturing date is less than Expiry date or not
	if (ProManfDate > expDate) {
		alert("Manufacturing date can't be more than Expiry Date..");
		return false;
	}

	return true;
}