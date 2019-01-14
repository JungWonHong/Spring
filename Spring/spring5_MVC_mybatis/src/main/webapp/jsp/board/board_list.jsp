<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" 
		   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
   <head>
      <title>게시판 목록</title>
      <style>
      	td {font-family: Tahoma}
      	.ten {font-size: 10px}
      	.eleven {font-size: 11pt}
      	div, .center {text-align: center}
      </style>
      <link href="./resources/css/bbs.css" rel="stylesheet" type="text/css">
   </head>
   <body>
      <!-- 게시판 리스트 -->
      <div id="bbslist_wrap">
      	<h2 class="bbslist_title">게시판 목록</h2>
      		<div id="bbslist_c">글 개수 : ${listcount }</div>
      			<table id="bbslist_t">
      				<tr class="center" valign="middle" bordercolor="#333333">
      				 <td class="eleven" width="8%" height="26">
      				 	<div>번호</div>
      				 </td>
      				 <td class="eleven" width="47%">
      				 	<div>제목</div>
      				 </td>
      				 <td class="eleven" width="14%">
      				 	<div>작성자</div>
      				 </td>
      				 <td class="eleven" width="17%">
      				 	<div>날짜</div>
      				 </td>
      				 <td class="eleven" width="14%">
      				 	<div>조회수</div>
      				 </td>
      				</tr>
      				
      				<!-- 화면 출력 번호 변수 정의 -->
      				<c:set var="num" value="${listcount-(page-1)*10 }"/>
      				<!-- 반복문 시작 -->
      				<c:forEach var="b" items="${boardlist }">
      					<tr class="center"
      						onmouseover="this.style.background='#FFF8F8'"
      						onmouseout="this.style.background=''">
      						<td height="23" class="ten">
      							<!-- 번호 출력 부분 -->
      							<c:out value="${num }"/>
      							<c:set var="num" value="${num-1 }"/>
      						</td>
      						
      						<td class="ten">
      							<div style="text-align:left">
      								<c:if test="${b.board_re_lev != 0 }">
      									<c:forEach var="k" begin="1" end="${b.board_re_lev }">
      										&nbsp;&nbsp;
      									</c:forEach>
      									<img src="./resources/images/AnswerLine.gif">
      								</c:if>
      								
      								<!-- 제목 출력 부분 -->
      								<a href="board_cont.nhn?board_num=${b.board_num }&page=${page}&state=cont">
      									${b.board_subject }
      								</a>
      							</div>
      						</td>
      						
      						<td class="ten">
      							<div>${b.board_name }</div>
      						</td>
      						<td class="ten">
      							<div>${b.board_date }</div>
      						</td>
      						<td class="ten">
      							<div>${b.board_readcount }</div>
      						</td>
      					</tr>
      				</c:forEach>
      				<!-- 반복문 끝 -->
      			</table>
      			
      			<div style="margin-left: 0px; margin-top: 20px">
      				<c:if test="${page <= 1 }">
      					[이전]&nbsp;
      				</c:if>
      				
      				<c:if test="${page > 1 }">
      					<a href="board_list.nhn?page=${page-1 }">[이전]</a>&nbsp;
      				</c:if>
      				
      				<c:forEach var="a" begin="${startpage }" end="${endpage }">
      					<c:if test="${a == page }">
      						[${a }]
      					</c:if>
      					<c:if test="${a != page }">
      						<a href="board_list.nhn?page=${a }">[${a }]</a>&nbsp;
      					</c:if>
      				</c:forEach>
      				
      				<c:if test="${page >= maxpage }">
      					[다음]
      				</c:if>
      				<c:if test="${page < maxpage }">
      					<a href="board_list.nhn?page=${page+1 }">[다음]</a>
      				</c:if>
      			</div>
      			<div id="bbslist_w">
      				<input type="button" value="글쓰기" class="input_button"
      						onclick="location='board_write.nhn'">
      			</div>
      </div>
   </body>
</html>