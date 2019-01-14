<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>email_domain.jsp</title>
<%
   String[] email = {"daum.net", "nate.com", 
         "naver.com", "hotmail.net", "gmail.com", };

   request.setAttribute("email", email);
%>