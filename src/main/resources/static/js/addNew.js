var button = document.getElementById("add");
button.onclick = function () {
	 var formData = $(this.parentElement).serializeArray();
	 var dataObj = formToObj(formData);
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/products",
		data: JSON.stringify(dataObj),
		success: function(){
			window.location.href='http://localhost:8080/edit.html';
		},
		dataType: "json",
		contentType: "application/json"
	});
}

function formToObj(formData) {
	 var dataObj = {};
	 for (data in formData) {
		 dataObj[formData[data].name] = formData[data].value
	 }
	 return dataObj;
}