<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>complete</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("euc-kr");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			session.setAttribute("email", email);
			session.setAttribute("address", address);
			session.setAttribute("tel", tel);
			//String name = (String)application.getAttribute("name");
		%>
		<h2>������ �Ӽ� �׽�Ʈ</h2>
		<h3>
		<%--<%=name%> --%>
		<%=application.getAttribute("name") %>���� ������ ��� ����Ǿ����ϴ�.
		</h3>
		<a href="checkPage.jsp">Ȯ���Ϸ� ����</a>
	</body>
</html>