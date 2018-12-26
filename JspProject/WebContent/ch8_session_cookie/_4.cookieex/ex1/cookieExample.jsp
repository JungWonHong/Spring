<%-- --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String language = "korea";

	//header의 이름 중에서 cookie의 값을 가져옵니다.
	String cookie = request.getHeader("Cookie");

	//쿠키가 존재하는지 확인합니다.
	if (cookie != null) {
		//존재하는 쿠키 들을 배열로 가져옵니다.
		Cookie cookies[] = request.getCookies();

		//쿠키의 이름이 "language"인 값을 찾기 위해 쿠키 배열들을 모두 확인합니다.
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("language")) {
				language = cookies[i].getValue();
			}
		}
		out.println(language);
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<title>쿠키를 이용한 화면 설정 예제</title>
		<style>
			body {
				margin: 100px auto;
				text-align: center;
				width: 500px;
			}
			
			fieldset {
				width: 100%;
			}
		</style>
	</head>
	<body>
		<%
			if (language.equals("korea")) {
		%>
		<h3>안녕하세요. 이것은 쿠키 예제입니다.</h3>
		<%
			} else {
		%>
		<h3>Hello. This is Cookie example.</h3>
		<%
			}
		%>
		<fieldset>
			<form action="cookieExample2.jsp" method="post">
				<input type="radio" name="language" value="korea"
					<%
						if (language.equals("korea")) {
					//쿠키값을 확인하여 korea이면 한국어 페이지 보기를 선택한 상태를 설정합니다.
					%> checked <% } %> >한국어 페이지 보기
				<input type="radio" name="language" value="english"
					<%
						if (language.equals("english")) { //쿠키값을 확인하여 english이면 영어 페이지 보기를 선택한 상태를 설정합니다.
					%> checked <% } %> >영어 페이지 보기
				<input type="submit" value="설정">
			</form>
		</fieldset>
	</body>
</html>