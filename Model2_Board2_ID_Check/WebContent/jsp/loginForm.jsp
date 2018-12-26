<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>회원관리 시스템 로그인 페이지</title>
		<style>
			table {
				margin: 0 auto;
				width: 300px;
			}
			tr:nth-child(1) {
				background: yellow
			}
			tr:nth-child(4) {
				background: lightgreen
			}
			td {
				text-align: center;
				height: 50px
			}
			input[type=text], input[type=password] {
				width: 95%;
				border-radius: 5px;
				height: 70%;
				border-color: #9e9ee8
			}
			a {
				text-decoration: none;
			}
		</style>
	</head>
	<body>
		<form name="loginform" action="loginProcess.net" method="post">
			<table>
				<tr>
					<td colspan="2">
						<b><font size=5>로그인 페이지</font></b>
					</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pass"/></td>
				</tr>			
				<tr>
					<td colspan="2">
						<a href="javascript:loginform.submit()">로그인</a>
						&nbsp;&nbsp;
						<a href="join.net">회원가입</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>