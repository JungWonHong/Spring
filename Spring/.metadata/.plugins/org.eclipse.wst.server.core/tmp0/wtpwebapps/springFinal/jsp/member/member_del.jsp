<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원탈퇴(member_del.jsp)</title>
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css">
<link rel="stylesheet" type="text/css" href="./resources/css/member.css">
<link href="./resources/bootstrap-css/bootstrap.min.css"
	rel="stylesheet">
<link href="./resources/bootstrap-css/prettyPhoto.css" rel="stylesheet">
<link href="./resources/bootstrap-css/font-awesome.min.css"
	rel="stylesheet">
<link href="./resources/bootstrap-css/animate.css" rel="stylesheet">
<link href="./resources/bootstrap-css/main.css" rel="stylesheet">
<link href="./resources/bootstrap-css/responsive.css" rel="stylesheet">

<script src="./resources/js/jquery-3.2.1.js"></script>
<script>
	function del_check() {
		if ($.trim($("#del_password").val()) == "") {
			alert("비밀번호를 입력하세요!");
			$("#m_password").val("").focus();
			return false;
		}
	}
</script>
</head>
<body>
	<%@ include file="../include/menubar_login.jsp"%>
	<section id="about-us">
		<div class="container">
			<div class="text-center">
				<div>
					<h2 class="title-one">KHCC를 떠날건가요?</h2>
				</div>
			</div>
			<div class="about-us">
					<div class="tab-content">
							<div class="media">
								<div class="media-body">
									<h3>탈퇴 하기</h3>
									<form method="post" action="member_del_ok.nhn"
										onsubmit="return del_check()">
										<table id="del_t">
											<tr>
												<th>회원 이메일</th>
												<td>${login_email}</td>
											</tr>

											<tr>
												<th>회원 이름</th>
												<td>${m_name}</td>
											</tr>

											<tr>
												<th>비밀번호</th>
												<td><input type="password" name="del_password" id="del_password"
													size="14" class="input_box"></td>
											</tr>
										</table>

										<div id="del_menu">
											<input type="submit" value="탈퇴 신청" class="btn btn-default">
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
	</section>

	<script type="text/javascript" src="./resources/bootstrap-js/jquery.js"></script>
	<script type="text/javascript"
		src="./resources/bootstrap-js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="./resources/bootstrap-js/smoothscroll.js"></script>
	<script type="text/javascript"
		src="./resources/bootstrap-js/jquery.isotope.min.js"></script>
	<script type="text/javascript"
		src="./resources/bootstrap-js/jquery.prettyPhoto.js"></script>
	<script type="text/javascript"
		src="./resources/bootstrap-js/jquery.parallax.js"></script>
	<script type="text/javascript" src="./resources/bootstrap-js/main.js"></script>
</body>
</html>