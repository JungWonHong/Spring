<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>입력한 ID, 비밀번호 출력 - list3</title>
<style>
	table { margin: 0 auto; width: 300px }
	th { width: 30%; background: lightgreen }
</style>
</head>
<body>
	<h1>@ModelAttribute("hoho") - list3.jsp입니다.</h1>
	<table border=1>
		<tr>
			<th>ID2</th>
			<td>${hoho.id }</td>
		</tr>
		<tr>
			<th>비밀번호2</th>
			<td>${hoho.pass }</td>
		</tr>
	</table>
</body>
</html>