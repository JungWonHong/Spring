<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<html>
	<head>
		<title>Request Test2(requestTest2.jsp)</title>
	</head>
	<body>
		<h1>������� ����</h1>
		<table border="1">
			<tr>
				<td>����̸�</td>
				<td>�����</td>
			</tr>
			<% 
			//getHeaderNames()�޼��� : HTTP��û ����� ���Ե� ��� ��� �̸���
			//Enumeration ��ü�� �����մϴ�.
				Enumeration<String> e = request.getHeaderNames();
				while (e.hasMoreElements()) {
					String headerName = e.nextElement();
			%>
			<tr>
				<td><%=headerName %></td>
				<td>
					<%--getHeader(): �Ű������� ������ �̸����� �Ҵ�� ����
									�����մϴ�.
									���� ��� null�� �����մϴ�. --%>
					<%=request.getHeader(headerName) %>
				</td>
			<% 
				}
			%>
			</tr>
		</table>
	</body>
</html>