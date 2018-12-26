<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ch12.db.Member" %>
<!DOCTYPE html>
<html>
	<head>
		<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
		<style>
			table {
				margin: 0 auto;
				width: 400px;
			}
			td:nth-child(2n) {
				background: #adf1ad;
			}
			td:nth-child(2n+1) {
				background: #cec8f1;
			}
			tr:first-child>td {
				background: #e9c9b7;
			}
			tr {
				text-align: center;
			}
			td {
				height: 30px;
			}
			a {
				text-decoration: none;
			}
		</style>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<%
			ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("totallist");
		%>
		<table>
			<tr>
				<td colspan = 2>회원 목록</td>
			</tr>
			<%
				for(Member m : list) {
			%>
			<tr>
				<td><a href="member_info.net?id=<%=m.getId() %>"><%=m.getId() %></a></td>
				<td><a href="member_delete.net?id=<%=m.getId() %>">삭제</a>
			</tr>
			<%
				}
			%>			
		</table>
	</body>
</html>