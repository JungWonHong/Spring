<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage = "true"%>
<%-- page ��Ƽ���� errorPage �Ӽ��� ����ؼ� ���� �������� �����ϸ�
	 ������ ���� �������� isErrorPage �Ӽ��� ���� "true"�̿��� �մϴ�.
	 isErrorPage = "true" : ���� �������� �������� �ǹ��մϴ�.
	 ������ �߻��� �� ������ ���� �������� ����ϰ� �˴ϴ�.
	 exception�� page ���ù����� ���� ������(isErrorPage = "true") ��
	 ������ JSP���������� ���ܰ� �߻��� �� ���޵Ǵ�
	 java.lang.Throwable�� �ν��Ͻ��� ���� ���� ���� �Դϴ�. 
--%>
<html>
	<head>
		<title>���� �߻�</title>
	</head>
	<body>
		��û ó�� �������� ������ �߻��Ͽ����ϴ�.<br>
		���� �ð� ���� ������ �ذ��ϵ��� �ϰڽ��ϴ�.
		<p>
		���� Ÿ��: <%=exception.getClass().getName() %><br>
		���� �޽���: <b><%=exception.getMessage() %></b>
		</p>
	</body>
</html>