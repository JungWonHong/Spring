<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>scope.jsp</title>
	</head>
	<body>
		request 加己 : <%=request.getAttribute("food") %><br>
		session 加己 : <%=session.getAttribute("food") %><br>
		ServletContext 加己 : <%=application.getAttribute("food") %>
	</body>
</html>