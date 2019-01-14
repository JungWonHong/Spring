<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.invalidate();//세션 만료
%>
<script>
	alert("로그아웃 되었습니다!");
	location = "khcc_home.nhn";
</script>