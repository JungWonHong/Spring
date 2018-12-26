<%-- 글 수정 폼 페이지 --%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="net.board.db.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //저장되어 있던 글 내용 데이터를 화면에 보여주기 위해 boarddata 속성의 데이터를  가져옵니다.
	BoardBean board = (BoardBean)request.getAttribute("boarddata");
%>
<!Doctype html>
<html>
<head>
	<title>MVC 게시판</title>
	<link href="css/ch14_1.css" rel="stylesheet" type="text/css">
	<script>
	function modifyboard(){
		modifyform.submit();
	}
	</script>
</head>

<body>
<!-- 게시판 수정 -->
<form action="BoardModifyAction.bo" method="post" name="modifyform">
<input type="hidden" name="BOARD_NUM" value="${boarddata.BOARD_NUM }">
<input type="hidden" name="page" value="${page }">
<table>
	<tr>
		<th colspan="2">MVC 게시판 - Modify view</th>
	</tr>
	<tr>
		<td>
			<div>제 목</div>
		</td>
		<td>
			<input name="BOARD_SUBJECT" size="50" maxlength="100" 
				value="${boarddata.BOARD_SUBJECT }">
		</td>
	</tr>
	<tr>
		<td>
			<div>내 용</div>
		</td>
		<td>
			<textarea name="BOARD_CONTENT" cols="67" rows="15">${boarddata.BOARD_CONTENT }</textarea>
		</td>
	</tr>
	
	<c:if test="${!empty boarddata.BOARD_FILE }">
		<tr>
			<td>
				<div>파일 첨부</div>
			</td>
			<td>
				&nbsp;&nbsp;${boarddata.BOARD_FILE }
			</td>
		</tr>
	</c:if>
	
	<tr>
		<td>
			<div>비밀번호</div>
		</td>
		<td>
			<input name="BOARD_PASS" id="board_pass" type="password">
		</td>
	</tr>
	
	<tr bgcolor="00ffff">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	
	<tr class="center">
		<td colspan="2" class="h30 lime">
			<a href="javascript:modifyboard()">[수정]</a>&nbsp;&nbsp;
			<a href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;
		</td>
	</tr>
</table>
</form>
<!-- 게시판 수정 -->
</body>
</html>