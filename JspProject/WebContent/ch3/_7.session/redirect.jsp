<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<title>redirect.jsp</title>
	</head>
	<body>
		����� redirect.jsp�Դϴ�.<br>
		request �Ӽ� �� : <%=request.getAttribute("food") %><br>
		session �Ӽ� �� : <%=session.getAttribute("food") %>
	</body>
</html>
<%-- 
	������ �� �� �������� �ּ� ǥ������ URL�� ����ǹǷ� ��û�� �ٲ�� �˴ϴ�.
	����, �������� jsp������������
	�������� request ������ ������ �Ӽ� ���� ������ �� �����ϴ�.
--%>