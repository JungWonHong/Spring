<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	div {
		margin-left: 70%;
	}
	a {
		text-decoration: none;
	}
</style>
<div>
	<c:if test="${empty id }">
		<c:redirect url="/login.net"/>
	</c:if>
	<h3>
	<c:if test="${!empty id }">
		<c:if test="${id=='admin' }">
		������
		</c:if>
		<c:if test="${id!='admin' }">
		�Ϲ�ȸ��
		</c:if>
		${id }�� ȯ���մϴ�.
	</c:if>
(<a href="logout.net">�α׾ƿ�</a>)</h3>
</div>