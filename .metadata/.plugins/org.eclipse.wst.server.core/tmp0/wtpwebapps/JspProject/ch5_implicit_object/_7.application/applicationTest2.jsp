<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<html>
	<head>
		<title>application Test - 초기화 파라미터 읽어오기</title>
	</head>
	<%--
		application은 서버가 시작돼서 끝날때까지 살아있다(가장 길다)
		-초기화 파라미터는 web.xml에 작성합니다.
		getInitParameterNames() :
			웹 어플리케이션 초기화 파라미터의 이름 목록을 리턴합니다.
		getInitParameter(Name) :
			이름이 Name인 웹 어플리케이션 초기화 파라미터의 값을 읽어옵니다.
			존재하지 않을 경우 null을 리턴합니다.
	 --%>
	<body>
		<h2>초기화 파라미터 목록</h2>
		<ul>
			<%
				Enumeration initParamEnum =
						application.getInitParameterNames();
			
				while (initParamEnum.hasMoreElements()){
					String initParamName =
							(String)initParamEnum.nextElement();
			%>
			<li>
				<%=initParamName %> =
				<%=	application.getInitParameter(initParamName) %>
			</li>
			<%
				}
			%>		
		</ul>
	</body>
</html>