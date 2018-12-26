<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ tag trimDirectiveWhitespaces="true" %>

<%--attribute 디렉티브로 속성을 설정합니다.
	attribute 디렉티브로 속성은 스크립트릿이나
	EL 표현 언어에서 변수로 사용할 수 있습니다.
  예) <%@ attribute name="title" required="true" %>
  	....
  	<%=title> 또는 ${title}
  	
  	name="title" : 속성의 이름이 title
  	required="true" : title 속성은 필수입니다.
--%>
<%@ attribute name="title" required="true" %>

<%-- 
	name="level" : 속성의 이름이 level을 정합니다.
	type="java.lang.Integer" : level 속성의 타입은 Integer입니다.
--%>
<%@ attribute name="level" type="java.lang.Integer" %>
<%
	String headStartTag = null;
	String headEndTag = null;
	
	if(level == null){ //level 속성을 설정하지 않은 경우
		headStartTag = "<h1>";
		headEndTag	 = "</h1>";
	} else if(level == 1){
		headStartTag = "<h1>";
		headEndTag	 = "</h1>";
	} else if(level == 2){
		headStartTag = "<h2>";
		headEndTag	 = "</h2>";
	} else if(level == 3){
		headStartTag = "<h3>";
		headEndTag	 = "</h3>";
	}
%>
<%= headStartTag %>
${title} <%-- 이 태그 파일을 사용하는 JSP는 title 속성을 이용해서
			   태그 파일에 값을 전달할 수 있고 전달 받은 값을 출력합니다. --%>
<%= headEndTag %>