<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./css/main.css">
<!--  <script type="text/javascript" src="./js/custom.js"></script> -->
<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="./bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="assets/css/main.css" />
	<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			
<style type="text/css"> 
a { text-decoration:underline; } 
</style> 
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
	<div class="container-fluid">
		<!-- 로그아웃, 회원정보 -->
		<jsp:include page="jumbo.jsp"></jsp:include>

		<!-- 메뉴바 -->
		<jsp:include page="nav.jsp"></jsp:include>

		<!-- 검색 -->
		
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="row" style="color: white; margin: 10px;">
					<div class="col-md-4">검색 조건</div>
					<div class="col-md-7">검색 단어</div>
					<div class="col-md-1"></div>
				</div>
				<div class="row">
					<div class="col-md-4" >
						<select class="form-control" name="key" id="key">
							<option value="name" selected="selected">상품명</option>
							<option value="maker">제조사</option>
							<option value="material">재료명</option>
							<option value="calory">칼로리</option>
						</select>
					</div>
					<div class="col-md-7">
						<input type="text" class="form-control" name="search-input">
					</div>
					<div class="col-md-1">
						<button type="button" name="search-main" class="btn btn-info">검색</button>
					</div>
				</div>
				<div class="row"></div>
			</div>
			<div class="col-md-4"></div>
			<div id="wrapper" class="row" style="height: 100px; background-color: #dbe798;"></div>

		<!-- 리스트 목록 -->
		<section id="intro" class="main" style="padding: 50px 0;">
		<div class="container">
				<div class="main col-12">
					<div class="isotope-container row grid-space-10"
						style="height: 476.74px; display: block; position: relative;">
						<c:forEach items="${foodlist}" var="food">
							<div class="col-lg-4 col-md-6 isotope-item app-development"
								style="left: ${(food.code%3)*373}px; top: ${food.code>=4?0:238}px; position: absolute;">
								<div class="image-box hc-shadow-2 text-center mb-20">
									<div class="overlay-container">
										<a style="text-decoration:none" href="food_detail?pname=${food.name}"><img width="200" 
											class="center" alt="${food.name}" src="${food.img }"></a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</section>

		<!-- 리스트 end -->
		<jsp:include page="foot.jsp"></jsp:include>
	</div>

	<c:if test="${not empty msg}">
		<script type="text/javascript">
			alert('${msg}');
		</script>
		<%
			session.setAttribute("msg", null);
		%>
	</c:if>
</body>
</html>