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
				out.print(session.getAttribute("id") + " ���� �α׾ƿ� �մϴ�.");
				session.invalidate();
			}
		%>
		</h3>
		<a href="sessionLogin.jsp">�α��� ������</a>
	</body>
</html>