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
			<h3>관리자 <%=id %>님 환영합니다.
	<%
		} else {
	%>
			<h3>일반 회원 <%=id %>님 환영합니다.
	<%	}
	}
%>
(<a href="logout.net">로그아웃</a>)</h3>
</div>