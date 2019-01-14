<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="ko">
<head>
<title>Q&A SEARCH</title>
<script src="./resources/js/jquery-3.2.1.js"></script>
<script src="./resources/js/qa2_4.js"></script>
<script>
/* $(document).ready(function() {
$("#qnalist").on('click','.qnasubject',function() {

  	$.ajax({
			url:'./qna_cont_ajax.nhn',
		data: 'num=' + $(this).next().val(),
		dataType: 'html',
		success: function(redata){
		console.log(redata);
		$('#qnalist').empty();			    	
		$('#qnalist').append(redata);

			}

		})

	});  //qnacontview
});
 */
</script>
<style>
#qnafind_wrap{margin-left:25%; margin-top:10%}
.findth11{	width: 100px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
	text-align:center}
.findth2{width: 400px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
	text-align:center}
.findth3,.findth4{width: 100px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
	text-align:center}
}
#findthtext{width: 250px;
	height: 50px;
	border: 2px solid #F2EFEF;
	background: #2ABCB4;
	color: white;
	font-size: 15pt;
	font-weight: bold;
	text-align:center}
}
.findtd11{	
    width: 100px;
	height: 50px;
	border-bottom: 2px solid #F2EFEF;
	font-size: 15pt;}
#findthtexttd{width: 100px;
	height: 50px;
	border-bottom: 2px solid #F2EFEF;
	font-size: 15pt;
	
}
.findtd2,.findtd3,.findtd4{
    width: 250px;
	height: 50px;
	border-bottom: 2px solid #F2EFEF;
	font-size: 15pt;
	text-align:center;
	
}

#qnafindlist{font-size:15pt;}
#qnafind_t{width:1150px}

</style>
</head>
<body>
	<div id="qnafind_wrap">
		<div id="qnafindlist">글 개수 : ${qnalistcount}</div>
		
		<table id="qnafind_t">
			<tr>
				<td class="findth11">
					<div>No.</div>
				</td>
				<td class="findth2">
					<div>TITLE</div>
				</td>
				<td class="findth3">
					<div>EMAIL</div>
				</td>
				<td class="findth4">
					<div>DATE</div>
				</td>
				<td id="findthtext" style="background:#2ABCB4; font-size:15pt; text-align:center; color:white; font-weight:bold">
					<div>VIEW</div>
				</td>
			</tr>

			<!-- 화면 출력 번호  변수 정의 -->
			<c:set var="num" value="${qnalistcount-(qnapage-1)*10}" />

			<!-- 반복문 시작 -->
			<c:forEach var="b" items="${qnalist}">

				<tr align="center" valign="middle" bordercolor="#333333"
					onmouseover="this.style.background='#B1EFED'"
					onmouseleave="this.style.background=''">
					<td class="findtd11">
						<!-- 번호 출력 부분 --> <c:out value="${num}" /> <c:set var="num"
							value="${num-1}" />
					</td>

					<td class="findtd2">
						<div>
							<!-- 답글인 경우 -->
							<c:if test="${b.qna_re_lev != 0}">
								<c:forEach var="k" begin="1" end="${b.qna_re_lev}">
						&nbsp;&nbsp;			
					</c:forEach>
								<img src="./resources/images/AnswerLine.png">
							</c:if>

							<!-- 제목 출력 부분 -->
							<a href="#" class="qnasubject">
								${b.qna_subject} </a>
								<input type="hidden" value="${b.qna_num}" id="num">
						</div>
					</td>

					<td class="findtd3">
						<div>${b.qna_name}</div>
					</td>
					<td class="findtd4">
						<div><c:set var="TextValue" value="${b.qna_date}"/>
						${fn:substring(TextValue,0,16)}</div>
					</td>
					<td id="findthtexttd" style=" text-align:center; font-size:15pt; border-bottom: 2px solid #F2EFEF; ">
						<div>${b.qna_readcount}</div>
					</td>
				</tr>

			</c:forEach>
			<!-- 반복문 끝 -->
		</table>

		<br>
	
		<!-- </div> -->

		<div style="align: center; margin-top: 10%; margin-left:40%">
			<c:if test="${qnapage <=1 }">
				[이전]&nbsp;
			</c:if>

			<c:if test="${qnapage > 1 }">
				<a
					href="qna_find_ok.nhn?page=${page-1}&qnafind_name=${qnafind_name}&qnafind_field=${qnafind_field}">[이전]</a>&nbsp;
			</c:if>

			<c:forEach var="a" begin="${qnastartpage}" end="${qnaendpage}">
				<c:if test="${a == qnapage }">
					[${a}]
				</c:if>
				<c:if test="${a != qnapage }">
					<a
						href="qna_find_ok.nhn?qnapage=${a}&qnafind_name=${qnafind_name}&qnafind_field=${qnafind_field}">[${a}]</a>&nbsp;
				</c:if>
			</c:forEach>

			<c:if test="${qnapage >= qnamaxpage }">
				[다음] 
			</c:if>
			<c:if test="${qnapage < qnamaxpage }">
				<a
					href="qna_find_ok.nhn?qnapage=${qnapage+1}&qnafind_name=${qnafind_name}&qnafind_field=${qnafind_field}">[다음]</a>
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