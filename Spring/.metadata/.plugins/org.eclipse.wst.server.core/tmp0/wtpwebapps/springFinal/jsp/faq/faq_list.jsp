<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="ko">
<head>
<title>고객센터</title>
<link rel="stylesheet" href="./resources/css/admin.css" type="text/css">
<link rel="stylesheet" href="./resources/css/qa.css" type="text/css">
<link rel="stylesheet" href="./resources/css/list.css" type="text/css">
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2.js"></script>
</head>
<body>
<input type="hidden" name="login_email" id="login_email" value="${login_email}"/>
<c:if test="${login_email == null}">
<%@ include file = "../include/menubar_nologin.jsp" %>
</c:if>
<c:if test="${login_email != null}">
<%@ include file = "../include/menubar_login.jsp" %>
</c:if>
	<div id="qalist_wrap">
		<span style="float:right">
		<h2 id="qalist_title" onclick="location='qa_list.nhn?page=1'" >REVIEW</h2>
		</span>
		<span>
		<h2 id="qalist_title" style="width:200px"
		onclick="location='faq_list.nhn?page=1'" >고객센터_FAQ</h2>
		</span>
		<hr size="3" color="#B1EFED">
		<form method="get" action="faq_find_ok.nhn"
			onsubmit="return faqfind_check()">
			<table align="center">
				<tr>
					<th><select name="faqfind_field" style="border-color: #B1EFED">
							<option value="faq_subject">제목</option>
							<option value="faq_content">내용</option>
					</select></th>
					<td><input name="faqfind_name" id="faqfind_name" size="45"
						class="input_box" /> <input type="submit" value="SEARCH"
						class="input_button"
						style="border-radius: 10px; color: black; background-color: #B1EFED; border: 1px;">
					</td>
					<c:if test="${login_email eq 'admin@khcc.com'}">
					<div id="qalist_w">
						<input type="button" value="FAQ 등록(관리자 전용)" class="input_button"
							style="border-radius: 10px; color: black; background-color: #B1EFED; border: 1px; width: 319px; margin-right:2%"
							onclick="faqwrite_window()">
					</div>
					</c:if>
				</tr>
			</table>
		</form>
		
		<%-- <div id="qalist_wrap2"
			style="float: left; width: 30%; margin-left: 15px;"
			onclick="location='faq_notice.nhn?num=${qamax1.faq_num}&page=${ntpage}&state=cont'">
				<img src="./resources/images/khcc.png" height="80" width="239"
					style="border-radius: 20px; align: center; margin-top: 1px" />
		</div> --%>
		<div id="qalist_wrap2"
			style="float: left; width: 30%; margin-left: 15px;"
			onclick="location='nt_list.nhn?page=${ntpage}'">
				<img src="./resources/images/notice_c.png" height="80" width="239"
					style="border-radius: 18px; align: center; margin-top: 0.5px" />
		</div>
		&nbsp;
		<div id="qalist_wrap2"
			style="float: left; width: 30%; margin-left: 15px;"
			onclick="location='faq_list.nhn?page=${faqpage}'">
				<img src="./resources/images/faq_n.png" height="80" width="239"
					style="border-radius: 18px; align: center; margin-top: 0.5px" />
		</div>
		<!-- &nbsp; -->
		<div id="qalist_wrap2"
			style="float: left; width: 30%; margin-left: 15px;"
			onclick="location='qna_list.nhn?page=${qnapage}'">
				<img src="./resources/images/qna_c.png" height="80" width="239"
					style="border-radius: 18px; align: center; margin-top: 0.5px" />
			<br>
		</div>
		<br> <br> <br> <br> <br> <br>
		<hr size="3" color="#B1EFED">
		
		<table id="qalist_t">
			<tr align="center" valign="middle" bordercolor="#333333">
				<td class="eleven" width="20%" height="26">
					<div>No.</div>
				</td>
				<td class="eleven" width="65%">
					<div>TITLE</div>
				</td>
				<!-- <td class="eleven" width="20%">
					<div>ID</div>
				</td> -->
				<td class="eleven" width="25%">
					<div>DATE</div>
				</td>
				<!-- <td class="eleven" width="15%">
					<div>VIEW</div>
				</td> -->
			</tr>

			<!-- 화면 출력 번호  변수 정의 -->
			<c:set var="faqnum" value="${faqlistcount-(faqpage-1)*10}" />

			<!-- 반복문 시작 -->
			<c:forEach var="b" items="${faqlist}">

				<tr align="center" valign="middle" bordercolor="#333333"
					onmouseover="this.style.background='#B1EFED'"
					onmouseleave="this.style.background=''">
					<td height="23" class="ten">
						<!-- 번호 출력 부분 --> <c:out value="${faqnum}" /> <c:set var="faqnum"
							value="${faqnum-1}" />
					</td>

					<td class="ten">
						<div style="text-align: left">
							<!-- 답글인 경우 -->
							<c:if test="${b.faq_re_lev != 0}">
								<c:forEach var="k" begin="1" end="${b.faq_re_lev}">
						&nbsp;&nbsp;			
					</c:forEach>
								<img src="./resources/images/AnswerLine.png">
							</c:if>

							<!-- 제목 출력 부분 -->
							<a href="faq_cont.nhn?num=${b.faq_num}&faqpage=${faqpage}&state=cont">
								${b.faq_subject} </a>
						</div>
					</td>

					<%-- <td class="ten">
						<div>${b.faq_name}</div>
					</td> --%>
					<td class="ten">
						<div><c:set var="TextValue" value="${b.faq_date}"/>
						${fn:substring(TextValue,0,16)}</div>
					</td>
					<%-- <td class="ten">
						<div>${b.faq_readcount}</div>
					</td> --%>
				</tr>

			</c:forEach>
			<!-- 반복문 끝 -->
		</table>

		<!-- </div> -->
		<c:if test="${faqlistcount >= 1}">
		<div class="paging" style="align: center; margin-top: 20px">
			<c:if test="${faqpage <=1 }">
				<a class="direction" href="faq_list.nhn?faqpage=${faqpage}">&lt</a>
			</c:if>

			<c:if test="${faqpage > 1 }">
				<a class="direction" href="faq_list.nhn?faqpage=${faqpage-1}">&lt</a>
			</c:if>

			<c:forEach var="a" begin="${faqstartpage}" end="${faqendpage}">
				<c:if test="${a == faqpage }">
					<span class="number on">${a}</span>
				</c:if>
				<c:if test="${a != faqpage }">
					<a class="number" href="faq_list.nhn?faqpage=${a}">${a}</a>
				</c:if>
			</c:forEach>

			<c:if test="${faqpage >= faqmaxpage }">
				<span class="direction">&gt</span> 
			</c:if>
			<c:if test="${faqpage < faqmaxpage }">
				<a class="direction" href="faq_list.nhn?faqpage=${faqpage+1}">&gt</a>
			</c:if>
		</div>
		</c:if>

		<!-- 검색 부분 -->
		<div id="qafind">
			<script>
				function faqfind_check() {
					if ($.trim($("#faqfind_name").val()) == "") {
						alert("검색내용을 입력하세요!");
						$("#faqfind_name").val("").focus();
						return false;
					}
				}
			</script>
		</div>
	</div>
</body>
</html>