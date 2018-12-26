<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<table>
			<tr>
				<td colspan = 2>회원 목록</td>
			</tr>
			<c:forEach var="m" items="${totallist }">
			<tr>
				<td><a href="member_info.net?id=${m.id }">${m.id }</a></td>
				<td>${m.name }</td>
				<td><a href="member_delete.net?id=${m.id }">삭제</a>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>