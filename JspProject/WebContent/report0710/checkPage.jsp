<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<% request.setCharacterEncoding("euc-kr"); %>
		<h2>������ �Ӽ� �׽�Ʈ</h2>
		<table border="1">
			<tr>
				<td colspan="2">Application ������ ����� �����</td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td>
				<%=application.getAttribute("name") %>
				</td>
			</tr>
			<tr>
				<td>���̵�</td>
				<td>
				<%=application.getAttribute("ID") %>
				</td>
			</tr>
		</table>
		<br>
		<table border="1">
			<tr>
				<td colspan="2">Session ������ ����� �����</td>
			</tr>
			<%-- <tr>
				<td>�� �ּ�</td>
				<td>
				<%=session.getAttribute("address") %>
				</td>
			</tr>
			<tr>
				<td>��ȭ��ȣ</td>
				<td>
				<%=session.getAttribute("tel") %>
				</td>
			</tr>
			<tr>
				<td>e-mail �ּ�</td>
				<td>
				<%=session.getAttribute("email") %>
				</td>
			</tr> --%>
			<%
				Enumeration<String> e = session.getAttributeNames();
				while(e.hasMoreElements()){
					String attributeName = e.nextElement();
					String attributeValue = (String) session.getAttribute(attributeName);
			%>
			<tr>
				<td><%=attributeName %></td>
				<td><%=attributeValue %></td>
			</tr>
			<%
				}
			%>
		</table>
	</body>
</html>