<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
	<head>
		<title>Application Test</title>
	</head>
	<body>
		<%--application ��ü�� �� ���ø����̼� ���ݿ� ���ļ� ���Ǵ� ������ ��� �ֽ��ϴ�. --%>
		<h2>application �׽�Ʈ</h2>
		<table border="1">
			<tr>
				<td>Servlet API������ ����</td>
				<td><%=application.getMajorVersion() %>,
					<%=application.getMinorVersion() %></td>
			</tr>
			<tr>
				<td>�����̳� �̸��� ����</td>
				<td><%=application.getServerInfo() %></td>
			</tr>
			<tr>
				<td>�� ���ø����̼��� ���� ���Ͻý��� ���</td>
				<td><%=application.getRealPath("/") %></td>
			</tr>
		</table>
	</body>
</html>