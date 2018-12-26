<%--실행하기 위해서 다음 경로에 test_ko.properties, test.properties를 복사합니다. 
	
	C:\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JspProject\WEB-INF\classes
	또는
	이클립스의 WEB-INF\classes에 복사합니다.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--fmt: 국제화/형식화의 기능을 제공해 주는 JSTL 라이브러리 입니다.
	fmt 라이브러리를 등록하는 코드 입니다. --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<title>JSTL fmt 라이브러리 사용 예제</title>
	</head>
	<body>
		<%--<fmt:setLocale> 다국어 페이지를 사용할 때 언어를 지정하는 태그입니다.
			value : 어떤 언어를 사용할 지 지정하는 속성입니다.
					ko_KR에서 ko는 한글의 언어 코드이고 KR은 한국의 국가 코드를 의미합니다.
					value값이 null이면 기본 로케일이 사용됩니다.
		 --%>
		<%--<fmt:setLocale value="en_US"/> --%>
		<fmt:setLocale value="ko_KR"/>
		
		<fmt:bundle basename="test">
		<%--<fmt:bundle>
			properties 확장명을 가진 파일의 리소스를 불러올 때 사용합니다.
			basename에는 properties 확장명을 가진 파일을 지정할 수 있습니다. 
		
		예) <fmt:setLocale value="ko_KR">인 경우 파일명은
			"test" + "_" + "ko" + ".properties"
			=> "test_ko.properties" 이어야 합니다.
		
		예) <fmt:setLocale value="en_US">인 경우 파일명은
			"test" + ".properties"
			=> "test.properties" 이어야 합니다.	
		--%>
			<%--설정한 properties 파일의 리소스 내용을 읽을 때 사용합니다. 
				key속성을 이용하여 키 값으로 설정된 내용을 가져옵니다.--%>
			<fmt:message key="name"/><br>
			<fmt:message key="say"/><br>
			<fmt:message key="say2">
			<%--fmt:message 태그로 읽어 온 리소스 내용에 파라미터를 전달하는 태그입니다.
				test.properties에 {0}로 전달됩니다.(setLocale이 en_US일때)
				test_ko.properties에 {0}로 전달됩니다.(setLocale이 ko_KR일때) --%>
				<fmt:param value="고길동"/>
				
			<%--test.properties에 {1}로 전달됩니다.(setLocale이 en_US일때)
				test_ko.properties에 {1}로 전달됩니다.(setLocale이 ko_KO일때) --%>
				<fmt:param value="전우치"/>
				
			</fmt:message>
		</fmt:bundle>
	</body>
</html>