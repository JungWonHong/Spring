<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	String code = request.getParameter("code");
/* 	String viewPageURI = null;
	if(code.equals("A")){
		viewPageURI = "viewModule/pageA.jsp";
	}else if(code.equals("B")){
		viewPageURI = "viewModule/pageB.jsp";
	}else{
		viewPageURI = "viewModule/pageC.jsp";
	} */
	
	String viewPageURI = "viewModule/page" + code + ".jsp";
%>
<jsp:forward page="<%=viewPageURI%>"/>
