<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>ajax v1.0</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="/ajax1/css/styles.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="m-5">

			<form class="form-inline d-flex justify-content-end">
				<button type="button" class="btn btn-light mt-5 mb-2" onclick="productHomeList();">처음으로</button>
				<button type="button" class="btn btn-light mt-5 mb-2 mr-2 ml-2" onclick="productPriceList();">가격순</button>
				<button type="button" class="btn btn-light mt-5 mb-2" onclick="productCountList();">판매수</button>
			</form>
			<table class="table table-hover">
				<thead>
					<tr align="center">
						<th>번호</th>
						<th>이름</th>
						<th>종류</th>
						<th>가격</th>
						<th>판매수</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody id="product__list">
					<c:forEach var="product" items="${products}">
						<tr align="center" id="product-${product.id}">
							<td>${product.id}</td>
							<td>${product.name}</td>
							<td>${product.type}</td>
							<td>${product.price}</td>
							<td>${product.count}</td>
							<td onclick="productDelete(${product.id})" align="center" style="width: 100% " class="material-icons i__btn">delete</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

<script src="/ajax1/js/home.js"></script>

</body>
</html>