<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>ȸ������ �ý��� ���� ������</title>
		<style>
			body {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<%@ include file="header.jsp" %>
		<%
			if(id.equals("admin")){
		%>
			<a href="member_list.net">�����ڸ�� ����(ȸ�� ��� ����)</a>
		<%
			}
		%>
		
	</body>
</html>