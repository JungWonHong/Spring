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
		<h2>영역과 속성 테스트</h2>
		<table border="1">
			<tr>
				<td colspan="2">Application 영역에 저장된 내용들</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
				<%=application.getAttribute("name") %>
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td>
				<%=application.getAttribute("ID") %>
				</td>
			</tr>
		</table>
		<br>
		<table border="1">
			<tr>
				<td colspan="2">Session 영역에 저장된 내용들</td>
			</tr>
			<%-- <tr>
				<td>집 주소</td>
				<td>
				<%=session.getAttribute("address") %>
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>
				<%=session.getAttribute("tel") %>
				</td>
			</tr>
			<tr>
				<td>e-mail 주소</td>
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