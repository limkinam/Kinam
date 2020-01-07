<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./css/main.css">
<!--  <script type="text/javascript" src="./js/custom.js"></script> -->
<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="./bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<script src="./js/Chart.js"></script>
</head>
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
<body>
	<!-- Header -->
	<jsp:include page="jumbo.jsp"></jsp:include>

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Banner -->
					<section id="intro" class="main">
					<img src="${img}">
						<h2>${mem.name} 님</h2>
						<a>키 : ${mem.cm} cm</a>   |
						<a>체중 : ${mem.kg} kg</a><br>
						<a>섭취식품 : ${mem.eating}</a><br>
						<a>선호식품 : ${mem.favor}</a><br>				
						<a>알러지 : ${mem.allergy}</a>					
					</section>

				<!-- Items -->
					<section class="main items">
						<article class="item">
							<header>
								<a><img src="./images/pic01.jpg" alt="" /></a>
								<h3>선호 식품</h3>
							</header>
							<p>예상 섭취 칼로리 : ${favorcal} kcal</p>
							<div class="row">
				<c:forEach items="${favor }" var="food">
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
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
						</article>
						<article class="item">
							<header>
								<a href="#"><img src="./images/pic01.jpg" alt="" /></a>
								<h3>섭취한 식품</h3>
							</header>
							<p>오늘 섭취 칼로리 : ${eatingcal} kcal</p>
							<div class="row">
				<c:forEach items="${eating }" var="food">
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
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
						</article>
					</section>
				<!-- 그래프그리자 -->
				<section class="main items">
						<article class="item">
						<h3>권장 - 예상</h3>
							<canvas id="radarChart1"></canvas>
						</article>
						<article class="item">
						<h3>권장 - 섭취</h3>
							<canvas id="radarChart2"></canvas>
						</article>
					</section>

				<!-- Footer -->
					<footer id="footer">
						<ul class="icons">
							<li><a href="https://twitter.com/?lang=ko" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
							<li><a href="https://ko-kr.facebook.com/" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
							<li><a href="https://www.instagram.com/?hl=ko" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
							<li><a href="https://accounts.google.com/" class="icon fa-envelope"><span class="label">Email</span></a></li>
						</ul>
						<p class="copyright">&copy;<a href="https://www.ssafy.com/ksp/jsp/swp/swpMain.jsp">Edu Ssafy</a>.</p>
					</footer>

			</div>
	<jsp:include page="foot.jsp"></jsp:include>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
</body>
<script type="text/javascript">
/* 선호랑 권장 */
var ctxR1 = document.getElementById("radarChart1").getContext('2d');
var myRadarChart = new Chart(ctxR1, {
type: 'radar',
data: {
labels: ["칼로리", "탄수화물", "단백질", "지방"],
datasets: [{
label: "권장 섭취량",
data: [${reccal}, ${rectan}, ${recdan}, ${recgi}],
backgroundColor: [
'rgba(105, 0, 132, .2)',
],
borderColor: [
'rgba(200, 99, 132, .7)',
],
borderWidth: 2
},
{
label: "예상 섭취량",
data: [${favorcal},${favortan},${favordan},${favorgi}],
backgroundColor: [
'rgba(0, 250, 220, .2)',
],
borderColor: [
'rgba(0, 213, 132, .7)',
],
borderWidth: 2
}
]
},
options: {
responsive: true
}
});

var ctxR2 = document.getElementById("radarChart2").getContext('2d');
var myRadarChart = new Chart(ctxR2, {
type: 'radar',
data: {
labels: ["칼로리", "탄수화물", "단백질", "지방"],
datasets: [{
label: "권장 섭취량",
data: [${reccal}, ${rectan}, ${recdan}, ${recgi}],
backgroundColor: [
'rgba(105, 0, 132, .2)',
],
borderColor: [
'rgba(200, 99, 132, .7)',
],
borderWidth: 2
},
{
label: "오늘 섭취량",
data: [${eatingcal},${eatingtan},${eatingdan},${eatinggi}],
backgroundColor: [
'rgba(0, 250, 220, .2)',
],
borderColor: [
'rgba(0, 213, 132, .7)',
],
borderWidth: 2
}
]
},
options: {
responsive: true
}
});
</script>
</html>