<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	request.setCharacterEncoding("euc-kr"); 
	request.setAttribute("hoho", "�ȳ��ϼ���~.");	
%>
<!DOCTYPE html>
<html>
	<head>
		<title>EL ���尴ü ��� ����</title>
	</head>
	<body>
		<!-- ���� ��ü�� test�� �ִ� ���� ǥ���մϴ�. -->
		<h3>���� ������ test �� : ${sessionScope.test}</h3>
		
		<!-- �Ű������� �Ѿ�� �� �� name �Ķ������ ���� ǥ���մϴ�. -->
		<h3>name �Ķ������ �� : ${param.name}</h3>
		
		<h3>paramValues.hobby[0] = ${paramValues.hobby[0] }</h3>
		<h3>paramValues.hobby[1] = ${paramValues.hobby[1] }</h3>
		
		<h3>request.setAttribute�� ������ <%=request.getAttribute("hoho") %></h3>
		<h3>reqeust.setAttribute�� ������ ${hoho }</h3>
		<h3>reqeust.setAttribute�� ������ ${requestScope.hoho }</h3>
	</body>
</html>