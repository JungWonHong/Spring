<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
	<head>
		<title>pageContextTest2.jsp</title>
	</head>
	<body>
		<h3>여기는 pageContextTest2.jsp의 앞부분</h3>
		pageContextTest3.jsp의 처리 결과가 포함됩니다.
		<hr>
		<% pageContext.include("pageContextTest3.jsp"); %>
		<hr>
		<h3>여기는 pageContext의 forward 메소드로 포워딩된 페이지 pageContextTest2.jsp입니다.</h3>
	</body>
</html>