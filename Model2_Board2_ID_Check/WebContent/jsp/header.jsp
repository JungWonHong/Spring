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
		관리자
		</c:if>
		<c:if test="${id!='admin' }">
		일반회원
		</c:if>
		${id }님 환영합니다.
	</c:if>
(<a href="logout.net">로그아웃</a>)</h3>
</div>