<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");
	
	if(id != null && id.length() != 0){
		session.setAttribute("id", id);
	} else {
%>
	<script>
	alert("���̵� �Է��ϼ���!");
	history.back();
	</script>
<% 
	}
%>
<html>
	<head>
		<title>Session Login</title>
		<style>
			body {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<h2>�α��εǾ����ϴ�.</h2>
		<h2>�α��� ���̵� : <%=(String)session.getAttribute("id") %></h2>
		<h2><a href="sessionLogout.jsp">�α׾ƿ�</a></h2>
	</body>
</html>