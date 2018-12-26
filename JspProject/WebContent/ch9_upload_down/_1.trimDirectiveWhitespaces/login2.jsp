<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%--실행 후 페이지 소스 보기를 봅니다.
	html 태그 시작전에 줄바꿈 공백 문자가 있습니다.
	이것을 삭제하기 위해 trimDirectiveWhitespaces="true"으로 설정합니다.
	JSP페이지의 응답 결과 페이지에서 디렉티브나 스크립트가 있던 부분이 공백으로
	표시되던 것을 응답 결과에 포함되지 않도록 합니다.
--%>
<%
	boolean isIDShow = false;
	String id = null;
	
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("id")){
				isIDShow = true;
				id = cookies[i].getValue();
			}
		}
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<title>쿠키를 이용한 화면 설정 예제</title>
		<style>
			body {
				margin: 10px auto;
				width: 400px;
			}
			
			fieldset {
				width: 100%;
			}
		</style>
	</head>
	<body>
		<fieldset>
			<form action="loginprocess2.jsp" method="post">
			<%
				if (isIDShow) {
			%>
				<div>ID:</div>
				<input type="text" name="id" value="<%=id%>" id="id" class="length">
				<input type="checkbox" name="idstore" value="store" checked>ID 기억하기<br>
			<%
				} else {
			%>
				<div>ID:</div>
				<input type="text" name="id" id="id" class="length">
				<input type="checkbox" name="idstore" value="store">ID 기억하기<br>
			<%
				}
			%>
				<div>password:</div>
				<input type="text" name="pass" class="length" id="pass"><br>
				<input type="submit" value="전송">
			</form>		
		</fieldset>
	</body>
</html>