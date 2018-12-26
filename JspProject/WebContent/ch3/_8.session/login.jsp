<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>login.jsp</title>
	</head>
	<body>
		<form action="login_ok" method="post">
			아이디 : <input type="text" name="id"/><br>
			비밀번호 : <input type="password" name="passwd"/><br>
			<input type="submit" value="로그인"/>
		</form>
	</body>
</html>