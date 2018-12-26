<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		<script src="../../js/jquery-3.2.1.js"></script>
		<script src="../../js/ch7.js"></script>
		<link rel="stylesheet" href="../../css/ch7-1_2.css" type="text/css">
	</head>
	<body>
		<form action="joinChk1.jsp" method="post" >
			<table>
				<tr>
					<td>
						<font size=2>아이디</font>
					</td>
					<td>
						<input type="text" name="id" id="id">
					</td>
				</tr>
				<tr>
					<td>
						<font size=2>비밀번호</font>
					</td>
					<td>
						<input type="password" name="pass" id="pass">
					</td>
				</tr>
				<tr>
					<td>
						<font size=2>이름</font>
					</td>
					<td>
						<input type="text" name="name" id="name">
					</td>
				</tr>
				<tr>
					<td>
						<font size=2>성별</font>
					</td>
					<td>
						<input type="radio" name="sex" value="1" id="gender1" checked>
							<font size=2>남</font>
						<input type="radio" name="sex" value="2" id="gender1">
							<font size=2>여</font>
					</td>
				</tr>
				<tr>
					<td>
						<font size=2>나이</font>
					</td>
					<td>
						<input type="text" name="age" id="age">
					</td>
				</tr>
				<tr>
					<td>
						<font size=2>이메일주소</font>
					</td>
					<td>
						<input type="text" name="email" id="email">
					</td>
				</tr>
				<tr>
					<td colspan=2>
						<input type="submit" value="가입" id="s">
						<input type="reset" value="다시 작성" id="r">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>