<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/jsp/include/mypage_include.jsp"%>
<html>
<head>
<title>KHCC - 마이페이지</title>
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
<script src="./resources/js/member4.js"></script>
<script src="./resources/js/card.js"></script>
<style>
h3 {
	font-weight: bold;
}

.hr {
	border-width: 3px;
}
</style>
</head>
<body>
	<%@ include file="../include/menubar_login.jsp"%>
	<section id="about-us">
		<div class="container">
			<div class="text-center">
				<div>
					<h2 class="title-one">마이페이지</h2>
					<p>내 정보와 예약, 결제내역을 확인할 수 있습니다.</p>
				</div>
			</div>
			<div class="about-us">
				<div class="row">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#my" data-toggle="tab"><i
								class="fa fa-chain-broken"></i> 내 정보</a></li>
						<li><a href="#pay" data-toggle="tab"><i
								class="fa fa-users"></i> 결제 내역</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane fade in active" id="my">
							<div class="media">
								<div>
									<h3>기본 정보</h3>
									<table>
										<tr style="border: 3px">
											<th>이름</th>
											<td>${info.m_name}</td>
										</tr>
										<tr>
											<th>이메일</th>
											<td>${info.m_email}</td>
										</tr>
										<tr>
											<th>비밀번호</th>
											<td><input type="password" value="${info.m_password}"
												class="input_box" readOnly />
												
												
												<button class="btn btn-default" data-target="#pass_edit"
													data-toggle="modal">변경</button> <br />
												<div class="modal fade" id="pass_edit">
													<div class="modal-dialog">
														<div class="modal-content">
															<form method="post" action="pass_edit_ok.nhn"
																onsubmit="return pass_check()">
																<!-- header -->
																<div class="modal-header">
																	<h4 class="modal-title">비밀번호 변경</h4>
																</div>
																<!-- body -->
																<div class="modal-body">
																	<table>
																		<tr>
																			<th>새 비밀번호</th>
																			<td><input type="password" name="new_pass1"
																				id="new_pass1" class="input_box" size="20"
																				maxlength="20"></td>
																		</tr>
																		<tr>
																			<th>비밀번호 확인</th>
																			<td><input type="password" name="new_pass2"
																				id="new_pass2" class="input_box" size="20"
																				maxlength="20"></td>
																		</tr>
																	</table>
																</div>

																<!-- Footer -->
																<div class="modal-footer">
																	<input type="submit" class="btn btn-default" value="변경">
																	<button class="btn btn-default" data-dismiss="modal">닫기</button>
																</div>
															</form>
														</div>
													</div>
												</div></td>
										</tr>
										<tr>
											<th>휴대폰 번호</th>

											<td><input type="text" value="${info.m_phone}"
												class="input_box" readOnly />
												<button class="btn btn-default" data-target="#phone_edit"
													data-toggle="modal">변경</button>
												<div class="modal fade" id="phone_edit">
													<div class="modal-dialog">
														<div class="modal-content">
															<form method="post" action="phone_edit_ok.nhn"
																onsubmit="return phone_check()">
																<!-- header -->
																<div class="modal-header">
																	<h4 class="modal-title">휴대폰번호 변경</h4>
																</div>
																<!-- body -->
																<div class="modal-body">
																	<table>
																		<tr>
																			<th>새 휴대폰번호</th>
																			<td><select name="new_phone1">
																					<c:forEach var="p" items="${phone}">
																						<option value="${p}">${p}</option>
																					</c:forEach>
																			</select> - <input name="new_phone2" id="new_phone2" size="4"
																				maxlength="4" class="input_box"> - <input
																				name="new_phone3" id="new_phone3" size="4"
																				maxlength="4" class="input_box"></td>
																		</tr>
																	</table>
																</div>

																<!-- Footer -->
																<div class="modal-footer">
																	<input type="submit" class="btn btn-default" value="변경">
																	<button class="btn btn-default" data-dismiss="modal">닫기</button>
																</div>
															</form>
														</div>
													</div>
												</div>
										</tr>
										<tr>
											<th>주소</th>
											<c:if test="${empty info.m_zipcode}">
												<td>
													<form method="post" action="addr_reg_ok.nhn">
														<input type="text" id="sample3_postcode"
															name="sample3_postcode" placeholder="우편번호" size="8"
															readOnly> <input type="button"
															onclick="sample3_execDaumPostcode()"
															class="btn btn-default" value="우편번호 찾기">
														<div id="wrap"
															style="display: none; border: 1px solid; width: 500px; height: 300px; margin: 5px 0; position: relative">
															<img
																src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png"
																id="btnFoldWrap"
																style="cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 1"
																onclick="foldDaumPostcode()" alt="접기 버튼">
														</div>	
														<br>

														<input type="text" id="sample3_address"
															name="sample3_address" class="d_form large"
															placeholder="주소" size="70" readOnly> <br> <input
															type="text" id="sample3_address2" name="sample3_address2"
															class="d_form large" size="70" placeholder="상세 주소">
														<input type="submit" id="addr_reg" class="btn btn-default"
															value="등록">

													</form>
												</td>
											</c:if>
											<c:if test="${!empty info.m_zipcode}">
												<td colspan=2>
													<form method="post" action="addr_reg_ok.nhn"
														onsubmit="return addr_edit_check()">
														<input type="text" class="input_box"
															value="${info.m_zipcode}" name="sample3_postcode"
															id="sample3_postcode" size="8" readOnly> <input
															type="button" onclick="sample3_execDaumPostcode()"
															class="btn btn-default" value="우편번호">


														<div id="wrap"
															style="display: none; border: 1px solid; width: 500px; height: 300px; margin: 5px 0; position: relative">
															<img
																src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png"
																id="btnFoldWrap"
																style="cursor: pointer; position: absolute; right: 0px; top: -1px; z-index: 1"
																onclick="foldDaumPostcode()" alt="접기 버튼">
														</div>
														<br> <input type="text" class="input_box"
															value="${info.m_addr1}" id="sample3_address"
															name="sample3_address" size=70 readOnly /><br> <input
															type="text" value="${info.m_addr2}" id="sample3_address2"
															name="sample3_address2" class="input_box" size=70 /> <input
															type="submit" id="addr_reg" class="btn btn-default"
															value="등록">
													</form>
												</td>
											</c:if>
										</tr>
									</table>
									<hr class=hr>
									<h3>면허 정보</h3>
									<c:if test="${empty info.m_drivercode}">
										<form method="post" action="drivercode.nhn"
											onsubmit="return dcode_check()">
											<table>
												<tr>
													<td>면허 번호</td>
													<td><select name="m_drivercode1" id="m_drivercode1">
															<c:forEach var="ln" items="${licenceNum}">
																<option value="${ln}">${ln}</option>
															</c:forEach>
													</select> - <input name="m_drivercode2" id="m_drivercode2" size="3"
														maxlength="2" class="input_box"> - <input
														name="m_drivercode3" id="m_drivercode3" size="7"
														maxlength="6" class="input_box"> - <input
														name="m_drivercode4" id="m_drivercode4" size="4"
														maxlength="3" class="input_box"> <input
														type="submit" class="btn btn-default" value="등록">
													</td>
												</tr>
											</table>
										</form>

									</c:if>
									<c:if test="${!empty info.m_drivercode}">
										<table>
											<tr>
												<td>면허 번호</td>
												<td><input value="${d1}" size="2" maxlength="2"
													class="input_box" readOnly> - <input value="${d2}"
													size="2" maxlength="2" class="input_box" readOnly>
													- <input value="${d3}" size="6" maxlength="6"
													class="input_box" readOnly> - <input value="${d4}"
													size="3" maxlength="3" class="input_box" readOnly>
												</td>
											</tr>
										</table>
									</c:if>
									<hr class=hr>
									<div>
									<h3>결제 카드</h3>
										<button class="btn btn-default" data-target="#addcard"
											data-toggle="modal">+ 카드 등록</button>
										<br>
										<div class="modal fade" id="addcard">
											<div class="modal-dialog">
												<div class="modal-content">
												<form method="post" action="card_reg_ok.nhn"
																onsubmit="return card_check()">
													<!-- header -->
													<div class="modal-header">
														<h4 class="modal-title">카드 등록</h4>
													</div>
													<!-- body -->
													<div class="modal-body">
														<table>
															<tr>
																<th>카드 이름</th>
																<td><input type="text" name="cardName"
																	id="cardName" class="input_box" size="8" maxlength="10"></td>
															</tr>
															<tr>
																<th>카드번호</th>
																<td><input type="text" name="cardNum1"
																	id="cardNum1" class="input_box" size="4" maxlength="4">
																	- <input type="text" name="cardNum2" id="cardNum2"
																	class="input_box" size="4" maxlength="4"> - <input
																	type="password" name="cardNum3" id="cardNum3"
																	class="input_box" size="4" maxlength="4"> - <input
																	type="text" name="cardNum4" id="cardNum4"
																	class="input_box" size="4" maxlength="4"></td>
															</tr>
															<tr>
																<th>유효기간</th>
																<td><select name="expiryMonth" id="expiryMonth">
																		<c:forEach var="em" items="${expiryMonth}">
																			<option value="${em}">${em}</option>
																		</c:forEach>
																</select> <select name="expiryYear" id="expiryYear">
																		<c:forEach var="ey" items="${expiryYear}">
																			<option value="${ey}">${ey}</option>
																		</c:forEach>
																</select></td>
															</tr>
															<tr>
																<th>생년 월일</th>
																<td><input type="text" id="cardbirth"
																	name="cardbirth" size=8 maxlength=6
																	placeholder="6자리 입력"></td>
															</tr>
															<tr>
																<th>비밀번호</th>
																<td><input type="text" id="cardpass"
																	name="cardpass" size=5 maxlength=2
																	placeholder="앞 2자리">**</td>
															</tr>
														</table>
													</div>

													<!-- Footer -->
													<div class="modal-footer">
														<button type="submit" class="btn btn-default"
															name="addcard" id="addcard">등록</button>
														<button type="button" class="btn btn-default"
															data-dismiss="modal">닫기</button>
													</div>
													</form>
												</div>
											</div>
										</div>
									</div>
									<c:if test="${!empty c_name}">
									<div>
									<form action = "card_delete.nhn" method="post">
										카드 이름<input value="${c_name}" name="c_name" size="8" class="input_box" readOnly>
										카드 번호<input value="${c1}" name="c1" size="4" class="input_box" readOnly> - 
											<input value="${c2}" name="c2" size="4" class="input_box" readOnly> - 
											<input value="${c3}" name="c3" size="4" class="input_box" readOnly> - 
											<input value="${c4}" name="c4" size="4" class="input_box" readOnly>
										유효기간<input value="${c_expdate}" name="c_expdate" size="8" class="input_box" readOnly>
										<input type="submit" value="카드 삭제" class="btn btn-default">
									</form>
									</div>
									</c:if>
									<hr class=hr>
									<h3>회원 탈퇴</h3>
									<div>
										이용하시는데 불편함이 있으셨나요?<br> 이용 불편 및 문의사항은 고객센터 1:1문의에 남겨주시면
										답변드리겠습니다.
									</div>
									<div>
										<input type="button" value="회원 탈퇴" class="btn btn-default"
											onclick="location='member_delete.nhn'">
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="pay">
							<div class="media">
								<div class="media-body">
									<h3>결제 내역</h3>
									<div>
										<table>
											<tr>
												<th>결제일</th>
												<th>내역</th>
												<th>결제수단</th>
												<th>금액</th>
											</tr>
											<c:if test="${!empty pay}">
											<c:forEach var="p" items="${pay}">
											<tr>
												<td>
													<input type="text"value="${p.settle_day}" readOnly/>
												</td>
												<td>
													<input type="text"value="${p.c_place}" readOnly/>
												</td>
												<td>
													<input type="text"value="${card.c_name}" readOnly/>
												</td>
												<td>
													<input type="text" value="${p.tot_price}원" readOnly/>
												</td>
											</tr>
											</c:forEach>
											</c:if>
										</table>
									</div>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--/#about-us-->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
		// 우편번호 찾기 찾기 화면을 넣을 element
		var element_wrap = document.getElementById('wrap');

		function foldDaumPostcode() {
			// iframe을 넣은 element를 안보이게 한다.
			element_wrap.style.display = 'none';
		}

		function sample3_execDaumPostcode() {
			// 현재 scroll 위치를 저장해놓는다.
			var currentScroll = Math.max(document.body.scrollTop,
					document.documentElement.scrollTop);
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var fullAddr = data.address; // 최종 주소 변수
							var extraAddr = ''; // 조합형 주소 변수

							// 기본 주소가 도로명 타입일때 조합한다.
							if (data.addressType === 'R') {
								//법정동명이 있을 경우 추가한다.
								if (data.bname !== '') {
									extraAddr += data.bname;
								}
								// 건물명이 있을 경우 추가한다.
								if (data.buildingName !== '') {
									extraAddr += (extraAddr !== '' ? ', '
											+ data.buildingName
											: data.buildingName);
								}
								// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
								fullAddr += (extraAddr !== '' ? ' ('
										+ extraAddr + ')' : '');
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('sample3_postcode').value = data.zonecode; //5자리 새우편번호 사용
							document.getElementById('sample3_address').value = fullAddr;

							// iframe을 넣은 element를 안보이게 한다.
							// (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
							element_wrap.style.display = 'none';

							// 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
							document.body.scrollTop = currentScroll;
						},
						// 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
						onresize : function(size) {
							element_wrap.style.height = size.height + 'px';
						},
						width : '100%',
						height : '100%'
					}).embed(element_wrap);

			// iframe을 넣은 element를 보이게 한다.
			element_wrap.style.display = 'block';
		}
	</script>
pa.</body>
</html>