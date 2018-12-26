<%--
	JSP ���þ�(Directive)
	����) <%@	.....	%>
		JSP ���� ������ JSP�� ������ �����̳ʿ��� �ش� �������� ��� ó���� ���ΰ���
		���� ���� �������� ������ �ִµ� ���ȴ�.
	���þ��� ����)
		page ���þ�, include ���þ�, taglib ���þ�
		- page ���þ�� JSP�������� ���� �Ӽ��� �����ϴ� ���þ�
		    ����) <%@ page �Ӽ�=�� ..... %>
		
		- include ���þ�� Ư���� JSP���� �Ǵ� HTML ������ �ش� JSP��������
		    ������ �� �ֵ��� �ϴ� ����� �����ϴ� ���þ��̴�.
		    ����) <%@ include file="���ϰ��" %>
		
		- taglib ���þ�� JSTL(JSP Standard Tag Library)�̳�
		    Ŀ���� �±� �� �±� ���̺귯���� JSP���� ����� �� ���λ縦 �����ϱ� ���� ���
		    ����) <%@ taglib uri="http://taglib.com/sampleURI" 
		    				prefix="samplePrefix" %>
 --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<%-- SimpleDateFormatŬ���� ��� ���� import
	 import �Ӽ� : JSP ���������� ����� Ŭ����(�������̽�) ���� --%>
<%@page import="java.text.SimpleDateFormat" %>

<%-- DateŬ���� ������� import  --%>
<%@page import="java.util.*" %>

<%--�� �� ������ �� �������� ��Ÿ���� ������ �����ϴ�. �޸��� �����ؼ� �ۼ��մϴ�.
<%@page import="java.text.SimpleDateFormat, java.util.*" %>
 --%>
<html>
	<head>
	<!-- <meta>�±״� �˻��������� ������ ������ �� �ƴ϶� �� ���������Ե� ������ �����Ѵ�.
		 5�� �� http://www.naver.com/�� �̵��մϴ�. -->
		<meta http-equiv="refresh"
			  content="5;url=http://www.naver.com/">
		<title>import �Ӽ� �׽�Ʈ</title>
	</head>
	<body>
		<h1> ���� �ð���
		<%=new SimpleDateFormat().format(new Date()) %>�Դϴ�. <br>
		�� �������� 5�� �Ŀ� �ڵ����� �� �������� �̵��մϴ�.
		</h1>
	</body>
</html>