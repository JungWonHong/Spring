<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
	<head>
		<title>pageContextTest2.jsp</title>
	</head>
	<body>
		<h3>����� pageContextTest2.jsp�� �պκ�</h3>
		pageContextTest3.jsp�� ó�� ����� ���Ե˴ϴ�.
		<hr>
		<% pageContext.include("pageContextTest3.jsp"); %>
		<hr>
		<h3>����� pageContext�� forward �޼ҵ�� �������� ������ pageContextTest2.jsp�Դϴ�.</h3>
	</body>
</html>