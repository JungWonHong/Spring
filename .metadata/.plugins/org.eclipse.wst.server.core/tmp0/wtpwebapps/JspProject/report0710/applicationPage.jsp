<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>application</title>
		<script src="../js/jquery-3.2.1.js"></script>
		<script src="../js/report0710_1.js" charset="euc-kr"></script>
		<link rel="stylesheet" type="text/css" href="../css/report0710.css">
	</head>
	<body>
		<% request.setCharacterEncoding("euc-kr"); %>
		<h2>영역과 속성 테스트</h2>
		<form action="sessionPage.jsp" method="post">
			<table border="1">
				<tr>
					<td colspan="2">Application 영역에 저장할 내용들</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="전송"></td>
				</tr>
			</table>
		</form>
	</body>
</html>