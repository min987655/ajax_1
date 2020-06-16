function productDelete(productId) {

	$.ajax({
		type : "POST",
		url : "/ajax1/product?cmd=deleteProc",
		data : "productId="+productId,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "text"
	}).done(function(result) {
		console.log(result);
		if (result == "1") {
			alert("목록 삭제 성공");
			
			var productItem = $("#product-"+productId);
			productItem.remove();	
		}
	}).fail(function(Error) {
		alert("목록 삭제 실패");
	});
}

function productHomeList() {

	$.ajax({
		type : "POST",
		url : "/ajax1/product?cmd=homeListProc",
		contentType : "application/json; charset=utf-8",
		dataType : "json"
	}).done(function(result) {
		console.log(result);
		$("#product__list").empty();
		console.log(result);
		
		for(var product of result) {
		
		var productItem = `<tr id="product-${product.id}">
		 <td>${product.id}</td>
		 <td>${product.name}</td>
		 <td>${product.type}</td>
		 <td>${product.price}</td>
		 <td>${product.count}</td>
		 	<td onclick="productDelete(${product.id})" class="material-icons i__btn">delete</td>
		 </tr>`;
		
		$("#product__list").append(productItem);
		}
					
	}).fail(function(Error) {
		alert("목록 불러오기 실패");
	});
}
function productPriceList() {

	$.ajax({
		type : "POST",
		url : "/ajax1/product?cmd=priceListProc",
		contentType : "application/json; charset=utf-8",
		dataType : "json"
	}).done(function(result) {
		console.log(result);
		$("#product__list").empty();
		console.log(result);
		
		for(var product of result) {
		
		var productItem = `<tr id="product-${product.id}">
		 <td>${product.id}</td>
		 <td>${product.name}</td>
		 <td>${product.type}</td>
		 <td>${product.price}</td>
		 <td>${product.count}</td>
		 <td onclick="productDelete(${product.id})" class="material-icons i__btn">delete</td>
		 </tr>`;
		
		$("#product__list").append(productItem);
		}
					
	}).fail(function(Error) {
		alert("목록 불러오기 실패");
	});
}
function productCountList() {

	$.ajax({
		type : "POST",
		url : "/ajax1/product?cmd=countListProc",
		contentType : "application/json; charset=utf-8",
		dataType : "json"
	}).done(function(result) {
		console.log(result);
		$("#product__list").empty();
		console.log(result);
		
		for(var product of result) {
		
		var productItem = `<tr id="product-${product.id}">
		 <td>${product.id}</td>
		 <td>${product.name}</td>
		 <td>${product.type}</td>
		 <td>${product.price}</td>
		 <td>${product.count}</td>
		 <td onclick="productDelete(${product.id})" class="material-icons i__btn">delete</td>
		 </tr>`;
		
		$("#product__list").append(productItem);
		}
		
		
	}).fail(function(Error) {
		alert("목록 불러오기 실패");
	});
}