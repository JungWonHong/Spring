<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>redirect.jsp</title>
	</head>
	<body>
		여기는 redirect.jsp입니다.<br>
		request 속성 값 : <%=request.getAttribute("food") %>
	</body>
</html>
<%-- 
	포워딩 될 때 브라우저의 주소 표시줄의 URL이 변경되므로 요청이 바뀌게 됩니다.
	따라서, 포워딩된 jsp페이지에서는
	서블릿에서 request 영역에 공유한 속성 값에 접근할 수 없습니다.
--%>