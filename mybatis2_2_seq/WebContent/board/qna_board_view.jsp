<!--  글 내용을 보여주는 View 페이지 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="net.board.db.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<div>제 목</div>
		</td>		
		<td>
		${boarddata.BOARD_SUBJECT }
		</td>
	</tr>	
	<tr>
		<td>
			<div>내 용</div>
		</td>		
		<td>		
		 <pre>${boarddata.BOARD_CONTENT }</pre>
		</td>			
	</tr>	
	<tr>
		<td>
			<div>첨부파일</div>
		</td>
		<td>
		<c:if test="${!empty boarddata.BOARD_FILE }">
		 <a href="./BoardDownload.bo?file_name=${boarddata.BOARD_FILE}">
		 	${boarddata.BOARD_FILE }</a>
		</c:if>
		</td>
	</tr>
	
	<tr bgcolor="00ffff">
		<td colspan="2" style="height:1px;"></td>
	</tr>

	<!-- 답변, 수정, 삭제, 목록의 링크를 표시합니다. -->
	<tr>
		<td colspan="2" class="h30 lime center">
			<a href="./BoardReplyView.bo?num=${boarddata.BOARD_NUM }&page=${page}">
			[답변]
			</a>&nbsp;&nbsp;
			<a href="./BoardModify.bo?num=${boarddata.BOARD_NUM }&page=${page}">
			[수정]
			</a>&nbsp;&nbsp;
			<a href="./BoardDelete.bo?num=${boarddata.BOARD_NUM }&page=${page}">
			[삭제]
			</a>&nbsp;&nbsp;
			<a href="./BoardList.bo">[목록]</a>&nbsp;&nbsp;
		</td>
	</tr>
</table>
</body>
</html>