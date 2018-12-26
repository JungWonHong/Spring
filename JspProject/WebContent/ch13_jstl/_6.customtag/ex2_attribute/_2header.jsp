<%-- 속성 값을 전달하는 예제 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>속성 값을 전달하는 기본 방식</title>
	</head>
	<body>
		<tf:_2header title="텍스트 제목"		level="2" />
		<tf:_2header title="${'EL 제목 ' }"	level="3" />
		<tf:_2header title='<%= "표현식 제목" %>' />
	</body>
</html>