<!-- 글 답변 페이지 -->
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="net.board.db.*" %>
<html>
<head>
	<title>MVC 게시판</title>
	<link href="css/ch14_1.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- 게시판 답변 -->
<!-- 답변을 클릭하면  BoardReplyAction 클래스를 호출하여 답변 처리가 되도록 합니다.-->
<form action="./BoardReplyAction.bo" method="post" name="boardform">
  <!-- 원본 글의 정보를 hidden값으로 가지고 있습니다. -->
  <input type="hidden" name="page" 
  		 value="${page }">
  		 
  <input type="hidden" name="BOARD_NUM" 
         value="${boarddata.BOARD_NUM }">
       
  <input type="hidden" name="BOARD_RE_REF" 
         value="${boarddata.BOARD_RE_REF }">
       
  <input type="hidden" name="BOARD_RE_LEV" 
         value="${boarddata.BOARD_RE_LEV }">
       
  <input type="hidden" name="BOARD_RE_SEQ" 
         value="${boarddata.BOARD_RE_SEQ }">

  <table>
	<tr>
		<th colspan="2">MVC 게시판-Reply</th>
	</tr>
	<tr>
		<td>
			<div>글쓴이</div>
		</td>
		<td>
			<input name="BOARD_NAME" type="text"/>
		</td>
	</tr>
	<tr>
		<td>
			<div>제 목</div>
		</td>
		<td>
		   <!-- 답변 폼 페이지의 제목 부분에는 맨 앞에 Re:가 붙고 원본 글 제목이 나옵니다. -->
			<input name="BOARD_SUBJECT" type="text" size="50" 
				   maxlength="100" 
				   value="Re: ${boarddata.BOARD_SUBJECT }"/>
		</td>
	</tr>
	<tr>
		<td>
			<div>내 용</div>
		</td>
		<td>
			<textarea name="BOARD_CONTENT" cols="67" rows="15"></textarea>
		</td>
	</tr>
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
		<input type=submit value="등록">
		<input type=button value="취소" onClick="history.go(-1)">
		</td>
	</tr>
</table>
</form>
<!-- 게시판 답변 -->
</body>
</html>

