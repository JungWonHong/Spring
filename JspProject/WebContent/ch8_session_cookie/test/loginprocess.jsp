<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	boolean isChecked = false;
	String checked = request.getParameter("idstore");
	if(checked!=null && checked.equals("store")){
		isChecked = true;
		Cookie cookie = new Cookie("id", request.getParameter("id"));
		cookie.setMaxAge(60*2);
		
		response.addCookie(cookie);
	}
%>
<html>
	<head>
		<title>Insert title here</title>
		<style>
			body {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<%
			String id = request.getParameter("id");
			String pw = request.getParameter("pass");
			String sid = application.getInitParameter("ID");
			String spw = application.getInitParameter("Pass");
			
			if(id.equals(sid) && pw.equals(spw)){
		%>
		<script>
			alert(<%=sid%> + "�� ȯ���մϴ�.");
		</script>
		<%
			} else if (!(id.equals(sid))) {
		%>
		<script>
			alert("�α��� ID�� �ٸ��ϴ�.");
			history.back();
		</script>
		<%
			} else if (!(pw.equals(spw))) {
		%>
		<script>
			alert("�п��尡 �ٸ��ϴ�.");
			history.back();
		</script>
		<%
			}
		%>
		
		�α��ο� �����߽��ϴ�.<br><br>
		<%
			if (!isChecked) {
		%>
		<a href="loginCheck.jsp">�α��� üũ</a>
		<%
			} else {
		%>
		<a href="loginCheck.jsp">�α��� üũ</a>
		<a href="login.jsp">�α��� ȭ�� �ٽ� ����</a>
		<%
			}
		%>
	</body>
</html>