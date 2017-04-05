$(document).ready(function() {
	$.ajax({
		url: "http://localhost:8080/products"
	}).then(function(data) {
		$('.menu').append(data);
		console.log(data._embedded.products);
		var products = data._embedded.products;
		var menu = document.getElementById("menuBoard");
		for (i in products) {
			if(products[i].available == false) {
				continue;
			}			
			var menuItem = document.createElement("div");
			menuItem.className = "item";
			
			/*Add Combo*/
			if(products[i].comboPrice) {
				var comboContainer = document.createElement("div");
				comboContainer.className = "comboContainer";
				var comboTitle = document.createElement("div");
				comboTitle.className = "comboTitle";
				comboTitle.innerHTML = "COMBO";
				comboContainer.append(comboTitle);
				var comboPrice = document.createElement("div");
				comboPrice.className = "comboPrice";
				comboPrice.innerHTML = products[i].comboPrice.toFixed(2);
				comboContainer.append(comboPrice);
				menuItem.append(comboContainer);
			}
			
			/*Add Each*/
			var eachContainer = document.createElement("div");
			eachContainer.className = "eachContainer";
			var eachTitle = document.createElement("div");
			eachTitle.className = "eachTitle";
			eachTitle.innerHTML = "EACH";
			eachContainer.append(eachTitle);
			var eachPrice = document.createElement("div");
			eachPrice.className = "eachPrice";
			eachPrice.innerHTML = products[i].eachPrice.toFixed(2);
			eachContainer.append(eachPrice);
			menuItem.append(eachContainer);
			
			/*Add image*/
			var image = document.createElement("img");
			image.src = products[i].image;
			image.alt = "Image not available";
			menuItem.append(image);
			
			/*Add name*/
			var productName = document.createElement("div");
			productName.className = "productName";
			productName.innerHTML = products[i].name.toUpperCase();
			menuItem.append(productName);
			
			menu.append(menuItem);
			
		}
	});
});

