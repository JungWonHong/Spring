<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--������ �߻��� ��� errorPage �Ӽ��� ������ �������� �����ݴϴ�. --%>
<%@ page errorPage = "../error/viewErrorMessage.jsp" %>
<html>
	<head>
		<title>�Ķ���� ���</title>
	</head>
	<body>
		name �Ķ���� ��: <%= request.getParameter("name").toUpperCase() %>
		<%-- name �Ķ������ ���� �빮�ڷ� ��ȯ�Ͽ� ����մϴ�. --%>
	</body>
</html>