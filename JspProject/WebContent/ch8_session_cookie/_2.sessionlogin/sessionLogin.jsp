<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>session Login</title>
		<link rel="stylesheet" href="../../css/ch8-1.css" type="text/css">
	</head>
	<body>
		<form action="sessionLogin2.jsp" method="post">
			<table>
				<tr>
					<td><font size=2>아이디</font></td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td><font size=2>비밀번호</font></td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr class="green">
					<td colspan=2>
						<input type="submit" value="로그인">
						<input type="reset" value="다시 작성">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>