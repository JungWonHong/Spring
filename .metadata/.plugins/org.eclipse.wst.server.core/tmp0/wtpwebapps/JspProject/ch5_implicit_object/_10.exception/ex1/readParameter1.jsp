<%--오류 발생 : 500 에러 발생 
	java.lang.NullPointerException 발생--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
	<head>
		<title>파라미터 출력</title>
	</head>
	<body>
		<%--파라미터 name으로 요청된 것이 없기 때문에
			request.getParameter("name")은 NullPointerException 발생합니다. 
		--%>
		name 파라미터 값: <%=request.getParameter("name").toUpperCase()%>
	</body>
</html>