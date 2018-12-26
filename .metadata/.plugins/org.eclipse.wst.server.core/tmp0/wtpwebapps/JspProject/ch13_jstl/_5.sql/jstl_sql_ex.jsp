<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- JSTL sql : sql 관련 기능을 제공해 주는 JSTL 라이브러리 입니다. -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
	<head>
		<title>JSTL sql 라이브러리 사용 예제(jstl_sql_ex.jsp)</title>
	</head>
	<body>
		<!-- 데이터 베이스 서버에 접속합니다.
			 var 속성에 Connection 정보가 저장됩니다.
			 즉, conn 변수에 연결정보를 저장합니다. -->
		<sql:setDataSource var="conn" 
						   driver="oracle.jdbc.driver.OracleDriver" 
						   url="jdbc:oracle:thin:@localhost:1521:xe" 
						   user="scott"
						   password="tiger"/>
		
		<!-- 테이블 생성합니다. -->
		<sql:update dataSource="${conn }">
			create table test(num NUMBER, name varchar2(20))
		</sql:update>
		
		<!-- 레코드의 추가, 수정, 삭제 기능을 합니다.
			 dataSource 속성에는 sql:setDataSource 에서 지정한 변수를 입력합니다. -->
		<sql:update dataSource="${conn }">
			INSERT INTO test (num, name) VALUES (1, '홍길동')
		</sql:update>
		
		<sql:update dataSource="${conn }">
			INSERT INTO test (num, name) VALUES (2, '조준동')
		</sql:update>
		
		<sql:update dataSource="${conn }">
			INSERT INTO test (num, name) VALUES (3, '홍길동')
		</sql:update>
		
		<sql:update dataSource="${conn }">
			INSERT INTO test (num, name) VALUES (4, '홍길순')
		</sql:update>
		
		<!-- 데이터 베이스에 쿼리를 전송할 때 사용합니다.
			 var 속성의 변수에는 SQL쿼리가 실행된 결과를 저장합니다. -->
		<sql:query var="rs" dataSource="${conn }">
			SELECT * FROM test WHERE name=?
			<sql:param>홍길동</sql:param>
		</sql:query>
		
		<!-- 위의 쿼리 결과를 하나씩 출력합니다. -->
		<c:forEach var="data" items="${rs.rows }">
			<c:out value="${data }"/>
			<c:out value="${data['num'] }"/>
			<c:out value="${data['name'] }"/>
			<br>
		</c:forEach>
	</body>
</html>