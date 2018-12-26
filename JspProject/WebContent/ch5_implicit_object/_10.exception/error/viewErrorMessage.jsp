<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage = "true"%>
<%-- page 디렉티브의 errorPage 속성을 사용해서 에러 페이지를 지정하면
	 지정한 에러 페이지의 isErrorPage 속성의 값은 "true"이여야 합니다.
	 isErrorPage = "true" : 에러 페이지로 지정함을 의미합니다.
	 에러가 발생할 때 지정한 에러 페이지를 사용하게 됩니다.
	 exception은 page 지시문에서 오류 페이지(isErrorPage = "true") 로
	 지정된 JSP페이지에서 예외가 발생할 때 전달되는
	 java.lang.Throwable의 인스턴스에 대한 참조 변수 입니다. 
--%>
<html>
	<head>
		<title>에러 발생</title>
	</head>
	<body>
		요청 처리 과정에서 에러가 발생하였습니다.<br>
		빠른 시간 내에 문제를 해결하도록 하겠습니다.
		<p>
		에러 타입: <%=exception.getClass().getName() %><br>
		에러 메시지: <b><%=exception.getMessage() %></b>
		</p>
	</body>
</html>