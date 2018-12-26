<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>이동해 왔습니다.</title>
	</head>
	<body>
		<% request.setCharacterEncoding("euc-kr"); %>
		${param.id}는 ${param.name} 입니다.
	</body>
</html>