<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String ID = (String)session.getAttribute("id");
	boolean isLogin = false;
	if(ID != null) {
		isLogin = true;
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<title>로그인 여부 검사</title>
		<style>
			body {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<%
			if(isLogin){
		%>
		ID "<%=ID %>"로 로그인 한 상태입니다.<br><br>
		<a href="logout.jsp">로그아웃</a>
		<%
			} else {
		%>
		로그인 하지 않은 상태입니다.
		<%
			}
		%>
	</body>
</html>