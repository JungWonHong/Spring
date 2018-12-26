<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>회원관리 시스템 회원가입 페이지</title>
		<style>
			table {
				margin: 0 auto;
			}
			tr:nth-child(1) {
				background: yellow
			}
			tr:nth-child(8) {
				background: lightgreen
			}
			tr:nth-child(2n+1) {
				width: 100px;
			}
			tr:nth-child(2n) {
				width: 200px;
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
		<script src="./js/jquery-3.2.1.js"></script>
		<script src="./js/ch12.js"></script>
	</head>
	<body>
		<form name="joinform" action="joinProcess.net" method="post">
			<table>
				<tr>
					<td colspan="2">
						<b><font size=5>회원가입 페이지</font></b>
					</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pass"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="text" name="age" maxlength=2></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<input type="radio" name="gender" value="남" checked>남자
						<input type="radio" name="gender" value="여">여자
					</td>
				</tr>
				<tr>
					<td>이메일 주소</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td colspan="2">
						<a href="javascript:joinform.submit()">회원가입</a>
						&nbsp;&nbsp;
						<a href="javascript:joinform.reset()">다시작성</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>