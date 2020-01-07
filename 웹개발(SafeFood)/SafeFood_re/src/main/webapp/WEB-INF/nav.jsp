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
<c:if test="${not empty msg}">
<script>
	alert(${msg});
</script>
</c:if>
<nav class="navbar navbar-fixed-top" style="opacity:1;">
	<section class="header-top-section">
		<div class="row">
			<div class="col-md-6">
				<div class="header-top-content">
					<ul class="nav nav-pills navbar-left">
					</ul>
				</div>
			</div>
			<div class="col-md-6">
				<ul class="nav nav-pills navbar-right" id="nara">
					<c:choose>
						<c:when test="${id eq null }">
							<li>
								<div class="dropdown">
									<button
										class="btn btn-sm dropdown-toggle glyphicon glyphicon-user"
										type="button" id="dropdownMenuButton" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false"
										style="background-color: orange; border:1px solid gold; color: #ffffff; margin: 7px">Login</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton"
										style="background-color: #2e3537;">
										<form class="loginform" action="loginMem" method="post"
											id="loginform"
											style="width: 300px; height: 310px; border: 0;">
											<br />
											<div style="margin-top: 10px; margin-left: 30px; color: #fff">아
												이 디</div>
											<br /> <input type="text" name="pid" id="pid" maxlength="30"
												style="border: none; border-right: 0px; border-top: 0px; boder-left: 0px; boder-bottom: 0px; margin-left: 30px; padding: .3em .5em; cursor: text; width: 200px; background-position: center right; background-repeat: no-repeat; background-color: #777777;">
											<br />
											<div style="margin-top: 10px; margin-left: 30px; color: #fff">비
												밀 번 호</div>
											<br /> <input type="password" name="ppw" id="ppw"
												maxlength="30"
												style="border: none; border-right: 0px; border-top: 0px; boder-left: 0px; boder-bottom: 0px; margin-left: 30px; padding: .3em .5em; cursor: text; width: 200px; background-position: center right; background-repeat: no-repeat; background-color: #777777;">
											 <input type="button" value="로그인"
												onclick="login()"
												style="color: white; margin-left: 30px; margin-top: 10px; background: #e1e1e1; border: solid 2px grey; border-radius: 5px;" />
											 <a href="searchpwPage"><input type="button"
												value="비밀번호 찾기"
												style="color: white; margin-left: 30px; margin-top: 10px; background: #e1e1e1; border: solid 2px grey; boder-bottom: 0px;" /></a>
										</form>
									</div>
								</div>
							</li>
							<li><a href="registMemPage"
								class="btn btn-sm glyphicon glyphicon-user"
								style="background-color: orange; color: #000000; margin-right:100px; margin-top:7px; border:1px solid gold; ">회원가입</a></li>

						</c:when>
						<c:otherwise>
							<input class="btn btn-secondary dropdown-toggle"
								style="background-color:orange; color: #ffffff; margin-top: 7px; border:1px solid gold;"
								type="button" value="로그아웃" onclick="logout()">
							<input class="btn btn-secondary dropdown-toggle"
								style="background-color:orange; color: #ffffff; margin-top: 7px; margin-right: 30px; border:1px solid gold;"
								type="button" value="회원 조회" onclick="meminfo()">
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</section>
</nav>

	
</body>
</html>