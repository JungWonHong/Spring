<%-- 
	pageContext :
	�ϳ��� ������ �����ϰ� ������ �����ϵ��� �����ִ� ��ü�Դϴ�.
	�ϳ��� ������ �ϳ��� pageContext�� �����մϴ�.
	�ϳ��� JSP ���������� �ϳ��� PageContext ��ü�� �����մϴ�.
	
	http://localhost:8088/JspProject/ch5/_5.pageContext/_1.forward_include_method/pageContext1.jsp
	��û������ pageContextTest2.jsp�� ��� ȭ���� ��µ˴ϴ�.
	�ּ� ������ ���� �ʽ��ϴ�. ��, request��ü�� ����� �� �ֽ��ϴ�.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<h2>����� 1�� ������ ���� : ���� ��µ��� �ʾƿ�</h2>
<%--forward() : ���ڰ����� ������ �������� �̵� --%>
<%
	 pageContext.forward("pageContextTest2.jsp");
%>
<h2>����� 1�� ������ �� : ����� ������ �ʾƿ�</h2>