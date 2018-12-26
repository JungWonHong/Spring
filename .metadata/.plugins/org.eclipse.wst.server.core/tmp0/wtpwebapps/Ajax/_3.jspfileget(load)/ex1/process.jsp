<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		넘어온 이름은 ${param.name } 입니다.<br>
		넘어온 나이는 ${param.age }세 입니다.<br>
		넘어온 주소는 ${param.address } 입니다.
	</body>
</html>