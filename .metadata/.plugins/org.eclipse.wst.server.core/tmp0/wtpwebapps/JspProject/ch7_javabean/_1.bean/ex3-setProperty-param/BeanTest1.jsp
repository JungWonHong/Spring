<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("euc-kr"); %>
<!DOCTYPE html>
<html>
	<head>
	</head>
	<body>
		<jsp:useBean id="beantest" class="javabean.BeanTest"/>
		<jsp:setProperty name="beantest" property="name" param="name"/>
		<%-- 클라이언트에서 'name'이라는 이름의 파라미터 값을
			 name 프로퍼티에 할당(저장)하겠다는 의미입니다.
			 property와 param 속성의 값이 같은 경우 param 속성은 생략 가능합니다.
			 <jsp:setProperty name="beantest" property="name"/>
			 
			 property의 속성 값을 "*"로 지정하면 각각의 프로퍼티의 값을 같은 이름을 갖는
			 파라미터의 값으로 설정합니다.
			 <jsp:setProperty name="beantest" property="*"/> 
		--%>
		
		<h1>자바빈 예제</h1>
		<h3><jsp:getProperty name="beantest" property="name"/></h3>
	</body>
</html>