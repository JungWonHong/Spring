<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��� �ۼ�</title>
<script src="js/jquery-3.2.1.js"></script>
</head>
<body>
<form action="CommentsAddAction.co" method="post">
<table>
	<tr>
		<td>
			<div>Comments </div>
		</td>
		<td>
			<textArea cols="50" rows="3" name="cmtcontent"></textArea><!-- ��� �Է�â -->
		</td>
		<td>
			<input type="submit" value="POST">
		</td>
	</tr>
</table>
</form>
</body>
</html>