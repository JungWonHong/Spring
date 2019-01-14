<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="./resources/bootstrap-css/bootstrap.min.css"
	rel="stylesheet">
<link href="./resources/bootstrap-css/prettyPhoto.css" rel="stylesheet">
<link href="./resources/bootstrap-css/font-awesome.min.css"
	rel="stylesheet">
<link href="./resources/bootstrap-css/animate.css" rel="stylesheet">
<link href="./resources/bootstrap-css/main.css" rel="stylesheet">
<link href="./resources/bootstrap-css/responsive.css" rel="stylesheet">

<script src="./resources/js/jquery-3.2.1.js"></script>


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
	
	<script>
		/* 비밀번호 찾기 팝업창 */
		function pwd_find() {
			window.open("pwd_find.nhn", "비밀번호 찾기", "width=400, height=300");
			// 자바 스크립트에서 window 객체의  open("팝업창 경로와 파일명", "팝업창 이름", "팝업창 속성");
			// 메서드로 새로운 팝업창을 만듭니다. 폭이 400, 높이가 300인 새로운 팝업창. 단위는 픽셀
		}
		function reportwindow() {
			url = "./khcc_reportwrite.nhn";
			window.open(url, "report", "toolbar=no, status=yes, menubar=no,"
					+ "scrollbars=yes, directories=no, top=100, left=400,"
					+ "width=470px, height=500px");
		}
		function reportlistwindow() {
			url = "./khcc_reportlist.nhn";

			window.open(url, "report", "toolbar=no, status=yes, menubar=no,"
					+ "scrollbars=yes, directories=no,"
					+ "width=600px, height=450px");
		}

		$('li.dropdown').hover(
				function() {
					$(this).find('.dropdown-menu').stop(true, true).delay(200)
							.fadeIn(500);
				},
				function() {
					$(this).find('.dropdown-menu').stop(true, true).delay(200)
							.fadeOut(500);
				});
	</script>


	<header id="navigation">
		<div class="navbar navbar-inverse navbar-fixed-top" role="banner">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" onclick="loaction:href='khcc_home.nhn'"
						style="cursor: pointer"> <img
						src="./resources/images/logo.png">
					</a>
				</div>
				<!-- 일반사용자일 때 -->
				<c:if test="${login_email != 'admin@khcc.com'}">
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="khcc_servicesview.nhn">서비스 안내</a></li>
							<li><a href="khcc_reservation.nhn">실시간 예약</a></li>
							<li class="drop	down"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown">카풀</a>
								<ul class="dropdown-menu">
									<li><a href="cp_list">Driver</a></li>
									<li><a href="javascript:window.open('./rider', '카풀등록', 'width=800,height=500,scrollbars=yes');">Rider</a></li>
								</ul></li>
							<li><a href="qa_list.nhn">REVIEW</a></li>
                  			<li><a href="nt_list.nhn">고객센터</a></li>
							<li><a href="khcc_mypage.nhn">마이페이지</a></li>
							<li><a href="javascript:reportwindow()"> <img
									src="./resources/images/reporticon.png" style="width:20px; height:20px">신고하기</a>
						</ul>
					</div>
				</c:if>

				<!-- 관리자 계정으로 접속할 때 -->
				<c:if test="${login_email eq 'admin@khcc.com'}">
					<div class="collapse navbar-collapse">
						<ul class="nav navbar-nav navbar-right">
							<li><a href="javascript:reportlistwindow()">신고함</a></li>
							<li><a href="khcc_servicesview.nhn">서비스 안내</a></li>
							<li><a href="khcc_reservation.nhn">실시간 예약</a></li>
							<li class="drop	down"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown">카풀</a>
								<ul class="dropdown-menu">
									<li><a href="cp_list">Driver</a></li>
									<li><a href="javascript:window.open('./rider', '카풀등록', 'width=800,height=500,scrollbars=yes');">Rider</a></li>
								</ul></li>
							<li><a href="qa_list.nhn">REVIEW</a></li>
                  			<li><a href="nt_list.nhn">고객센터</a></li>
							<li><a href="khcc_adminpage.nhn">관리자페이지</a></li>
						</ul>
					</div>
				</c:if>
			</div>
			<div>
				<a href="khcc_logout.nhn" style="float: right">로그아웃</a>
			</div>
			<div>
				<a href="khcc_mypage.nhn" style="float: right">${m_name}님 환영합니다.</a>
			</div>
		</div>
		<!--/navbar-->
	</header>
	<!--/#navigation-->