<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="assets/css/main.css" />
<title>Insert title here</title>
</head>
<body>
					<header id="header" class="alt">
				<div class="inner">
					<h1>Safe Food</h1>
					<p>Health life project of Ssafy</p>
					<div class="col-md-7">
					<ul class="nav navbar-nav" id="navid">
					<li>
					<a href="/mainpage">홈으로</a>
					<c:if test="${not empty id}">
					<a href="myInfo">내정보</a><!-- if문으로 다시 만들고 -->
					</c:if>
					<a href="food_searchlist?key=name&value=">상품 정보</a>
					<a href="/board">게시판</a>
					</li>		
					</ul>
				</div>
				</div>
			</header>
	
</body>
</html>