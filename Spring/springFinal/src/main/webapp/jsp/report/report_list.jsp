<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
#title {
	font-size: 30pt;
	font-weight: bold;
}

table {
	margin-top: 10%;
	margin-left:0%;
border: 2px solid lightgray;
border-collapse:collapse;
	
}

tr{
border: 2px solid lightgray;
   }

td {
	width: 1500px;
	height: 60px;
	text-align:center;
}

th{
   :#2ABCB4;
   height:60px;
   font-size:15pt;
   background-color: #2ABCB4;
}

.cate{
      width:3000px;
      text-align:center;
    
    }
 a{text-decoration:none;  color:black}

.sen{widtn:1300px;}
.reportimg{ width:50px; height:50px;}
.ig{width:10px;}
.ig1{width:20px; padding-left:8.5%}
.input_button{	width: 30px; height: 30px;  border: 0px; padding-left:10%}
.wastetd{padding-left:8%;}
.page{padding-left:41%; font-size:14pt;}
</style>
<script>
function report_del(){
	var r_num = document.getElementById('r_num').value;
	var page = document.getElementById('r_page').value;
	var url = 'khcc_reportdel.nhn?num=' + r_num + '&page=' + page + '&state=list';
	window.open(url, "report_del_ok",
            "toolbar = no, status = yes, menubar = no," + 
            "width = 300, height = 150");
}
</script>
</head>
<body onload='resizeWindow(this)'>
	<div id="title">신고접수현황</div>
		<div id="title1">회원(신고하기)를 통해 접수된  쪽지 입니다.</div>

	<table>
		<tr>
			<th>글 번호</th>
			<th class="sen">보낸 사람</th>
			<th class="cate">접수 유형</th>
			
			<th colspan="3" class="ig">이미지</th>
		

		</tr>

		<!-- 화면 출력 번호  변수 정의 -->
		<c:set var="num" value="${1+(page-1)*5}" />
         	
		<!-- 반복문 시작 -->
		<c:forEach var="k" items="${reportlist}">
			<tr>
	
				<td>
					<!-- 번호 출력 부분 --> <c:out value="${num}" /> <c:set var="num"
						value="${num+1}" />
				</td>
				<td class="sen">${k.r_SENDER }</td>
				
				<td class="cate" colspan="2"><a href="khcc_reportcont.nhn?num=${k.r_NUM}&page=${page}&state=cont">${k.r_CATEGORY } </a></td>

				<td class="ig1"><c:if test="${k.r_ORGIMG !=null}"><img src="./resources/images/reportimg1.jpg" class="reportimg"></c:if>
				</td>
				<td class="wastetd"><input type="image" value="" src="./resources/images/waste1.png" class="input_button"
   					onclick="javascript:report_del();" />
   					<input type="hidden" id="r_num" value="${k.r_NUM}">
   					<input type="hidden" id="r_page" value="${page }">
   				</td>
			</tr>
		
		</c:forEach>
	

	</table>

	<div style="margin-left: 0px; margin-top: 20px" class="page">
		<c:if test="${page <=1 }">
				이전&nbsp;
			</c:if>

		<c:if test="${page > 1 }">
			<a href="khcc_reportlist.nhn?page=${page-1}">이전</a>&nbsp;
			</c:if>

		<c:forEach var="a" begin="${startpage}" end="${endpage}">
			<c:if test="${a == page }">
					${a}
				</c:if>
			<c:if test="${a != page }">
				<a href="khcc_reportlist.nhn?page=${a}">${a}</a>&nbsp;
				</c:if>
		</c:forEach>

		<c:if test="${page >= maxpage }">
				다음
			</c:if>
		<c:if test="${page < maxpage }">
			<a href="khcc_reportlist.nhn?page=${page+1}">다음</a>
		</c:if>
	</div>



</body>
</html>