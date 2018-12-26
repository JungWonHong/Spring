<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	session.setMaxInactiveInterval(10); //10초 동안 세션 유지
	//실행 방법 - 실행 후 10초 안에 새로 고침(F5)해 보세요.
	//			실행 후 10초 후에 새로 고침(F5)해 보세요.
	//10초 후 새로운 세션 ID로 생성됩니다.
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E요일 HH:mm:ss");
%>
<html>
	<head>
		<title>Session Test</title>
	</head>
	<body>
		<h2>세션 테스트</h2>
			isNew():<%=session.isNew() %><br>
			세션 생성시간:<%=sdf.format(session.getCreationTime()) %><br>
			최종 접속 시간:<%=sdf.format(session.getLastAccessedTime()) %><br>
			세션ID:<%=session.getId() %><br>
	</body>
</html>