<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 조회</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./css/main.css">
<script type="text/javascript" src="./js/custom.js"></script>
<script type="text/javascript" src="./js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="./bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<style>
fieldset {
	padding: 10px 25px;
	margin: 15px 0px;
	border: 1px solid silver;
	backgroound-color: #fafafa;
}
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
function main() {
	location.href = "mainpage";
}
	function updatemem() {
		rform.submit();
	}
	function deletemem() {
		location.href = "deleteMem";
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
	         // 엔터키가 눌렸을 때 실행할 내용
	         login();
	    }
	}
</script>
</head>

<body style="padding-top: 40px;">
	<!-- Navigation Bar -->
	<div class="container-fluid">

		<!-- 메뉴바 -->

		<div class="row">
			<ul class="nav navbar-nav" style="float: left">
				<li class="glyphicon glyphicon-home">Home</li>
				<li>> 회원조회</li>
			</ul>
		</div>


		<div class="row" style="background-color: grey;">
			<div class="row" style="margin: 20px;">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3" style="text-align: center;">
									<h3>회원 정보 조회</h3>
								</div>
								<div class="col-md-7"></div>
								<div class="col-md-2"></div>
							</div>
							<div class="col-sm-10">
								<form class="form-horizontal"
									action="updateMem" method="post" id="rform">
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">아이디 </label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="pid" id="pid"
												value="${mem.id }" readonly="readonly">
										</div>
									</div>
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">이름 </label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="pname"
												id="pname" value="${mem.name }">
										</div>
									</div>
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">비밀번호 </label>
										<div class="col-sm-9">
											<input type="password" class="form-control" name="ppw"
												id="pname" value="${mem.pw }">
										</div>
									</div>
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">이메일 </label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="pemail"
												id="pname" value="${mem.email }">
										</div>
									</div>
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">신장 </label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="pcm"
												id="pname" value="${mem.cm }">
										</div>
									</div>
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">체중 </label>
										<div class="col-sm-9">
											<input type="text" class="form-control" name="pkg"
												id="pname" value="${mem.kg }">
										</div>
									</div>
									
									<div class="form-group has-default has-feedback">
										<label class="control-label col-sm-3">알레르기 </label>
										<div class="col-sm-9">
											<fieldset class="form-group">
												<legend>Check</legend>
												<p>
													<input type="checkbox" name="pallergy" value="대두" />대두&nbsp&nbsp
													<input type="checkbox" name="pallergy" value="땅콩" />땅콩&nbsp&nbsp
													<input type="checkbox" name="pallergy" value="우유" />우유&nbsp&nbsp
													<input type="checkbox" name="pallergy" value="게" />게&nbsp&nbsp


												
												<p />
												<p>
													<input type="checkbox" name="pallergy" value="새우" />새우&nbsp&nbsp
													<input type="checkbox" name="pallergy" value="참치" />참치&nbsp&nbsp
													<input type="checkbox" name="pallergy" value="연어" />연어&nbsp&nbsp
													<input type="checkbox" name="pallergy" value="쑥" />쑥&nbsp&nbsp


												
												<p />
												<p>
													<input type="checkbox" name="pallergy" value="소고기" />소고기&nbsp&nbsp
													<input type="checkbox" name="pallergy" value="닭고기" />닭고기&nbsp&nbsp
													<input type="checkbox" name="pallergy" value="돼지고기" />돼지고기&nbsp&nbsp
													​ ​
												<p />
												<input type="checkbox" name="pallergy" value="복숭아" />복숭아&nbsp&nbsp
												<input type="checkbox" name="pallergy" value="민들레" />민들레&nbsp&nbsp
												<input type="checkbox" name="pallergy" value="계란흰자" />계란흰자&nbsp&nbsp
											</fieldset>
										</div>
									</div>
									<div class="form-group text-center">
										<input type="button" value="수정" onclick="updatemem()">
										<input type="button" value="삭제" onclick="deletemem()">
										<input type="button" value="취소" onclick="main()">
									</div>
									<c:if test="${not empty msg}">
										<div style="font-size: 20px; color: green; font-weight: bold;" align="center">
											<p>${msg}</p>
										</div>
									</c:if>
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