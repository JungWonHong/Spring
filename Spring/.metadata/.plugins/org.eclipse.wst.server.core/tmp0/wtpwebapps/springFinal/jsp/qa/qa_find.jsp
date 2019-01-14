<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="ko">
<head>
<title>REVIEW SEARCH</title>
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_4.js"></script>

<style>
#qalist_t{ margin-left:18%; width:1300px;}
#qalist_c{font-size:15pt; margin-left:20%}
.qafind_td1,.qafind_td5{	
   width: 100px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
	text-align:center}
.qafind_td2{width: 400px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
	text-align:center}
.qafind_td3,.qafind_td4{
   width: 100px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
	text-align:center}
.qafind_td_t1,.qafind_td_t5{   width: 100px;
	height: 50px;
	border-bottom: 2px solid #F2EFEF;
	font-size: 15pt;
	text-align:center}
.qafind_td_t2{width: 400px;
	height: 50px;
	border-bottom: 2px solid #F2EFEF;
	font-size: 15pt;
	text-align:center}
.qafind_td_t3,.qafind_td_t4{width: 100px;
	height: 50px;
	border-bottom: 2px solid #F2EFEF;
	font-size: 15pt;
	text-align:center}
</style>
</head>
<body>
	<div id="qalist_wrap">
	

		<div id="qalist_c">글 개수 : ${listcount}</div>
		
		<table id="qalist_t">
			<tr>
				<td class="qafind_td1">
					<div>No.</div>
				</td>
				<td class="qafind_td2">
					<div>TITLE</div>
				</td>
				<td class="qafind_td3">
					<div>ID</div>
				</td>
				<td class="qafind_td4">
					<div>DATE</div>
				</td>
				<td class="qafind_td5">
					<div>VIEW</div>
				</td>
			</tr>

			<!-- 화면 출력 번호  변수 정의 -->
			<c:set var="num" value="${listcount-(page-1)*10}" />

			<!-- 반복문 시작 -->
			<c:forEach var="b" items="${qalist}">

				<tr
					onmouseover="this.style.background='#B1EFED'"
					onmouseout="this.style.background=''">
					<td class="qafind_td_t1">
						<!-- 번호 출력 부분 --> <c:out value="${num}" /> <c:set var="num"
							value="${num-1}" />
					</td>

					<td class="qafind_td_t2">
						<div>
							<!-- 답글인 경우 -->
							<c:if test="${b.qa_re_lev != 0}">
								<c:forEach var="k" begin="1" end="${b.qa_re_lev}">
						&nbsp;&nbsp;			
					</c:forEach>
								<img src="./resources/images/AnswerLine.png">
							</c:if>

							<!-- 제목 출력 부분 -->
							<a href="#" class="scanview">
								${b.qa_subject} </a><input type="hidden" value="${b.qa_num}" id="num">
						</div>
					</td>

					<td class="qafind_td_t3">
						<div>${b.qa_name}</div>
					</td>
					<td class="qafind_td_t4">
						<div><c:set var="TextValue" value="${b.qa_date}"/>
						${fn:substring(TextValue,0,16)}</div>
					</td>
					<td class="qafind_td_t5">
						<div>${b.qa_readcount}</div>
					</td>
				</tr>

			</c:forEach>
			<!-- 반복문 끝 -->
		</table>


		<!-- </div> -->

		<div class="paging" style="align: center; margin-top: 20px">
			<c:if test="${page <=1 }">
				<a class="direction" href="qa_find_ok.nhn?find_name=${find_name}&find_field=${find_field}">&lt</a>
			</c:if>

			<c:if test="${page > 1 }">
				<a class="direction" href="qa_find_ok.nhn?page=${page-1}&find_name=${find_name}&find_field=${find_field}">&lt</a>
			</c:if>

			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					<span class="number on">${a}</span>
				</c:if>
				<c:if test="${a != page }">
					<a class="number" href="qa_find_ok.nhn?page=${a}&find_name=${find_name}&find_field=${find_field}">${a}</a>
				</c:if>
			</c:forEach>

			<c:if test="${page >= maxpage }">
				<a class="direction">&gt</a> 
			</c:if>
			<c:if test="${page < maxpage }">
				<a class="direction" href="qa_find_ok.nhn?page=${page+1}&find_name=${find_name}&find_field=${find_field}">&gt</a>
			</c:if>
		</div>

		<!-- <div id="qalist_w">
			<input type="button" value="REVIEW 등록" class="input_button"
				style="border-radius: 10px; color: black; background-color: #B1EFED; border: 1px; width: 300px"
				onclick="write_window()">
		</div> -->

		<!-- 검색 부분 -->
		<div id="qafind">
			<script>
				function find_check() {
					if ($.trim($("#find_name").val()) == "") {
						alert("검색내용을 입력하세요!");
						$("#find_name").val("").focus();
						return false;
					}
				}
			</script>
		</div>
	</div>
</body>
</html>