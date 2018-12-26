<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<link href="./css/top.css" type="text/css" rel="stylesheet">
<link href="./css/board.css" type="text/css" rel="stylesheet">
<html>
	<head>
		<title>Logout</title>
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