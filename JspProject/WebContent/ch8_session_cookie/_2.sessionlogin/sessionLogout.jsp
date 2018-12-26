<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
	<head>
		<style>
			body {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<h3>
		<%
			if(session != null && session.getAttribute("id") != null){
				out.print(session.getAttribute("id") + " 님이 로그아웃 합니다.");
				session.invalidate();
			}
		%>
		</h3>
		<a href="sessionLogin.jsp">로그인 페이지</a>
	</body>
</html>