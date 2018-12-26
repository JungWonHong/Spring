<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	request.setCharacterEncoding("euc-kr"); 
	request.setAttribute("hoho", "안녕하세요~.");	
%>
<!DOCTYPE html>
<html>
	<head>
		<title>EL 내장객체 사용 예제</title>
	</head>
	<body>
		<!-- 세션 객체의 test에 있는 값을 표시합니다. -->
		<h3>세션 영역의 test 값 : ${sessionScope.test}</h3>
		
		<!-- 매개변수로 넘어온 값 중 name 파라미터의 값을 표시합니다. -->
		<h3>name 파라미터의 값 : ${param.name}</h3>
		
		<h3>paramValues.hobby[0] = ${paramValues.hobby[0] }</h3>
		<h3>paramValues.hobby[1] = ${paramValues.hobby[1] }</h3>
		
		<h3>request.setAttribute의 내용은 <%=request.getAttribute("hoho") %></h3>
		<h3>reqeust.setAttribute의 내용은 ${hoho }</h3>
		<h3>reqeust.setAttribute의 내용은 ${requestScope.hoho }</h3>
	</body>
</html>