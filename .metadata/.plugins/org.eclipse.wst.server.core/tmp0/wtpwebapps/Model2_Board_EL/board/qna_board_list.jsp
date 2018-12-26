<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="net.board.db.*" %>
<%@ taglib prefix="c" 
		   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
   <head>
      <title>MVC 게시판</title>
      <link href="./css/ch14_listlist.css" rel="stylesheet" type="text/css">
   </head>
   <body>
      <!-- 게시판 리스트 -->
      
      <table>
      
      <!-- 레코드가 있으면 -->
      <!-- core 라이브러리 사용 -->
      <c:if test="${listcount > 0 }">

         <tr>
            <th colspan="3">MVC 게시판 - list</th>
            <th colspan="2">
            	<font size=2>글 개수 : ${listcount }</font>
            </th>
         </tr>
         
         <tr>
            <th width="8%">
            	<div>번호</div>
            </th>
            <th width="50%">
            	<div>제목</div>
            </th>
            <th width="14%">
            	<div>작성자</div>
            </th>
            <th width="17%">
            	<div>날짜</div>
            </th>
            <th width="11%">
            	<div>조회수</div>
            </th>
         </tr>
         
         
         <c:set var="num" value="${listcount-(page-1)*10 }"/>
         
         <c:forEach var="b" items="${boardlist }">
        
         <tr 
            onmouseover="this.style.backgroundColor='#F8F8F8'"
            onmouseout ="this.style.backgroundColor='#FFFFFF'">
            <td>
            	<c:out value="${num }"/><%-- num 출력 --%>
            	<c:set var="num" value="${num-1 }"/><%-- num=num-1의미 --%>
            </td>
            
            <td>
               <div>
               
               <%-- 답변글 제목앞에 여백 처리 부분
               		BOARD_RE_LEV, BOARD_RE_LEV, BOARD_NUM,
               		BOARD_SUBJECT, BOARD_NAME, BOARD_DATE,
               		BOAR_READCOUNT : property 이름 --%>
               <c:if test="${b.BOARD_RE_LEV != 0 }"> <!-- 답글인 경우 -->
               		<c:forEach var="a" begin="0" end="${b.BOARD_RE_LEV*2 }">
               		&nbsp;
               		</c:forEach>
               	▶
               </c:if>
               
               <c:if test="${b.BOARD_RE_LEV == 0 }"> <!-- 원문인 경우 -->
               	▶
               </c:if>
               
               <!-- 글 제목을 클릭한 경우 입니다. -->
                  <a href="./BoardDetailAction.bo?num=${b.BOARD_NUM}&page=${page}">
                     ${b.BOARD_SUBJECT }
                  </a>
               </div>
            </td>
            <td>
            	<div>${b.BOARD_NAME}</div>
            </td>
            <td>
            	<div>${b.BOARD_DATE }</div>
            </td>
        	<td><div align="center">${b.BOARD_READCOUNT }</div></td>
      	</tr>
      	</c:forEach>

      	<!-- 페이징 처리하는 문 [이전][1][2][3]..[10][다음] -->
      	<tr class="h30 lime center">
       		<td colspan=5>
       			<c:if test="${page <= 1 }">
       				[이전]&nbsp;
       			</c:if>
       			<c:if test="${page > 1 }">
       				<a href="./BoardList.bo?page=${page-1 }">
               		[이전]</a>&nbsp;
       			</c:if>
            	
            	<c:forEach var="a" begin="${startpage }" end="${endpage }">
            		<c:if test="${a == page }">
            			[${a }]
            		</c:if>
            		<c:if test="${a != page }">
            			<a href="./BoardList.bo?page=${a }">[${a }]</a>&nbsp;
            		</c:if>
            	</c:forEach>
                  
         <!-- 현재 페이지가 가장 큰 페이지보다 크거나 같은 경우 [다음]에 링크 걸지 않습니다. -->
            	<c:if test="${page >= maxpage }">
            		[다음]
            	</c:if>
            	<c:if test="${page < maxpage }">
            		<a href="./BoardList.bo?page=${page+1 }">[다음]</a>
            	</c:if>
      		</td>
      	</tr>
      	</c:if>
      
      <!-- 레코드가 없으면 -->
      	<c:if test="${listcount == 0 }">
      		<tr>
         		<td colspan="4">MVC 게시판</td>
         		<td style="text-align:right"><font size=2>등록된 글이 없습니다.</font></td>
      		</tr>
      	</c:if>
      
      	<tr>
         	<td colspan="5" style="text-align:right">
            	<a href="./BoardWrite.bo">[글쓰기]</a>
         	</td>
      	</tr>
      </table>
   </body>
</html>