<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Include Action Test</title>
	</head>
	<body>
		<h2>include 된 페이지(includeTest3.jsp)</h2>
		<table>
			<tr>
				<td>이름</td>
				<td>
				<%=request.getParameter("name")%>
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>
				<%=request.getParameter("age")%>
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
				<%=request.getParameter("address")%>
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>
				<%=request.getParameter("tel")%>
				</td>
			</tr>
			<tr>				
				<td>별칭</td>
				<td>
				<%=request.getParameter("alias")%>
				</td>
			</tr>
		</table>
	</body>
</html>