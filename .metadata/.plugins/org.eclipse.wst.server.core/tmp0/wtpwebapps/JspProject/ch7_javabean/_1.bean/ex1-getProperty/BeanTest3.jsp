<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>자바빈을 스크립트 요소로 접근한 경우2</title>
	</head>
	<body>
		<h1>자바빈 예제</h1>
		<jsp:useBean id="beantest" class="javabean.BeanTest" scope="page"/>
		<%-- id	    속성 : JSP에서 자바빈 객체의 변수명 
			class 속성 : 자바빈 설계 규약에 맞게 작성된 클래스명을 적어 주어야 합니다.
					      클래스가 패키지 안에 작성되어 있다면 패키지 경로까지 적어 주어야 합니다.
			scope 속성 : 사용 범위로 page(기본값-pageContext객체), request, 
						session, application 네 종류
						
			위의 태그는 다음과 같은 비슷한 의미입니다.
			javabean.BeanTest beantest = new javabean.BeanTest();
			pageContext.setAttribute("beantest", beantest);
		--%>
		<h3><jsp:getProperty name="beantest" property="name"/></h3>
		<%-- <%=beantest.getName() %>를 <jsp:getProperty>액션 태그로 사용한
     		 name : <jsp:useBean>의 id 속성에서 지정한 자바빈 객체의 이름
      		 property : 출력할 프로퍼티의 이름
   --%>
	</body>
</html>