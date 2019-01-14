<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<html>
<head>
	<title>KHCC - HOME</title>
<link rel="stylesheet" type="text/css" href="./resources/css/admin.css">
<link rel="stylesheet" type="text/css" href="./resources/css/member.css">
<link href="./resources/bootstrap-css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/bootstrap-css/prettyPhoto.css" rel="stylesheet"> 
<link href="./resources/bootstrap-css/font-awesome.min.css" rel="stylesheet"> 
<link href="./resources/bootstrap-css/animate.css" rel="stylesheet"> 
<link href="./resources/bootstrap-css/main.css" rel="stylesheet">
<link href="./resources/bootstrap-css/responsive.css" rel="stylesheet">

<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/member4.js"></script>
</head>
<body>
<c:if test="${!empty login_email}">
<%@ include file = "../include/menubar_login.jsp" %>
</c:if>

<c:if test="${empty login_email}">
<%@ include file = "../include/menubar_nologin.jsp" %>
</c:if>
<section id="home">
		<div class="home-pattern"></div>
		<div id="main-carousel" class="carousel slide" data-ride="carousel"> 
			<ol class="carousel-indicators">
				<li data-target="#main-carousel" data-slide-to="0" class="active"></li>
				<li data-target="#main-carousel" data-slide-to="1"></li>
				<li data-target="#main-carousel" data-slide-to="2"></li>
			</ol>
			
			<!--/.carousel-indicators--> 
			<div class="carousel-inner" style="height:800px">
				<div class="item active" style="background-image: url(./resources/images/car222.jpg)"> 
					<div class="carousel-caption"> 
						<div> 
							<h2 class="heading animated bounceInDown">합리적이고 편안한</h2> 
							<p class="animated bounceInLeft">카쉐어링 & 카풀</p> 
							<a class="btn btn-default slider-btn animated bounceInUp" href="#">시작!</a> 
						</div> 
					</div> 
				</div>
				<div class="item" style="background-image: url(./resources/images/car111.jpg)"> 
					<div class="carousel-caption"> <div> 
						<h2 class="heading animated bounceInDown">언제나 어디서든 자유롭게</h2> 
						<p class="animated bounceInRight">아무때나 이용하세요</p> 
						<a class="btn btn-default slider-btn animated bounceInUp" href="#">Get Started</a> 
					</div> 
				</div> 
			</div> 
			<div class="item" style="background-image: url(./resources/images/car333.jpg)"> 
				<div class="carousel-caption"> 
					<div> 
						<h2 class="heading animated bounceInRight">출퇴근시간 저렴하고 편리하게</h2> 
						<p class="animated bounceInLeft">Carpooling</p> 
						<a class="btn btn-default slider-btn animated bounceInUp" href="#">Get Started</a> 
					</div> 
				</div> 
			</div>
		</div><!--/.carousel-inner-->

		<a class="carousel-left member-carousel-control hidden-xs" href="#main-carousel" data-slide="prev">&lt;</a>
		<a class="carousel-right member-carousel-control hidden-xs" href="#main-carousel" data-slide="next">&gt;</a>
	</div> 
	<!-- <script type="text/javascript" src="./resources/bootstrap-js/jquery.js"></script> 
	<script type="text/javascript" src="./resources/bootstrap-js/bootstrap.min.js"></script>
	<script type="text/javascript" src="./resources/bootstrap-js/smoothscroll.js"></script> 
	<script type="text/javascript" src="./resources/bootstrap-js/jquery.isotope.min.js"></script>
	<script type="text/javascript" src="./resources/bootstrap-js/jquery.prettyPhoto.js"></script> 
	<script type="text/javascript" src="./resources/bootstrap-js/jquery.parallax.js"></script> 
	<script type="text/javascript" src="./resources/bootstrap-js/main.js"></script>  -->
</section><!--/#home-->
<jsp:include page="../include/footer.jsp"></jsp:include>
</body>
</html>