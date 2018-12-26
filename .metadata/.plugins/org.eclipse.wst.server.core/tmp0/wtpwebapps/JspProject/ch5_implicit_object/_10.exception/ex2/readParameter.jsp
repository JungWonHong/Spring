<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--에러가 발생할 경우 errorPage 속성에 지정한 페이지를 보여줍니다. --%>
<%@ page errorPage = "../error/viewErrorMessage.jsp" %>
<html>
	<head>
		<title>파라미터 출력</title>
	</head>
	<body>
		name 파라미터 값: <%= request.getParameter("name").toUpperCase() %>
		<%-- name 파라미터의 값을 대문자로 변환하여 출력합니다. --%>
	</body>
</html>