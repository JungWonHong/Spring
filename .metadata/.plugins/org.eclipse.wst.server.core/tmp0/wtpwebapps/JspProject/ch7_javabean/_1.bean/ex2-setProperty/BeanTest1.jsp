<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>�ڹٺ��� ��ũ��Ʈ ��ҷ� ������ ���</title>
	</head>
	<body>
		<h1>�ڹٺ� ����</h1>
		<%
			javabean.BeanTest beantest = new javabean.BeanTest();
			pageContext.setAttribute("beantest", beantest);
			beantest.setName("�����Դϴ�.");
		%>
		<h3><%=beantest.getName() %></h3>
	</body>
</html>