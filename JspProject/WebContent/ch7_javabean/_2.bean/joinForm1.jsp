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
						<font size=2>���̵�</font>
					</td>
					<td>
						<input type="text" name="id" id="id">
					</td>
				</tr>
				<tr>
					<td>
						<font size=2>��й�ȣ</font>
					</td>
					<td>
						<input type="password" name="pass" id="pass">
					</td>
				</tr>
				<tr>
					<td>
						<font size=2>�̸�</font>
					</td>
					<td>
						<input type="text" name="name" id="name">
					</td>
				</tr>
				<tr>
					<td>
						<font size=2>����</font>
					</td>
					<td>
						<input type="radio" name="sex" value="1" id="gender1" checked>
							<font size=2>��</font>
						<input type="radio" name="sex" value="2" id="gender1">
							<font size=2>��</font>
					</td>
				</tr>
				<tr>
					<td>
						<font size=2>����</font>
					</td>
					<td>
						<input type="text" name="age" id="age">
					</td>
				</tr>
				<tr>
					<td>
						<font size=2>�̸����ּ�</font>
					</td>
					<td>
						<input type="text" name="email" id="email">
					</td>
				</tr>
				<tr>
					<td colspan=2>
						<input type="submit" value="����" id="s">
						<input type="reset" value="�ٽ� �ۼ�" id="r">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>