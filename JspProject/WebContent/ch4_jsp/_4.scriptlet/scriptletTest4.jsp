<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Calendar" %>
<%
	Calendar c = Calendar.getInstance();
	int hour = c.get(Calendar.HOUR_OF_DAY);
	int minute = c.get(Calendar.MINUTE);
	int second = c.get(Calendar.SECOND);
%>  
<html>
	<head>
		<title>Scriptlet Test</title>
	</head>
	<body>
		<h1>
			현재 시간은 
			<%=hour %>시
			<%=minute %>분
			<%=second %>초
		</h1>
		<% 
			if (hour >= 12) 
				
		%>
		<h2>오후 입니다.</h2>
		<% 
			 else 
		%>
		<h2>오전 입니다.</h2>
		<% 
			
		%>
	</body>
</html>