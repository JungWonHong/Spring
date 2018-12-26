<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>자바빈을 스크립트 요소로 접근한 경우</title>
	</head>
	<body>
		<h1>자바빈 예제</h1>
		<%
			javabean.BeanTest beantest = new javabean.BeanTest();
			pageContext.setAttribute("beantest", beantest);
			beantest.setName("여름입니다.");
		%>
		<h3><%=beantest.getName() %></h3>
	</body>
</html>