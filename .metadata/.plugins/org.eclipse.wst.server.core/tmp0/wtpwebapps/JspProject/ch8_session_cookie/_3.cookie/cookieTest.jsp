<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<%
			//쿠키 생성합니다.
			//"name" : 쿠키의 이름, "hong" : 쿠키의 값
			Cookie cookie = new Cookie("name", "hong");
		
			//cookie.setMaxAge(60*60*24); //쿠키 유지 시간을 지정합니다.
			//단위는 초로 하루를 지정합니다.
			cookie.setMaxAge(6); //6초동안 쿠키 유지 시간을 지정합니다.
			response.addCookie(cookie); //생성한 쿠키를 클라이언트로 전송합니다.
		%>
		<h2>
			쿠키 이름 :
			<%=cookie.getName() %>
		</h2>
		<h2>
			쿠키 값 : <%=cookie.getValue() %>
		</h2>
		<h2>
			쿠키 유지시간 : <%=cookie.getMaxAge() %>초
			(이 시간이 지난 후 아래의 anchor를 클릭해 보세요)
		</h2>
		<a href="cookieTest2.jsp">쿠키 값 불러오기</a>
	</body>
</html>