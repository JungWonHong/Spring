<%--
	��ũ��Ʈ��(Scriptlet)
	HTML �ڵ�� �� �κ��� �Ϲ� HTML ����ó�� �״�� ����ϸ�
	�ڹ� �ڵ�� �̷���� ���� �κ��� <%...%>�� ǥ���Ǵ� ��ũ��Ʈ�� �±׸�
	����Ͽ� �����մϴ�.
	
	JSP ������ ����� �� �� �����̳ʿ� ���� JSP �ڵ尡 �Ľ�(Parsing)������
	���ļ� ���� Ŭ������ ��ȯ�˴ϴ�.
	�̶� �Ϲ� ���� Ŭ������ service()�޼��忡 �ش��ϴ�
	_jspService()�ż��尡 �� �����̳ʿ� ���� �ڵ����� �����ǵǸ�
	�� �޼����� ���ο� �Ľ̵� JSP�ڵ尡 ���� �˴ϴ�.
	�̷��� �� �����̳ʿ� ���� ���� Ŭ������ �����Ǹ� �ν��Ͻ��� �����尡 �����ǰ�
	_jspService()�޼��忡 ���� ���� �������� ������� Ŭ���̾�Ʈ�� ���۵Ǿ�
	��� �������� ǥ�õ˴ϴ�.
	
	..\workspace\.metadata\.plugins\org.eclipse.wst.server.core
	\tmp0\work\Catalina\localhost\JspProject\org\apache\jsp\ch4_005fjsp\_005f4_scriptlet
	������ scriptletTest_jsp.java�� scriptletTest_jsp.class ������ �ֽ��ϴ�.
 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Calendar" %>
<%
	Calendar c = Calendar.getInstance();
	int hour = c.get(Calendar.HOUR_OF_DAY);
	int minute = c.get(Calendar.MINUTE);
	int second = c.get(Calendar.SECOND);
%>  
<html>
	<head>
		<title>Scriptlet Test</title>
	</head>
	<body>
		<h1>���� �ð��� <%=hour %>��<%=minute %>��<%=second %>�� �Դϴ�.</h1>
	</body>
</html>