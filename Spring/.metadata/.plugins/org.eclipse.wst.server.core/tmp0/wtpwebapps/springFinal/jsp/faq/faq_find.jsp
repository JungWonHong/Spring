<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="ko">
<head>
<title>FAQ SEARCH</title>
<link rel="stylesheet" href="./resources/css/admin.css" type="text/css">
<link rel="stylesheet" href="./resources/css/qa.css" type="text/css">
<link rel="stylesheet" href="./resources/css/list.css" type="text/css">
<script src="./resources/js/jfaqery-3.2.1.js"></script>
<script src="./resources/js/qa2.js"></script>
</head>
<body>
	<div id="qalist_wrap">
		<h2 id="qalist_title" style="width:200px">FAQ SEARCH</h2>
		<hr size="3" color="#B1EFED">
		<div id="qalist_c"
		style="border-radius: 10px; color: black; background-color: #B1EFED; border: 1px; width:100px">글 개수 : ${faqlistcount}</div>
		
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
			<c:set var="num" value="${faqlistcount-(faqpage-1)*10}" />

			<!-- 반복문 시작 -->
			<c:forEach var="b" items="${faqlist}">

				<tr align="center" valign="middle" bordercolor="#333333"
					onmouseover="this.style.background='#B1EFED'"
					onmouseleave="this.style.background=''">
					<td height="23" class="ten">
						<!-- 번호 출력 부분 --> <c:out value="${num}" /> <c:set var="num"
							value="${num-1}" />
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
							<a href="faq_cont.nhn?num=${b.faq_num}&page=${faqpage}&state=cont">
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

		<br>
		<form method="get" action="faq_find_ok.nhn"
			onsubmit="return faqfind_check()">
			<table align="center">
				<tr>
					<th><select name="faqfind_field" style="border-color: #B1EFED">
							<option value="faq_subject">제목</option>
							<option value="faq_content">내용</option>
					</select></th>
					<td><input name="faqfind_name" id="faqfind_name" size="18"
						class="input_box" /> <input type="submit" value="SEARCH"
						class="input_button"
						style="border-radius: 10px; color: black; background-color: #B1EFED; border: 1px">
					</td>
					<td><input type="button" value="BACK" class="input_button"
						style="border-radius: 10px; color: black; background-color: #B1EFED; border: 1px; width: 60px"
						onclick="location='faq_list.nhn?faqpage=1'"></td>
				</tr>
			</table>
		</form>
		<!-- </div> -->

		<div class="paging" style="align: center; margin-top: 20px">
			<c:if test="${faqpage <=1 }">
				<a class="direction" href="faq_find_ok.nhn?faqfind_name=${faqfind_name}&faqfind_field=${faqfind_field}">&lt</a>
			</c:if>

			<c:if test="${faqpage > 1 }">
				<a class="direction" href="faq_find_ok.nhn?faqpage=${faqpage-1}&faqfind_name=${faqfind_name}&faqfind_field=${faqfind_field}">&lt</a>
			</c:if>

			<c:forEach var="a" begin="${faqstartpage}" end="${faqendpage}">
				<c:if test="${a == faqpage }">
					<span class="number on">${a}</span>
				</c:if>
				<c:if test="${a != faqpage }">
					<a class="number" href="faq_find_ok.nhn?faqpage=${a}&faqfind_name=${faqfind_name}&faqfind_field=${faqfind_field}">${a}</a>
				</c:if>
			</c:forEach>

			<c:if test="${faqpage >= faqmaxpage }">
				<a class="direction">&gt</a> 
			</c:if>
			<c:if test="${faqpage < faqmaxpage }">
				<a class="direction" href="faq_find_ok.nhn?faqpage=${faqpage+1}&faqfind_name=${faqfind_name}&faqfind_field=${faqfind_field}">&gt</a>
			</c:if>
		</div>

		<!-- 검색 부분 -->
		<div id="faqfind">
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