<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String ID = (String)session.getAttribute("id");
	boolean isLogin = false;
	if(ID != null) {
		isLogin = true;
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<title>�α��� ���� �˻�</title>
		<style>
			body {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<%
			if(isLogin){
		%>
		ID "<%=ID %>"�� �α��� �� �����Դϴ�.<br><br>
		<a href="logout.jsp">�α׾ƿ�</a>
		<%
			} else {
		%>
		�α��� ���� ���� �����Դϴ�.
		<%
			}
		%>
	</body>
</html>