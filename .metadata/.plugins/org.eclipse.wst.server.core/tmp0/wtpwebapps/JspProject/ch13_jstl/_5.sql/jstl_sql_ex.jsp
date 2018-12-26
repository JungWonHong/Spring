<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- JSTL sql : sql ���� ����� ������ �ִ� JSTL ���̺귯�� �Դϴ�. -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
	<head>
		<title>JSTL sql ���̺귯�� ��� ����(jstl_sql_ex.jsp)</title>
	</head>
	<body>
		<!-- ������ ���̽� ������ �����մϴ�.
			 var �Ӽ��� Connection ������ ����˴ϴ�.
			 ��, conn ������ ���������� �����մϴ�. -->
		<sql:setDataSource var="conn" 
						   driver="oracle.jdbc.driver.OracleDriver" 
						   url="jdbc:oracle:thin:@localhost:1521:xe" 
						   user="scott"
						   password="tiger"/>
		
		<!-- ���̺� �����մϴ�. -->
		<sql:update dataSource="${conn }">
			create table test(num NUMBER, name varchar2(20))
		</sql:update>
		
		<!-- ���ڵ��� �߰�, ����, ���� ����� �մϴ�.
			 dataSource �Ӽ����� sql:setDataSource ���� ������ ������ �Է��մϴ�. -->
		<sql:update dataSource="${conn }">
			INSERT INTO test (num, name) VALUES (1, 'ȫ�浿')
		</sql:update>
		
		<sql:update dataSource="${conn }">
			INSERT INTO test (num, name) VALUES (2, '���ص�')
		</sql:update>
		
		<sql:update dataSource="${conn }">
			INSERT INTO test (num, name) VALUES (3, 'ȫ�浿')
		</sql:update>
		
		<sql:update dataSource="${conn }">
			INSERT INTO test (num, name) VALUES (4, 'ȫ���')
		</sql:update>
		
		<!-- ������ ���̽��� ������ ������ �� ����մϴ�.
			 var �Ӽ��� �������� SQL������ ����� ����� �����մϴ�. -->
		<sql:query var="rs" dataSource="${conn }">
			SELECT * FROM test WHERE name=?
			<sql:param>ȫ�浿</sql:param>
		</sql:query>
		
		<!-- ���� ���� ����� �ϳ��� ����մϴ�. -->
		<c:forEach var="data" items="${rs.rows }">
			<c:out value="${data }"/>
			<c:out value="${data['num'] }"/>
			<c:out value="${data['name'] }"/>
			<br>
		</c:forEach>
	</body>
</html>