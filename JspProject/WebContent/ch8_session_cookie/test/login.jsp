<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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