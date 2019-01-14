<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="ko">
<head>
<title>고객센터</title>

<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_4.js"></script>
<style>
.qna_searchdiv{	border: 2px solid #F2EFEF;
	width: 900px;
	height: 130px;
	margin-left: 37%;
	margin-top: 5%;
	background-color: #F2EFEF}
	
.qna_img{margin-top: 2.5%; margin-left: 2%}
#qnafind_field{	width: 8%; height: 40px;}
#qnafind_name{	height: 40px; width: 420px;}
.input_qnabutton{	width: 100px;
	height: 40px;
	background: #2ABCB4;
	color: white;
	border: 0px;}
.qna_searchdiv1{	margin-left: 30%;
	margin-top: -6.6%;
	width: 100%;
	height: 40px;}
.qna_button{	width: 900px;
	height: 40px;
	border: o;
	background: #2ABCB4;
	margin-left: 37%;
	color: white;
	font-size: 15pt;
	font-weight: bold}
.qnatd{	width: 250px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;}
	
.qnatd1{	width: 150px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;}

.qnatd2{	width: 450px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;}

.qnatd5{	width: 100px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;}

#qnaliststyle{	
   margin-left: 20.5%;
	margin-top: 10%;
	text-align: center}

.qnatdcont{	width: 250px;
	height: 50px;
	border-bottom: 2px solid #F2EFEF;
	font-size: 15pt;
	}
	
.qnatdcont1{width: 100px;
	height: 50px;
	border-bottom: 2px solid #F2EFEF;
	font-size: 15pt;
	}

.qnatdcont2{width: 450px;
	height: 50px;
	border-bottom: 2px solid #F2EFEF;
	font-size: 15pt;
	}

.qnatdcont5{width: 100px;
	height: 50px;
	border-bottom: 2px solid #F2EFEF;
	font-size: 15pt;
	}
</style>
</head>
<body>


					
			<div id="qnaliststyle">	
		
		<table class="qnalist_t">
			<tr>
				<td class="qnatd1">
					<div>No.</div>
				</td>
				<td class="qnatd2">
					<div>TITLE</div>
				</td>
				<td class="qnatd">
					<div>EMAIL</div>
					
				</td>
				<td class="qnatd">
					<div>DATE</div>
				</td>
				<td class="qnatd5">
					<div>VIEW</div>
				</td>
			</tr>

			<!-- 화면 출력 번호  변수 정의 -->
			<c:set var="qnanum" value="${qnalistcount-(qnapage-1)*10}" />

			<!-- 반복문 시작 -->
			<c:forEach var="b" items="${qnalist}">

				<tr>
					<td class="qnatdcont1">
						<!-- 번호 출력 부분 --> <c:out value="${qnanum}" />
                       <c:set var="qnanum" value="${qnanum-1}" />
					</td>

					<td class="qnatdcont2">
						<div>
							<!-- 답글인 경우 -->
							<c:if test="${b.qna_re_lev != 0}">
								<c:forEach var="k" begin="1" end="${b.qna_re_lev}">
						&nbsp;&nbsp;			
					</c:forEach>
								<img src="./resources/images/AnswerLine.png">
							</c:if>

							<!-- 제목 출력 부분 -->
							<%-- <a href="qna_cont.nhn?num=${b.qna_num}&qnapage=${qnapage}&state=cont"> --%>
							<a href="#" class="qnasubject">
								${b.qna_subject} </a>
								<input type="hidden" value="${b.qna_num}" id="num">
						</div>
					</td>

					<td class="qnatdcont">
						<div>${b.qna_name}</div>
					</td>
					<td class="qnatdcont">
						<div><c:set var="TextValue" value="${b.qna_date}"/>
						${fn:substring(TextValue,0,16)}</div>
					</td>
					<td class="qnatdcont5">
						<div>${b.qna_readcount}</div>
					</td>
				</tr>

			</c:forEach>
			<!-- 반복문 끝 -->
		</table>

		<!-- </div> -->
		<c:if test="${qnalistcount >= 1}">
		<div class="paging">
			<c:if test="${qnapage <=1 }">
				<a class="direction" href="qna_list.nhn?qnapage=${qnapage}">&lt</a>
			</c:if>

			<c:if test="${qnapage > 1 }">
				<a class="direction" href="qna_list.nhn?qnapage=${qnapage-1}">&lt</a>
			</c:if>

			<c:forEach var="a" begin="${qnastartpage}" end="${qnaendpage}">
				<c:if test="${a == qnapage }">
					<span class="number on">${a}</span>
				</c:if>
				<c:if test="${a != qnapage }">
					<a class="number" href="qna_list.nhn?qnapage=${a}">${a}</a>
				</c:if>
			</c:forEach>

			<c:if test="${qnapage >= qnamaxpage }">
				<span class="direction">&gt</span> 
			</c:if>
			<c:if test="${qnapage < qnamaxpage }">
				<a class="direction" href="qna_list.nhn?qnapage=${qnapage+1}">&gt</a>
			</c:if>
		</div>
		</c:if>
            </div> 
		<!-- 검색 부분 -->
		<div id="qafind">
			<script>
				function qnafind_check() {
					if ($.trim($("#qnafind_name").val()) == "") {
						alert("검색내용을 입력하세요!");
						$("#qnafind_name").val("").focus();
						return false;
					}
				}
			</script>
		</div>
  </div>
</body>
</html>