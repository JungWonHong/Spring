<%-- 글쓰기 폼 페이지 --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<title>MVC 게시판</title>
	<link href="css/ch14_1.css" rel="stylesheet" type="text/css">	
	<script src="./js/jquery-3.2.1.js"></script>
	<script src="./js/ch14.js"></script>
</head>
<body>
<%-- 게시판 등록 
 BoardAddAction.bo : 글을 등록처리하는  BoardAddAction 클래스를 호출합니다.
     enctype="multipart/form-data" : 파일을 업로드할 수 있도록 설정합니다.
--%>
<form action="./BoardAddAction.bo" method="post" 
	enctype="multipart/form-data" name="boardform">
	
<table>
	<tr class="center">
		<th colspan="2">MVC 게시판-write 페이지</th>
	</tr>
	<tr>
		<td>
			<div>글쓴이</div>
		</td>
		<td>
			<input name="BOARD_NAME" type="text"   size="10" 
			       maxlength="10"    value="">
		</td>
	</tr>
	<tr>
		<td>
			<div>비밀번호</div>
		</td>
		<td>
			<input name="BOARD_PASS" type="password"  size="10" 
			       maxlength="10"    value="">
		</td>
	</tr>
	<tr>
		<td>
			<div>제 목</div>
		</td>
		<td>
			<input name="BOARD_SUBJECT"   type="text" 
			       size="80"   maxlength="100"    value="">
		</td>
	</tr>
	<tr>
		<td>
			<div>내 용</div>
		</td>
		<td>
			<textarea name="BOARD_CONTENT" cols="83" rows="15"></textarea>
		</td>
	</tr>
	<tr>
		<td>
			<div>파일 첨부</div>
		</td>
		<td>
			<input name="BOARD_FILE" type="file">
		</td>
	</tr>
	<tr bgcolor="#cccccc">
		<td colspan="2" style="height:1px;"></td>
	</tr>
	<tr class="center">
		<td colspan="2" class="h30 lime">
			<input type=submit value="등록">
			<input type=reset value="취소">
		</td>
	</tr>
   </table>
 </form>
</body>
</html>