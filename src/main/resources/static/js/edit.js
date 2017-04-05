$(document).ready(function() {
	$.ajax({
		url: "http://localhost:8080/products"
	}).then(function(data) {
		$('.menu').append(data);
		console.log(data._embedded.products);
		var products = data._embedded.products;
		var menu = document.getElementById("main");
		var template = document.getElementById("item");
		for (i in products) {
			
			var menuItem = template.cloneNode(true);
			menuItem.className="item";
			
			var form = menuItem.children[0];
			var inputs = form.children;
			
			/*Add id to hidden input*/
			var url = products[i]._links.self.href;
			var id = url.split("/");
			id = id[id.length-1];
			inputs[0].value = id;
			
			inputs[2].value = products[i].name;
			inputs[4].value = products[i].comboPrice.toFixed(2);
			inputs[6].value = products[i].eachPrice.toFixed(2);
			inputs[8].value = products[i].image;
			
			if(products[i].available) {
				inputs[10].checked = true;
			} else {
				inputs[12].checked = true;
			}
			
			var update = document.createElement("button");
			update.innerHTML = "Update";
			update.type = "button";
			update.onclick = function() {
				 var formData = $(this.parentElement).serializeArray();
				 var dataObj = formToObj(formData);
				$.ajax({
					type: "POST",
					url: "http://localhost:8080/products",
					data: JSON.stringify(dataObj),
					success: function(){
						alert("Product has been updated.");
					},
					dataType: "json",
					contentType: "application/json"
				});
			}
			var remove = document.createElement("button");
			remove.innerHTML = "Delete";
			remove.onclick = function () {
				if(confirm("Are you sure you want to delete this product?") == true) {
					 var formData = $(this.parentElement).serializeArray();
					 var dataObj = formToObj(formData);
					$.ajax({
						type: "DELETE",
						url: "http://localhost:8080/products/" + dataObj.id,
						success: function(){
							var itemNode = this.parentElement.parentElement;
							var parentNode = itemNode.parentElement;
							parentNode.removeNode(itemNode);
						},
						dataType: "json",
						contentType: "application/json"
					});
				}

			}
			form.append(update);
			form.append(remove);			
			menu.append(menuItem);			
		}
		/*Button for adding new product entries*/
		var addNew = document.createElement("button");
		addNew.type = "button";
		addNew.className = "addNew";
		addNew.innerHTML = "ADD NEW";
		addNew.onclick = function() {
			window.location.href="http://localhost:8080/addNew.html";
		}
		menu.append(addNew);
	});
});

function formToObj(formData) {
	 var dataObj = {};
	 for (data in formData) {
		 dataObj[formData[data].name] = formData[data].value
	 }
	 return dataObj;
}

