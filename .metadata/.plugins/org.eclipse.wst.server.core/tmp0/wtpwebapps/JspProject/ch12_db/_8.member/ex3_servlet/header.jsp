<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<style>
	div {
		margin-left: 70%;
	}
	a {
		text-decoration: none;
	}
</style>
<div>
<%
	String id = (String)session.getAttribute("id");
	if(id==null) {
		out.println("<script>");
		out.println("location.href='login.net'");
		out.println("</script>");
	} else {
		if(id.equals("admin")){
			%>
			<h3>������ <%=id %>�� ȯ���մϴ�.
	<%
		} else {
	%>
			<h3>�Ϲ� ȸ�� <%=id %>�� ȯ���մϴ�.
	<%	}
	}
%>
(<a href="logout.net">�α׾ƿ�</a>)</h3>
</div>