<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
​
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/main.css">
​
<script type="text/javascript" src="./js/custom.js"></script>
<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="./bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
fieldset {
	padding: 10px 25px;
	margin: 15px 0px;
	border: 1px solid silver;
	backgroound-color: #fafafa;
}

​
fieldset legend {
	display: block;
	width: auto;
	padding: 3px 10px;
	margin-bottom: 0;
	font-size: 15px;
	line-height: inherit;
	color: #333333;
	border: 1px solid #ddd;
	background-color: #ffffff;
	font-weight: bold;
}
</style>
<script type="text/javascript">
	function searchpw() {
		pwform.submit();
	}
</script>
</head>
<script>
	function main() {
		location.href = "mainpage";
	}
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
	         login();
	    }
	}
</script>
​
<body style="padding-top: 40px;">
	<!-- Navigation Bar -->
	<div class="container-fluid">
		​
		<!-- 메뉴바 -->
		<jsp:include page="nav.jsp"></jsp:include>
		​
		<div class="row">
			<ul class="nav navbar-nav" style="float: left">
				<li class="glyphicon glyphicon-home">Home</li>
				<li>> 비밀번호 찾기</li>
			</ul>
		</div>
		​ ​
		<div class="row" style="background-color: grey;">
			<div class="row" style="margin: 20px;">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3" style="text-align: center;">
									<h3>비밀번호 찾기</h3>
								</div>
								<div class="col-md-7"></div>
								<div class="col-md-2"></div>
							</div>
							<div class="col-sm-10">
								<form class="form-horizontal" action="searchpw" method="post"
									id="pwform">
									​
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">이름 *</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="pname"
												name="pname" aria-describedby="inputSuccess3Status">
											<span class="glyphicon glyphicon-user form-control-feedback"
												aria-hidden="true"></span>
										</div>
									</div>
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">아이디 *</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="pid" name="pid"
												aria-describedby="inputSuccess3Status"> <span
												class="glyphicon glyphicon-pencil form-control-feedback"
												aria-hidden="true"></span>
										</div>
									</div>
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">전화번호 *</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="ptel" name="ptel"
												aria-describedby="inputSuccess3Status"> <span
												class="glyphicon glyphicon-lock form-control-feedback"
												aria-hidden="true"></span>
										</div>
									</div>
									​
									<div class="form-group text-center">
										<input type="button" class="btn btn-info" value="비밀번호 찾기 "
											onclick="searchpw()">
										<input type="button" class="btn btn-info" value="취소" onclick="main()">
									</div>

									<div>
										<c:if test="${not empty id and not empty pw}">
											<p>${id}님의 비밀번호는 ${pw}입니다.</p>
										</c:if>
										<c:if test="${not empty id and empty pw}">
											<p>${id}님의 정보를 찾을 수 없습니다.</p>
										</c:if>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>
		</div>

		<jsp:include page="foot.jsp"></jsp:include>
	</div>
</body>
</html>