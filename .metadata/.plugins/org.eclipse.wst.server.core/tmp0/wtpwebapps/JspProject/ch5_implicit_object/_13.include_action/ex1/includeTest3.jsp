<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Include Action Test</title>
	</head>
	<body>
		<h2>include �� ������(includeTest3.jsp)</h2>
		<table>
			<tr>
				<td>�̸�</td>
				<td>
				<%=request.getParameter("name")%>
				</td>
			</tr>
			<tr>
				<td>����</td>
				<td>
				<%=request.getParameter("age")%>
				</td>
			</tr>
			<tr>
				<td>�ּ�</td>
				<td>
				<%=request.getParameter("address")%>
				</td>
			</tr>
			<tr>
				<td>��ȭ��ȣ</td>
				<td>
				<%=request.getParameter("tel")%>
				</td>
			</tr>
			<tr>				
				<td>��Ī</td>
				<td>
				<%=request.getParameter("alias")%>
				</td>
			</tr>
		</table>
	</body>
</html>