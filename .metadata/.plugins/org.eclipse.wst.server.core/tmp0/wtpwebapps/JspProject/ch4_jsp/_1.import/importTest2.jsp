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

<!DOCTYPE html>
<%-- SimpleDateFormat클래스 사용 위해 import
	 import 속성 : JSP 페이지에서 사용할 클래스(인터페이스) 지정 --%>
<%@page import="java.text.SimpleDateFormat" %>

<%-- Date클래스 사용위해 import  --%>
<%@page import="java.util.*" %>

<%--위 두 문장을 한 문장으로 나타내면 다음과 같습니다. 콤마로 구분해서 작성합니다.
<%@page import="java.text.SimpleDateFormat, java.util.*" %>
 --%>
<html>
	<head>
	<!-- <meta>태그는 검색엔진에게 정보를 전달할 뿐 아니라 웹 브라우저에게도 정보를 전달한다.
		 5초 후 http://www.naver.com/로 이동합니다. -->
		<meta http-equiv="refresh"
			  content="5;url=http://www.naver.com/">
		<title>import 속성 테스트</title>
	</head>
	<body>
		<h1> 현재 시간은
		<%=new SimpleDateFormat().format(new Date()) %>입니다. <br>
		이 페이지는 5초 후에 자동으로 새 페이지로 이동합니다.
		</h1>
	</body>
</html>