<%--statementTest.jsp --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	Connection conn = null;
	String sql = "INSERT INTO student(num, name) VALUES (11, '홍길동')";
	Statement stmt = null;
	try{
		//JNDI를 이용하여 연결된 Connection 객체를 가져옵니다.
		Context init = new InitialContext();
		DataSource ds = 
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		//Statement 객체를 생성합니다.
		stmt = conn.createStatement();
		
		//삽입, 수정, 삭제와 관련된 SQL문을 실행합니다.
		//적용된 행의 수를 반환합니다.
		int result = stmt.executeUpdate(sql);
		System.out.println("executeUpdate 결과는 = " + result);
		if(result != 0){
			out.println("<h3>레코드가 등록되었습니다.</h3>");
		}
	} catch (Exception e) {
		out.println("<h3>레코드 등록에 실패하였습니다.</h3>");
		e.printStackTrace();
	} finally {
		if(stmt != null)
			try {
				stmt.close(); //객체를 사용하고 메모리에 반환합니다.
							  //메모리 낭비를 막을 수 있습니다.
			} catch (SQLException ex) {
			}
		
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException ex){
			}
	}
			
%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
	</head>
	<body>
		
	</body>
</html>