<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
	<head>
		<title>loginSuccess.jsp</title>
	</head>
	<body>
		<% 
			String id = request.getParameter("id");
			String pw = request.getParameter("passwd");
			
			String p_id = config.getInitParameter("ID");
			String p_pw = config.getInitParameter("PW");
			
			if(id.equals(p_id) && pw.equals(p_pw)){
		%>
		<p>�α��ο� �����ϼ̽��ϴ�.</p>
		<%
			} else {
		%>
		<p>�α��ο� �����ϼ̽��ϴ�.</p>
		<%
			}
		%>
	</body>
</html>