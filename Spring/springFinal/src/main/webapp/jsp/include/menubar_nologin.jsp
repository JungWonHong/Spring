<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	$('li.dropdown').hover(function() {
	  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
	}, function() {
	  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
	});
</script>

	<header id="navigation">
		<div class="navbar navbar-inverse navbar-fixed-top" role="banner">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" onclick="loaction:href='khcc_home.nhn'"
						style="cursor: pointer"> 
						<img src="./resources/images/logo.png">
					</a>
				</div>
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
						<li><a href="khcc_login.nhn">로그인</a></li>
						<li><a href="khcc_join.nhn">회원가입</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!--/navbar-->
	</header>
	<!--/#navigation-->