<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
	<head>
		<title>Request Test3(requestTest3.jsp)</title>
	</head>
	<body>
		<h1>��Ű, URL/URI, ��û ��Ŀ� ���õ� ���� ����</h1>
		<table border="1">
			<tr>
				<td>��Ű����</td>
				<% 
					Cookie[] cookie = request.getCookies();
					if (cookie == null) { //ó�� ��û�� ��
				%>		
				<td>��Ű�� �������� �ʽ��ϴ�.</td>
				<%
					} else {
						for (int i = 0; i< cookie.length; i++){
				%>
				<td><%=cookie[i].getName() %>(<%=cookie[i].getValue() %>)
					&nbsp;&nbsp;</td>
				<% 
						}
					}
				%>
				</tr>
				<tr>
					<td>���� �����θ�</td>
					<td><%=request.getServerName() %></td>
				</tr>
				<tr>
					<td>���� ��Ʈ��ȣ</td>
					<td><%=request.getServerPort() %></td>
				</tr>
				<tr>
					<td>��û URL</td>
					<td><%=request.getRequestURL() %></td>
				</tr>
				<tr>
					<td>��û URI(Uniform Resource Identifier)</td>
					<td><%=request.getRequestURI() %></td>
				</tr>
				<tr>
					<td>��û ����</td>
					<td><%=request.getQueryString() %>
				</tr>
				<tr>
					<td>Ŭ���̾�Ʈ IP �ּ�</td>
					<td><%=request.getRemoteAddr() %></td>
				</tr>
				<tr>
					<td>��������</td>
					<td><%=request.getProtocol() %></td>
				</tr>
				<tr>
					<td>��û���</td>
					<td><%=request.getMethod() %></td>
				</tr>
				<tr>
					<td>���ؽ�Ʈ ���
					<%--���ؽ�Ʈ ���(��Ĺ���� Context�� �� ���ø����̼��� �ǹ��մϴ�. --%>
					</td>
					<td><%=request.getContextPath() %></td>
				</tr>
		</table>
	</body>
</html>