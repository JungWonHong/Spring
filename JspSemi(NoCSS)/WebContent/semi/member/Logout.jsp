<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<%
			if(session != null && session.getAttribute("id") != null){
				session.invalidate();
			}
		%>
		<script>
			alert('로그아웃 되었습니다.');
			location.href='./KHJobs.com';
		</script>
	</body>
</html>