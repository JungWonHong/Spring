<%@page import="javabean.BeanJoin"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>

<jsp:useBean id="join" class="javabean.BeanJoin"/>
<%-- �ڹٺ��� ������Ƽ age�� �������� ��� 
	 private int age;
	 �Ķ���ͷ� �Ѱ� ���� ���ڿ� ���ڴ� ���������� ��ȯ�Ǿ� ����˴ϴ�. --%>
<jsp:setProperty name="join" property="*"/>
<!DOCTYPE html>
<html>
	<head>
		<title>ȸ������ �Է� ���� Ȯ�� ������</title>
		<link rel="stylesheet" href="../../css/ch7-1.css" type="text/css">
	</head>
	<body>
		<table>
			<tr>
				<td><font size=2>���̵�</font></td>
				<td><jsp:getProperty name="join" property="id"/></td>
			</tr>
			<tr>
				<td><font size=2>��й�ȣ</font></td>
				<td><jsp:getProperty name="join" property="pass"/></td>
			</tr>
			<tr>
				<td><font size=2>�̸�</font></td>
				<td><jsp:getProperty name="join" property="name"/></td>
			</tr>
			<tr>
				<td><font size=2>����</font></td>
				<td>
				<% 
					if(join.getSex() == 1){
				%>
					<font size=2>����</font>
				<%	
					} else {
				%>
					<font size=2>����</font>
				<%
					}
				%>
				</td>
			</tr>
			<tr>
				<td><font size=2>����</font></td>
				<td><jsp:getProperty name="join" property="age"/></td>
			</tr>
			<tr>
				<td><font size=2>�̸����ּ�</font></td>
				<td><jsp:getProperty name="join" property="email"/></td>
			</tr>
		</table>
		
	</body>
</html>