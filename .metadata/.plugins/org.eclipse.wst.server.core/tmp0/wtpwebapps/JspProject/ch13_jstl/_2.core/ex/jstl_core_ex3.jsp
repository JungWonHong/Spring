<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--url�� �����ϴ� ����� �մϴ�.
	�� �±׸� ����ϸ� ���� �Ű������� ������ URL�� �ս��� ���� �� �ֽ��ϴ�. --%>
<c:url var="ex" value="http://localhost:8088/JspProject/ch13_jstl/_2.core/ex/jstl_core_ex1.jsp"/>
	<a href="${ex }">ó�� ������ �̵�</a>
<br>
<br>

<%--<c:param>�±׿� �Ķ���͸� �����ϱ� ���� �±��Դϴ�.
	name �Ӽ��� �Ķ�����̸��� �Է��ϰ� value�� ���� �Է��Ͽ� �����մϴ�. --%>
<c:url var="ex" value="http://localhost:8088/JspProject/ch13_jstl/_2.core/ex/jstl_core_ex4.jsp">
	<c:param name="id" value="start"/>
	<c:param name="name" value="ȫ�浿"/>
</c:url>
<a href="${ex }">�Ű����� ���� ������ �̵�</a>
