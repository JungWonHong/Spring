<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.Enumeration"%>
 
<!Doctype html>
<html>
<head>
<title>Attribute Test</title>
<link rel="stylesheet" href="ch5-2.css" type="text/css">
</head>
<body>
	<h2>������ �Ӽ� �׽�Ʈ</h2>
	<table border="1">
		<tr>
			<td colspan="2">Application ������ ����� �����</td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td><%=application.getAttribute("name")%></td>
		</tr>
		<tr>
			<td>���̵�</td>
			<td><%=application.getAttribute("id")%></td>
		</tr>
	</table>
	<br>
	<table border="1">
		<tr>
			<td colspan="2">Session ������ ����� �����</td>
		</tr>
		<%
			Enumeration<String> e = session.getAttributeNames();
			while (e.hasMoreElements()) {
			   String attributeName =  e.nextElement();
			   String attributeValue = 
					 (String) session.getAttribute(attributeName);
		%>
		<tr>
			<td><%=attributeName%></td>
			<td><%=attributeValue%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
