<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");
	
	if(id != null && id.length() != 0){
		session.setAttribute("id", id);
	} else {
%>
	<script>
	alert("아이디를 입력하세요!");
	history.back();
	</script>
<% 
	}
%>
<html>
	<head>
		<title>Session Login</title>
		<style>
			body {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<h2>로그인되었습니다.</h2>
		<h2>로그인 아이디 : <%=(String)session.getAttribute("id") %></h2>
		<h2><a href="sessionLogout.jsp">로그아웃</a></h2>
	</body>
</html>