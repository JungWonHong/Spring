<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>삭제 성공</title>
		<link href="./css/board.css" rel="stylesheet" type="text/css"/>
		<link href="./css/top.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<%
			if(session != null && session.getAttribute("id") != null){
				session.invalidate();
			}
		%>
		<script>
			alert('정상적으로 처리 되었습니다.');
			location.href='./KHJobs.com';
		</script>
	</body>
</html>