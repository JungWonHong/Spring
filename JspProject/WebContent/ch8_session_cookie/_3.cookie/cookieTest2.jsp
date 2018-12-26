<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Cookie Test</title>
	</head>
	<body>
		<%
			String name = "";
			String value = "";

			//쿠키가 생성되어 있는지 확인합니다.
			String cookie = request.getHeader("Cookie");

			if (cookie != null) {
				//쿠키들을 배열로 가져옵니다.
				Cookie cookies[] = request.getCookies();

				//쿠키 배열에서 쿠키 이름이 "name"인 것을 찾아서 쿠키의 이름과 값을 가져옵니다.
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("name")) {
						name = cookies[i].getName(); //쿠키의 이름을 가져옵니다.
						value = cookies[i].getValue(); //쿠키의 값을 가져옵니다.
					}
				}
		%>
		<h2>쿠키 이름 = <%=name %></h2>
		<h2>쿠키 값 = <%=value %></h2>
		<%
			} else {
		%>
			존재하는 쿠키가 없습니다.
		<%
			}
		%>
	</body>
</html>