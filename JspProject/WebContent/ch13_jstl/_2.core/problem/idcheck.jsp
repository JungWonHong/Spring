<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>idcheck.jsp</title>
</head>
<body>
  <% request.setCharacterEncoding("euc-kr"); %>
  <%= request.getParameter("id") %> �ߺ� �˻��մϴ�.
</body>
</html>