<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>���� ����</title>
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
			alert('���������� ó�� �Ǿ����ϴ�.');
			location.href='./KHJobs.com';
		</script>
	</body>
</html>