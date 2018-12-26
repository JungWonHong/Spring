<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>회원관리 시스템 메인 페이지</title>
		<style>
			body {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<%
			if(id.equals("admin")){
		%>
			<a href="member_list.net">관리자모드 접속(회원 목록 보기)</a>
		<%
			}
		%>
		
	</body>
</html>