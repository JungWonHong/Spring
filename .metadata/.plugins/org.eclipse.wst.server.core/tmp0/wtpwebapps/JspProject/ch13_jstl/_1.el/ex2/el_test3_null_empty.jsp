<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		<%-- empty ������
				����) empty ��
				: ���� ��� �ְų� null������ ������ �� ����ϴ� ������ �Դϴ�.
				  ���� null�̸� true�� ��ȯ�մϴ�.
				  ���ڿ��� �迭�� ũ�Ⱑ 0�� ��쿡�� true�� ��ȯ�մϴ�.
		 --%>
		<%
			pageContext.setAttribute("food", "����");
		%>
		<h3>\${pageScope.food}=${pageScope.food}</h3>
		<h3>\${food} = ${food}</h3>
		<h3>\${empty food} = ${empty food}</h3>
		<h3>\${empty food2} = ${empty food2}</h3>
		<h3>\${null==food} = {null==food}</h3>
		<h3>\${null==food2} = {null==food2}</h3>
		
		<%-- name�̶�� �Ķ���Ͱ� �������� ���� ��� �ƹ� �͵� ��µ��� �ʽ��ϴ�. --%>
		<h3>\${param.name } = ${param.name }</h3>
	</body>
</html>