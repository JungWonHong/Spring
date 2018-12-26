<!--  글 내용을 보여주는 View 페이지 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="euc-kr"%>
<%@ page import="net.board.db.*" %>
<%
//게시물의 내용이 담겨있는 boarddata 속성의 데이터를 BoardBean 타입으로 
//변환하여 얻습니다.
  BoardBean board = (BoardBean)request.getAttribute("boarddata");
%>
<html>
<head>
	<title>MVC 게시판</title>
	<link href="css/ch14_1.css" rel="stylesheet" type="text/css">
</head>

<body>
<!-- 게시판 수정 -->
<table>
	<tr valign="middle">
		<th colspan="2">MVC 게시판-view페이지</th>
	</tr>	
	<tr>
		<td>
			<div>글쓴이</div>
		</td>		
		<td>
		<%=board.getBOARD_NAME()%>
		</td>
	</tr>	
	<tr>
		<td>
			<div>제 목</div>
		</td>		
		<td>
		<%=board.getBOARD_SUBJECT()%><!-- 게시물의 제목을 출력합니다. -->
		</td>
	</tr>	
	<tr>
		<td>
			<div>내 용</div>
		</td>		
		<td>		
		 <textarea name="BOARD_CONTENT" 
		   cols="67" rows="15"><%=board.getBOARD_CONTENT() %></textarea>
		</td>			
	</tr>	
	<tr>
		<td>
			<div>첨부파일</div>
		</td>
		<td>
		<!-- 게시물에 첨부파일이 존재할 경우 첨부 파일의 링크를 표시합니다. -->
		<%if(!(board.getBOARD_FILE()==null)){ 			
		%>
		 <a href="./boardupload/<%=board.getBOARD_FILE()%>" download>
			<%=board.getBOARD_FILE() %>
		    </a>
	    <%} %>
		</td>
	</tr>
	
	<tr bgcolor="00ffff">
		<td colspan="2" style="height:1px;"></td>
	</tr>

	<!-- 답변, 수정, 삭제, 목록의 링크를 표시합니다. -->
	<tr>
		<td colspan="2" class="h30 lime center">
			<a href="./BoardReplyView.bo?num=<%=board.getBOARD_NUM() %>">
			[답변]
			</a>&nbsp;&nbsp;
			<a href="./BoardModify.bo?num=<%=board.getBOARD_NUM() %>">
			[수정]
			</a>&nbsp;&nbsp;
			<a href="./BoardDelete.bo?num=<%=board.getBOARD_NUM() %>">
			[삭제]
			</a>&nbsp;&nbsp;
			<a href="./BoardList.bo">[목록]</a>&nbsp;&nbsp;
		</td>
	</tr>
</table>
</body>
</html>