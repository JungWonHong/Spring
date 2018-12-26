<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../Header.jsp"></jsp:include>
	<form action="loginProcess.com" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id"></td>
				<td rowspan=2><input type="submit" value="login"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td><input type="radio" name="memkind" value="1" checked>개인회원</td>
				<td><input type="radio" name="memkind" value="2">기업회원</td>
			</tr>
			<tr>
				<td><a href="./pjoin.com">회원가입</a></td>
			</tr>
		</table>
	</form>
</body>
</html>