<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	session.setMaxInactiveInterval(10); //10�� ���� ���� ����
	//���� ��� - ���� �� 10�� �ȿ� ���� ��ħ(F5)�� ������.
	//			���� �� 10�� �Ŀ� ���� ��ħ(F5)�� ������.
	//10�� �� ���ο� ���� ID�� �����˴ϴ�.
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E���� HH:mm:ss");
%>
<html>
	<head>
		<title>Session Test</title>
	</head>
	<body>
		<h2>���� �׽�Ʈ</h2>
			isNew():<%=session.isNew() %><br>
			���� �����ð�:<%=sdf.format(session.getCreationTime()) %><br>
			���� ���� �ð�:<%=sdf.format(session.getLastAccessedTime()) %><br>
			����ID:<%=session.getId() %><br>
	</body>
</html>