<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<form action="joinPro.net" method="post">
		<fieldset>
			<legend><h2>회원가입</h2></legend>
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id" required="required"></td>
					</tr>
					<tr>
						<td>암호</td>
						<td><input type="password" name="password" required="required"></td>
					</tr>
					<tr>
						<td colspan=2 align="center">
							<input type="submit" value="확인">
						</td>
					</tr>
				</table>
		</fieldset>
		</form>
	</body>
</html>