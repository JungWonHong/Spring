<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String filename1 = request.getParameter("filename1");
	String filename2 = request.getParameter("filename2");
	String origfilename1 = request.getParameter("origfilename1");
	String origfilename2 = request.getParameter("origfilename2");
%>
<html>
	<head>
		<title>���� ���ε� Ȯ�� �� �ٿ�ε�</title>
		<style>
			table {
				margin: 0 auto;
				width: 400px;
			}
			
			table, tr, td {
				border: 1px solid black;
				text-align: center;
			}
			
			tr {
				height: 30px
			}
			
			tr:first-child {
				height: 60px;
				background: yellow;
				font-weight: bold;
			}
			
			tr>td:first-child {
				width: 45%
			}
		</style>
	</head>
	<body>
		<table border=1>
			<tr>
				<td colspan=2>���� �ٿ�ε� ��</td>
			</tr>
			<tr>
				<td>�ø� ���</td>
				<td><%=name %></td>
			</tr>
			<tr>
				<td>����</td>
				<td><%=subject %></td>
			</tr>
			<tr>
				<td>���ϸ�1</td>
				<td>
				<a href="file_down.jsp?file_name=<%=filename1%>"><%=origfilename1%></a>
				</td>
			</tr>
			<tr>
				<td>���ϸ�2</td>
				<td>
				<a href="file_down.jsp?file_name=<%=filename2%>"><%=origfilename2%></a>
				</td>
			</tr>
		</table>
	</body>
</html>