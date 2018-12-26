<%--
	JSP 지시어(Directive)
	형식) <%@	.....	%>
		JSP 파일 내에서 JSP를 실행할 컨테이너에서 해당 페이지를 어떻게 처리할 것인가에
		대한 설정 정보들을 지정해 주는데 사용된다.
	지시어의 종류)
		page 지시어, include 지시어, taglib 지시어
		- page 지시어는 JSP페이지에 대한 속성을 지정하는 지시어
		    형식) <%@ page 속성=값 ..... %>
		
		- include 지시어는 특정한 JSP파일 또는 HTML 파일을 해당 JSP페이지에
		    삽입할 수 있도록 하는 기능을 제공하는 지시어이다.
		    형식) <%@ include file="파일경로" %>
		
		- taglib 지시어는 JSTL(JSP Standard Tag Library)이나
		    커스텀 태그 등 태그 라이브러리를 JSP에서 사용할 때 접두사를 지정하기 위해 사용
		    형식) <%@ taglib uri="http://taglib.com/sampleURI" 
		    				prefix="samplePrefix" %>
 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!-- 1. contentType:
		JSP페이지가 생성하는 문서의 종류와 그 문서를 웹 브라우저로 전송할 때 사용되는
		인코딩 타입입니다.
		문서의 종류는 생성할 응답의 형태가 어더한 MIME형식으로 되어 있는지
		지정하는 속성입니다.
		
		MIME(Multipurpose Internet Main Extension)란
		인터넷을 통해 문서를 주고 받을 때 사용되는 문서 형식을 정의해 놓은 것입니다.
		예로 text/html, image/gif, video/avi 등 여러 가지 타입을 제공합니다.
		
	 2. charset=EUC-KR은 생략할 수 있습니다.
		생략할 경우 기본 캐릭터셋인 ISO-8859-1을 사용하게 됩니다.
		
	 3. pageEncoding :
	 	현재 페이지의 문자 인코딩 방식을 지정할 때 사용하는 속성입니다.
 -->
<!DOCTYPE html>
<%-- SimpleDateFormat클래스 사용 위해 import
	 import 속성 : JSP 페이지에서 사용할 클래스(인터페이스) 지정 --%>
<%@page import="java.text.SimpleDateFormat" %>

<%-- Date클래스 사용위해 import  --%>
<%@page import="java.util.*" %>
<html>
	<head>
		<title>import 속성 테스트</title>
	</head>
	<body>
		<h1> 현재 시간은
		<%=new SimpleDateFormat().format(new Date()) %>입니다.
		</h1>
	</body>
</html>