<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<%-- empty 연산자
				형식) empty 값
				: 값이 비어 있거나 null인지를 조사할 때 사용하는 연산자 입니다.
				  값이 null이면 true를 반환합니다.
				  문자열과 배열의 크기가 0인 경우에도 true를 반환합니다.
		 --%>
		<%
			pageContext.setAttribute("food", "과자");
		%>
		<h3>\${pageScope.food}=${pageScope.food}</h3>
		<h3>\${food} = ${food}</h3>
		<h3>\${empty food} = ${empty food}</h3>
		<h3>\${empty food2} = ${empty food2}</h3>
		<h3>\${null==food} = {null==food}</h3>
		<h3>\${null==food2} = {null==food2}</h3>
		
		<%-- name이라는 파라미터가 존재하지 않을 경우 아무 것도 출력되지 않습니다. --%>
		<h3>\${param.name } = ${param.name }</h3>
	</body>
</html>