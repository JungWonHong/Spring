<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Forward Action Test</title>
		<link rel="stylesheet" href="../../../css/ch5-5.css" type="text/css">
	</head>
	<body>
		<h2>������ �� ������(forwardTest3.jsp)</h2>
		<table>
			<%
				Enumeration<String> e = request.getParameterNames();
				while(e.hasMoreElements()){
					String attributeName = e.nextElement();
					String attributeValue = (String)request.getParameter(attributeName);
			%>
			<tr>
				<td><%=attributeName %></td>
				<td><%=attributeValue %></td>
			</tr>
			<%
				}
			%>
			<%-- <tr>
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
			</tr> --%>
		</table>
	</body>
</html>