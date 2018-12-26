<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="ch12.db.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
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
			tr:last-child>td {
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
				<td>���̵�</td>
				<td>${memberinfo.id }</td>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td>${memberinfo.password }</td>
			</tr>
			<tr>
				<td>�̸�</td>
				<td>${memberinfo.name }</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${memberinfo.age }</td>
			</tr>
			
			<tr>
				<td>����</td>
				<td>${memberinfo.gender }</td>
			</tr>
			<tr>
				<td>�̸��� �ּ�</td>
				<td>${memberinfo.email }</td>
			</tr>
			<tr>
				<td colspan=2><a href="member_list.net">����Ʈ�� ���ư���</a></td>
			</tr>
		</table>
	</body>
</html>