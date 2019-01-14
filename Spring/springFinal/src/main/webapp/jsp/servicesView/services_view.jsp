<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KHCC - 서비스 안내</title>
<script src="./resources/js/jquery-3.2.1.js"></script>

<script>
	$(document).ready(function() {
		$('#show1').hide();
		$('#show2').hide();
		$("#show3").hide();

		$(".menu1").click(function() {
			$("#show1").hide();
			$("#show2").hide();
			$("#show3").hide();
			$("#txt").show();
		});

		$(".menu2").click(function() {
			$("#txt").hide();
			$("#show2").hide();
			$("#show3").hide();
			$("#show1").show();
		});

		$(".menu3").click(function() {
			$("#txt").hide();
			$("#show1").hide();
			$("#show3").hide();
			$("#show2").show();
		});

		$(".menu4").click(function() {
			$("#txt").hide();
			$("#show1").hide();
			$("#show2").hide();
			$("#show3").show();
		});
	});
</script>

<style>
.menu {
	font-size: 15pt;
	margin-top: -5%;
	margin-left: -5%;
	padding: 10%;
	font-family: roboto;
	font-weight: bold;
	color: black;
	list-style: none;
	line-height: 300%;
	cursor: pointer
}

.menu1:hover {
	color: #2ABCB4;
}

.menu2:hover {
	color: #2ABCB4;
}

.menu3:hover {
	color: #2ABCB4;
}

.menu4:hover {
	color: #2ABCB4;
}

#tp {
	margin-top: 5%;
	margin-left: 20%;
	font-family: roboto;
	font-weight: bold;
}

#kh {
	font-size: 30pt;
}

#kh1 {
	font-size: 30pt;
	color: #2ABCB4;
	margin-top: -1%
}

#c {
	margin-top: -27%;
	margin-left: 30%;
}

#c1 {
	font-size: 23pt;
	font-weight: bold;
}

#c1font {
	font-size: 13pt;
}

#ic1, #ic2, #ic3, #ic4 {
	font-size: 15pt;
	font-weight: bold;
}

#img1 {
	width: 500px;
	height: 400px;
	margin-left: 53%;
	margin-top: -16%
}

#total {
	border: 2px solid lightgray;
	margin-left: 20%;
	width: 65%;
	height: 1300px
}

#img2 {
	width: 150px;
	height: 150px;
	margin-left: 26.5%;
	margin-top: 10%;
}

#ic1 {
	margin-top: -10%;
	margin-left: 41%;
}

#ic11 {
	margin-top: 1%;
	margin-left: 41%
}

#img3 {
	margin-top: 5%;
	margin-left: 26%;
	width: 150px;
	height: 150px
}

#ic2 {
	margin-left: 41%;
	margin-top: -10%;
}

#ic22 {
	margin-left: 41%;
	margin-top: 1%;
}

#img4 {
	margin-top: 5%;
	margin-left: 26%;
	width: 150px;
	height: 150px
}

#ic3 {
	margin-left: 41%;
	margin-top: -10%;
}

#ic33 {
	margin-left: 41%;
	margin-top: 0%;
}

#img5 {
	margin-top: 10%;
	margin-left: 26%;
	width: 150px;
	height: 150px
}

#ic4 {
	margin-left: 41%;
	margin-top: -11%;
}

#ic44 {
	margin-left: 41%;
	margin-top: 1%;
}

#show1 {
	margin-left: 41%;
	margin-top: -30%
}

#imga {
	margin-left: 25%;
	margin-top: -20%;
	width: 850px;
}

#c11 {
	font-size: 23pt;
	font-weight: bold;
	margin-top: -105%;
	margin-left: -3%
}

#img6 {
	margin-top: 5%;
	margin-left: -3%
}

#i1 {
	margin-top: -49.5%;
	margin-left: 5%;
}

#i2 {
	margin-top: 3.5%;
	margin-left: 5%;
}

#i3 {
	margin-top: 2.3%;
	margin-left: 5%;
}

#i4 {
	margin-top: 3.5%;
	margin-left: 5%;
}

#i5 {
	margin-top: 2.6%;
	margin-left: 5%;
}

#i6 {
	margin-top: 3.6%;
	margin-left: 5%;
}

#it1, #it2, #it3, #it4, #it5 {
	font-size: 13pt;
	font-weight: bold;
}

#img7 {
	margin-top: 5%;
	margin-left: -10%;
	width: 150px;
	height: 150px
}

#p2 {
	font-size: 13pt;
	font-weight: bold;
	margin-top: -10%;
	margin-left: 10%
}

#pf {
	font-size: 18pt;
	color: red
}

#g1 {
	font-size: 23pt;
	font-weight: bold;
	margin-top: -62%;
	margin-left: 39%
}

#g2 {
	margin-top: 2%;
	margin-left: 39%
}

#gt {
	font-size: 13pt;
	font-weight: bold;
}

#g3 {
	margin-top: 3%;
	margin-left: 39%
}

#gt1 {
	font-size: 15pt;
	font-weight: bold;
}

#gt2 {
	font-size: 15pt;
	font-weight: bold;
	color: #2ABCB4;
}

#img8, #img9, #img10, #img11 {
	width: 200px;
	height: 150px
}

#gt3 {
	font-size: 15pt;
	font-weight: bold;
}

#gt33 {
	font-size: 12pt;
}

#gt4 {
	font-size: 15pt;
	font-weight: bold;
}

#gt44 {
	font-size: 12pt;
}

#gt4all {
	margin-left: 42%;
	margin-top: -11%
}

#img12 {
	width: 200px;
	height: 200px;
	margin-left: 40%;
}

#img13 {
	width: 200px;
	height: 200px
}

#gt5 {
	font-size: 12pt;
	font-weight: bold;
	margin-left: 53%;
	margin-top: -8%
}

#gt6 {
	font-size: 14pt;
	font-weight: bold;
	margin-left: 57%;
	color: #2ABCB4;
}

#im1all {
	border: 2px solid lightgray;
	width: 810px;
	height: 300px;
	margin-left: 39%
}

#img14 {
	width: 100px;
	margin-left: 3%;
	margin-top: 6%
}

#im {
	margin-left: 15%;
	margin-top: -15%;
}

#im1 {
	font-size: 12pt;
	font-weight: bold;
}

#im2 {
	font-size: 9pt;
}

#im2all {
	border: 2px solid lightgray;
	width: 810px;
	height: 350px;
	margin-left: 39%;
	margin-top: 0.5%
}

#img15 {
	width: 100px;
	margin-left: 1%;
	margin-top: 6%
}

#im22 {
	margin-left: 15%;
	margin-top: -15%;
}

#imm2 {
	font-size: 12pt;
	font-weight: bold;
}

#im21 {
	font-size: 9pt;
}

#img16 {
	margin-left: 38%;
	width: 800px;
	height: 350px
}
</style>
</head>
<body>
	<c:if test="${!empty login_email}">
		<%@ include file="../include/menubar_login.jsp"%>
	</c:if>

	<c:if test="${empty login_email}">
		<%@ include file="../include/menubar_nologin.jsp"%>
	</c:if>
	<div id="tp" style="margin-top:8%">
		<h3>KHCC의 모든 것</h3>
		<br>
		<p id="kh">합리적이고 편리한</p>
		<p id="kh1">카쉐어링, 카풀 서비스!</p>
		<br>
		<p>
			카쉐어링은 차가 필요할 때 근처에 있는 공유차량을 <br> 필요한 시간만큼 빌릴수 있는 자동차 공유 서비스 입니다.
			<br> 카풀 서비스는 라이더가 원하는 거리,시간을 신청하여 이용하는 서비스입니다.
		</p>


	</div>
	<img src="./resources/images/car.png" id="img1" />

	<div id="total">


		<ul class="menu">
			<li class="menu1">KHCC 이용방법</li>
			<li class="menu2">KHCC 이용규칙</li>
			<li class="menu3">KHCC 가이드</li>
			<li class="menu4">KHCC 임팩트</li>
		</ul>


		<div id="txt">
			<img src="./resources/images/khmenu.png" id="imga" />
			<div id="c">
				<p id="c1">KHCC 이용방법</p>
				<br>
				<p id="c1font">
					가입에서 이용방법까지 간편하게 이용할 수 있는 편리하고 경제적인 KHCC의 이용방법을 알려드립니다. <br>
					KHCC와 함께 스마트 카쉐어링&카풀을 경험해보세요!
				</p>

			</div>


			<img src="./resources/images/member1.JPG" id="img2" />
			<p id="ic1">회원가입</p>
			<p id="ic11">
				KHCC는 신뢰를 기반으로 한 회원제 서비스입니다.<br> 카풀서비스는 운전면허등록 시 드라이버 고객, 미 선택
				시 라이더 고객으로 이용이 가능합니다.
			</p>

			<img src="./resources/images/member2.JPG" id="img3" />
			<p id="ic2">차량 예약</p>
			<p id="ic22">
				카풀 서비스는 카풀신청, 카쉐어링은 카쉐어링 신청을 해야 예약가능합니다.<br> 예약완료 후 마이페이지를 통해
				예약정보를 볼 수 있습니다.
			</p>



			<img src="./resources/images/member3.JPG" id="img4" />
			<p id="ic3">차량 반납</p>
			<p id="ic33">반납 시간에 맞추어 차량을 반납 장소에 주차하시면 됩니다.</p>



			<img src="./resources/images/member4.JPG" id="img5" />
			<p id="ic4">요금 결제</p>
			<p id="ic44">
				차량 이용에 따른 요금은 대여료와 주행요금으로 구분되며, 가입시 등록한 결제카드로 청구됩니다. <br> 결제가
				완료되지 않으면 차량 사용에 제한이 있을 수 있으니, 미리 결제카드의 유효여부를 확인해주세요.
			</p>


		</div>
	</div>

	<!-- 이용 규칙 -->
	<div id="show1">
		<p id="c11">KHCC 이용규칙</p>
		<img src="./resources/images/rule.png" id="img6" />

		<div id="i1">
			<span id="it1">이용 후 대여한 존으로 반납 필수!</span>
			<p>
				편도 이용을 제외한 모든 차량 반납은 대여한 존으로 하셔야 합니다. <br> 만약 다른 차량이 주차되어 있거나
				부득이한 사정이 생기신 경우는 고객센터로 연락주세요.
			</p>
		</div>

		<div id="i2">
			<span id="it1">반납시간을 꼭 준수해주세요!</span>
			<p>
				다음 사용자를 위해 반납시간을 꼭 지켜주세요. <br> 반납이 늦어지는 경우 페널티 또는 경고조치를 받을 수
				있습니다.
			</p>
		</div>


		<div id="i3">
			<span id="it1">연료가 50%이상 남아있는지 확인해주세요!</span>
			<p>
				다음 사용자를 위해 연료가 충분히 남았는지 확인해주세요. <br> 모든 주유소에서 주유가 가능하며, 결제는 차량
				내부에 비치된 주유카드로 진행하시면 됩니다.
			</p>
		</div>



		<div id="i4">
			<span id="it1">KHCC에서 흡연은 꼭 참아주세요!</span>
			<P>
				함께 사용하는 분들을 위해 KHCC를 이용하는 동안 흡연은 꼭 참아주세요! <br> 이용 후에는 차량 내부에 있는
				쓰레기를 정리해 주시기 바랍니다.
			</P>
		</div>


		<div id="i5">
			<span id="it1">문제가 생긴 경우 고객센터로 즉시 연락주세요!</span>
			<p>
				예약한 차량에 사고 흔적이 있거나 이용 중 사고 및 기타 문제로 인해 긴급출동이 필요한 경우에는 신속하게 <br>
				고객센터로 상황을 알려주시기 바랍니다.
			</p>
		</div>

		<div id="i6">
			<span id="it1">애완동물은 캐리어를 이용해주세요! </span>
			<p>
				애완동물은 캐리어를 이용하여 동반 탑승하실 수 있습니다. <br> 단, 장애인 반려견은 캐리어 없이도 탑승
				가능합니다.
			</p>
		</div>
		<!-- 패널티 규정-->
		<img src="./resources/images/report.png" id="img7" />

		<div id="p2">
			이용규칙을 어기거나<br> 회원님들의<span id="pf">신고하기</span>를 통해 관리자가 패널티를 부여하게
			됩니다. <br> 패널티 3회시 강제탈퇴처리가 되니 주의하시기 바랍니다.
		</div>

	</div>


	<!-- KHCC 가이드 -->
	<div id="show2">
		<p id="g1">KHCC가이드</p>

		<div id="g2">
			<span id="gt">KHCC는 차를 소유하는 사람보다 공유하는 사람들이 훨씬 더 많아지는 날을 꿈꿉니다!
			</span><br>
			<br> 물론 공유는 소유보다 불편할 때도 있습니다. 타인과 무엇을 나눠 쓴다는 것이 쉽지만은 않지요. <br>
			하지만 KHCC는 이러한 불편과 거북함을 최소화시키기 위해 끊임없이 고민하려고 합니다. <br> 개인의 재화로
			인식되었던 자동차를 사회적 재화로 바꾸고, 전체적인 사회적 비용을 낮추어 지역사회에 재투자되도록 노력하겠습니다. <br>
			이용자의 편의를 최우선으로 합리적인 소비문화를 이끌어낼 수 있도록 노력하겠습니다.
		</div>

		<div id="g3">
			<span id="gt1">KHCC회원이 되시면</span> <br>
			<span id="gt2">KHCC에서 편리한 서비스를 이용하실 수 있습니다.</span> <br>
			<br> <img src="./resources/images/driver.jpg" id="img8" /> <img
				src="./resources/images/driver2.jpg" id="img9" /> <img
				src="./resources/images/driverg3.jpg" id="img10" /> <img
				src="./resources/images/driver4.jpg" id="img11" />
			<p id="gt3">카 쉐어링</p>
			<ul id="gt33">
				<li>기존에 있던 카쉐어링보다 분단위 서비스로 인하여 유용함</li>
				<li>원하는 차종을 선택하여 이용하는 만족감</li>
				<li>믿고 결제할 수 있는 신뢰</li>
				<li>급하게 필요할 때 쉽게 접할 수 있는 접근성</li>
			</ul>

			<div id=gt4all>
				<p id="gt4">카풀</p>
				<ul id="gt44">
					<li>믿고 이용할 수 있는 보안시스템</li>
					<li>간편하고 편리한 이용시스템</li>
					<li>빠르게 이용할 수 있는 이용성</li>
					<li>택시 대신 빠른 차량 서비스</li>
				</ul>
			</div>
		</div>
		<br>
		<br>
		<br> <img src="./resources/images/carp.jpg" id="img12" />
		<div id="gt5">자동차 폐차로 인해 비용,환경에 대해 조금은 개선할 수 있는 생각을</div>
		<br>
		<div id="gt6">KHCC에서는 환경에 대해 생각합니다</div>

	</div>


	<!-- KHCC 임팩트 -->
	<div id=show3>
		<p id="g1">KHCC임팩트</p>
		<div id="g2">
			<span id="gt">KHCC는 긍정적인 사회/환경적 영향을 고려하는 비즈니스 활동을 지향합니다.</span> <br>
			합리적이고 대안적인 이동수단으로서 카쉐어링, 카풀 서비스를 제공하여, <br> 이로 인한 다양한 사회/환경적
			파급효과를 지속적으로 관찰합니다.
		</div>
		<br> <br>
		<div id="im1all">
			<img src="./resources/images/carrs.jpg" id="img14" />

			<div id="im">
				<p id="im1">KHCC는 B Corp을 통해 기업의 사회/환경적 책임에 관한 글로벌 기준을 준수하고자
					합니다.</p>
				KHCC는 자원의 효율적 활용을 통해/환경적 문제를 효과적으로 헤결한다는 점에서 <br> 글로벌 인증을
				획득했으며, 투명한 경영, 건강한 근로 환경 구축을 통해 지역사회 안에서 지속 가능하고<br> 긍정적인 영향을
				끼칠 수 있는 기업문화를 확산해가고자 합니다. <br> <br>
				<p id="im1">카쉐어링,카풀 분야에서 세계 최초로 B corp</p>
				<span id="im2">글로버 사회적 기업 인증인 B Corp은 이윤 창출을 넘어 사회 환경적 임팩트를
					추구하는 'Benefit Corporation'을 의미합니다.</span>
			</div>
		</div>

		<div id="im2all">
			<img src="./resources/images/carb.jpg" id="img15" />

			<div id="im22">
				<p id="imm2">KHCC는 고객의 관점에서 서비스 가치를 극대화하기 위해 노력합니다.</p>
				KHCC는 회원들의 즐거운 KHCC 라이프를 위하여, 안전을 최우선으로 서비스 만족을 위해 소비자중심경영 활동을 <br>
				수행하고 있습니다. 고객 목소리에 귀 기울여 더 나은 서비스 제공을 위해 노력하고, 더욱 믿고 이용할 수 있는<br>
				카쉐어링, 카풀 서비스가 되고자 합니다. <br> <br>
				<p id="imm2">KHCC,카쉐어링 분야 CCM</p>
				<span id="im21">소비자중심경영(CCM)은 기업이 수행하는 모든 활동을 소비자 관점에서, 소비자
					중심으로 구성하고 관련 경영활동을<br> 지속적으로 개선하고 있는지를 한국소비자원에서 평가하고, 공정거래위원회가
					인증해주는 국가인증제도 입니다.
				</span>
			</div>
		</div>

		<img src="./resources/images/sun.jpg" id="img16" />
	</div>
</body>
</html>