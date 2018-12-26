<!--댓글 페이지 -->

<%@ page language="java"
	contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "semi.db.*" %>
<%
	request.setCharacterEncoding("euc-kr");
%>
<html>
<head>
<title>JOBS - CommentsBoard</title>
</head>
<style>
	@CHARSET "EUC-KR";
	div {width:800px; height:100px}
	table{margin:0 auto; width:800px; text-align:center;}
	tr{height:20px; background:silver;}
	tr:first-child {height:10px;}
	td{font-family:돋음; font-size:14; height:36px}
	.center {margin:0 auto}
</style>
<body>
<%-- 게시판 등록 
 ReplyAddAction.bo : 글을 등록처리하는  ReplyAddAction 클래스를 호출합니다.
--%>
<form action="./CommentsAddAction.co" method="post" name="Commentsform">
	
	
<!-- 댓글 입력창 -->
<div class="center">
<label>id 노출</label><br>
<textarea name="comment_content" cols="90" rows="3" placeholder="소중한 의견을 남겨주세요.(개인회원 로그인 후 이용 가능)"></textarea>
<input type="button" name="registration" value="등록" width=100px height=200px >
</div>
<table>
	<tr>
		<td>작성자</td>
		<td>날짜</td>
		<td>댓글</td>
		<td colspan="3"></td>
	</tr>
	<tr>
		<td>genie</td>
		<td>2017.07.24 12:46</td>
		<td>안녕하세요~~~~~~~~~~~~~~~~~~~~~</td>
		<td>답글</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
</table>
</form>
</body>
</html>