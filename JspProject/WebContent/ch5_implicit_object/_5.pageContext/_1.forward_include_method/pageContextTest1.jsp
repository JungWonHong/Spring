<%-- 
	pageContext :
	하나의 서블릿을 관리하고 정보를 공유하도록 도와주는 객체입니다.
	하나의 서블릿에 하나의 pageContext가 존재합니다.
	하나의 JSP 페이지에는 하나의 PageContext 객체가 존재합니다.
	
	http://localhost:8088/JspProject/ch5/_5.pageContext/_1.forward_include_method/pageContext1.jsp
	요청하지만 pageContextTest2.jsp의 결과 화면이 출력됩니다.
	주소 변경이 되지 않습니다. 즉, request객체를 사용할 수 있습니다.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<h2>여기는 1번 페이지 시작 : 저는 출력되지 않아요</h2>
<%--forward() : 인자값으로 지정된 페이지로 이동 --%>
<%
	 pageContext.forward("pageContextTest2.jsp");
%>
<h2>여기는 1번 페이지 끝 : 여기로 오지도 않아요</h2>