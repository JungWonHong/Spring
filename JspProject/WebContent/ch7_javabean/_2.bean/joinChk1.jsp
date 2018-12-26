<%@page import="javabean.BeanJoin"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>

<jsp:useBean id="join" class="javabean.BeanJoin"/>
<%-- 자바빈의 프로퍼티 age가 정수형인 경우 
	 private int age;
	 파라미터로 넘겨 받은 문자열 숫자는 정수형으로 변환되어 저장됩니다. --%>
<jsp:setProperty name="join" property="*"/>
<!DOCTYPE html>
<html>
	<head>
		<title>회원가입 입력 정보 확인 페이지</title>
		<link rel="stylesheet" href="../../css/ch7-1.css" type="text/css">
	</head>
	<body>
		<table>
			<tr>
				<td><font size=2>아이디</font></td>
				<td><jsp:getProperty name="join" property="id"/></td>
			</tr>
			<tr>
				<td><font size=2>비밀번호</font></td>
				<td><jsp:getProperty name="join" property="pass"/></td>
			</tr>
			<tr>
				<td><font size=2>이름</font></td>
				<td><jsp:getProperty name="join" property="name"/></td>
			</tr>
			<tr>
				<td><font size=2>성별</font></td>
				<td>
				<% 
					if(join.getSex() == 1){
				%>
					<font size=2>남자</font>
				<%	
					} else {
				%>
					<font size=2>여자</font>
				<%
					}
				%>
				</td>
			</tr>
			<tr>
				<td><font size=2>나이</font></td>
				<td><jsp:getProperty name="join" property="age"/></td>
			</tr>
			<tr>
				<td><font size=2>이메일주소</font></td>
				<td><jsp:getProperty name="join" property="email"/></td>
			</tr>
		</table>
		
	</body>
</html>