<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>입력 폼 입니다.</title>
<style>
table {
	margin: 0 auto;
	width: 300px
}

.last {
	background: lightgreen
}

td:nth-child(2n+1) {
	background: yellow
}

td {
	text-align: center;
	height: 30px
}
</style>
</head>
<body>
	<form name=myform method=post action="./login_ok2.do">
		<table border=1>
			<tr>
				<td>ID2</td>
				<td><input type=text name=id></td>
			</tr>
			<tr>
				<td>비밀번호2</td>
				<td><input type=password name=pass></td>
			</tr>
			<tr>
				<td colspan=2 style="background: lightgreen"><input type=submit
					value="로그인"></td>
			</tr>
		</table>
	</form>
</body>
</html>