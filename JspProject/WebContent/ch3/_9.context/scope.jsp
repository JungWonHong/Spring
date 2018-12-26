<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>scope.jsp</title>
	</head>
	<body>
		request 속성 : <%=request.getAttribute("food") %><br>
		session 속성 : <%=session.getAttribute("food") %><br>
		ServletContext 속성 : <%=application.getAttribute("food") %>
	</body>
</html>