<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<fieldset>
			<legend><h2>정보 수정</h2></legend>
			<form action="updatePro.net" method="post">
				<input type="hidden" name="id" value="${mem.id}">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id" value="${mem.id }" disabled="disabled"></td>
					</tr>
					<tr>
						<td>암호</td>
						<td><input type="password" name="password" value="${mem.password}"></td>
					</tr>
					<tr>
            			<td colspan=2 align="right">
           				<input type="submit" value="변경">
           				<input type="button" value="취소"
            					onclick = "history.go(-1)">
         				</td>
         			</tr>
				</table>
			</form>
		</fieldset>
	</body>
</html>