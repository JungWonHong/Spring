<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>complete</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("euc-kr");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			session.setAttribute("email", email);
			session.setAttribute("address", address);
			session.setAttribute("tel", tel);
			//String name = (String)application.getAttribute("name");
		%>
		<h2>영역과 속성 테스트</h2>
		<h3>
		<%--<%=name%> --%>
		<%=application.getAttribute("name") %>님의 정보가 모두 저장되었습니다.
		</h3>
		<a href="checkPage.jsp">확인하러 가기</a>
	</body>
</html>