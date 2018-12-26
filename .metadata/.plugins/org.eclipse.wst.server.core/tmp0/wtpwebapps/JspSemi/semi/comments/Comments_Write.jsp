<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>댓글 작성</title>
<script src="js/jquery-3.2.1.js"></script>
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
<style>
input[type=submit]{
background-color: #F7CA18;
border-radius: 5px;
border : 0px;
padding : 5px;
margin-left : 10px;
height : 50px;
width : 70px;
}
</style>
</head>
<body>
<form action="CommentsAddAction.co" method="post">
<table>
	<tr>
		<td>
			<div>Comments </div>
		</td>
		<td>
			<textArea cols="50" rows="3" name="cmtcontent"></textArea><!-- 댓글 입력창 -->
		</td>
		<td>
			<input type="submit" value="POST">
		</td>
	</tr>
</table>
</form>
</body>
</html>