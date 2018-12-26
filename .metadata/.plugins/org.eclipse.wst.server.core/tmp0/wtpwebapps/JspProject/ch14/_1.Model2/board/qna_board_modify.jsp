<%-- 글 수정 폼 페이지 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ page import="net.board.db.*" %>
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
<input type="hidden" name="BOARD_NUM" value=<%=board.getBOARD_NUM() %>>
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
				value="<%=board.getBOARD_SUBJECT()%>">
		</td>
	</tr>
	<tr>
		<td>
			<div>내 용</div>
		</td>
		<td>
			<textarea name="BOARD_CONTENT" cols="67" rows="15"><%=board.getBOARD_CONTENT() %></textarea>
		</td>
	</tr>
	<%if(!(board.getBOARD_FILE()==null)){ %>
	<tr>
		<td>
			<div>파일 첨부</div>
		</td>
		<td>
			&nbsp;&nbsp;<%=board.getBOARD_FILE() %>
		</td>
	</tr>
	<%} %>
	<tr>
		<td>
			<div>비밀번호</div>
		</td>
		<td>
			<input name="BOARD_PASS" type="password">
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