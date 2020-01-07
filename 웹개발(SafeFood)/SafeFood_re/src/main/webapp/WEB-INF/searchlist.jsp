<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SafeFood</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./css/main.css">

<!--  <script type="text/javascript" src="./js/custom.js"></script> -->
<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="./bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<script>
	function login() {
		loginform.submit();
	}
	function logout() {
		location.href = "logoutMem";
	}
	function meminfo() {
		location.href = "memInfo";
	}
	function enterkey() {
	    if (window.event.keyCode == 13) {
	         // 엔터키가 눌렸을 때 실행할 내용
	         login();
	    }
	}
</script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('[name="search-main"').on(
						'click',
						function() {

							location.href = encodeURI("food_searchbutton?key="
									+ $('#key').val() + "&value="
									+ $('[name="search-input"]').val());
						});

				$('[name="search"').on(
						'click',
						function() {

							location.href = encodeURI("food_searchlist?key="
									+ $('#key').val() + "&value="
									+ $('[name="search-input"]').val());
						});
			});
</script>
</head>

<body>
	<!-- Navigation Bar -->
	<jsp:include page="nav.jsp"></jsp:include>
	<jsp:include page="jumbo.jsp"></jsp:include>
	
	<!-- 검색 -->
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="row" style="color: white; margin: 10px;">
				<div class="col-md-4"">검색 조건</div>
				<div class="col-md-7">검색 단어</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<select class="form-control" name="key" id="key">
						<option value="name" selected="selected">상품명</option>
						<option value="maker">제조사</option>
						<option value="material">재료명</option>
					</select>
				</div>
				<div class="col-md-7">
					<input type="text" class="form-control" name="search-input">
				</div>
				<div class="col-md-1">
					<button type="button" name="search" class="btn btn-info">검색</button>
				</div>
			</div>
			<div class="row"></div>
		</div>
		<div class="col-md-4"></div>
		<div id="wrapper" class="row" style="height: 100px; background-color: #dbe798;"></div>

	<!-- 상품정보 리스트 -->
	<section id="intro" style="padding: 50px 0;">
		<div class="container-fluid" style="margin-left: 120px;">
			<div class="row">
				<c:forEach items="${foodlist }" var="food">
					<div class="main col-md-6">
						<div class="col-md-12" style="margin-bottom: 50px;"></div>
						<div class="card mb-3">
							<div class="row no-gutters">
								<div class="col-md-4">
									<a href="food_detail?pname=${food.name}"><img src="${food.img}" width="200"
										class="card-img"> <span class="desc"> <strong>${food.name}<br />${food.maker}
										</strong></span></a>
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<h3 class="title">
											<a href="food_detail?pname=${food.name}">${food.name}</a>
										</h3>
										<p class="card-description">
											<i style="margin-left: 10px;"
												class="glyphicon glyphicon-calendar"></i>&nbspFeb,2019&nbsp&nbsp
											<i class="glyphicon glyphicon-tag"></i>&nbspWeb,Design&nbsp
										</p>
										<p
											style="width: 400px; height: 150px; margin-left: 10px; overflow: auto;">${food.material }</p>
										<div class="btn-group">
											<a href="addfavor?pname=${food.name}" class="btn btn-info btn-sm"><img src="img/add.png"
												width="15px">선호</a>
												
												 <a href="addeating?pname=${food.name}"class="btn btn-info btn-sm"><img
												src="img/heart.png" width="15px">섭취</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<jsp:include page="foot.jsp"></jsp:include>

</body>
</html>