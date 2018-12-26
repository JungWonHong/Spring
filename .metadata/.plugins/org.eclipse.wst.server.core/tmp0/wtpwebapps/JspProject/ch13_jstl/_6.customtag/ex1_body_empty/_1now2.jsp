<%-- _1now.tag의 body-content="empty" 인 경우
	  태그 사이에 아무것도 넣지 마세요 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>now</title>
	</head>
	<body>
		지금은<b><tf:_1now2/></b> 입니다. <%-- _1now는 태그 파일의 이름입니다. --%>
	</body>
</html>