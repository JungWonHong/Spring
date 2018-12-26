<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<form action="mailSend.jsp" method="post">
			<table border=1>
				<tr>
					<td colspan=2>자바메일 보내기</td>
				</tr>
				<tr>
					<td>보내는 사람 메일</td>
					<td><input type="text" name="sender"></td>
				</tr>
				<tr>
					<td>받는 사람 메일</td>
					<td><input type="text" name="receiver"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="subject"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea name="content" cols=40 rows=10></textarea>
				</tr>
				<tr>
					<td colspan=2><input type="submit" value="보내기"></td>
				</tr>
			</table>
		</form>
	</body>
</html>