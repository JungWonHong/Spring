<%--preparedStatementTest.jsp --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	Connection conn = null;
	String sql = "INSERT INTO student(num, name) VALUES (?, '홍길동')";
	PreparedStatement stmt = null;
	try{
		//Context.xml에 리소스를 생성해 놓은(JNDI에 설정해 놓은) OracleDB를 참조
		Context init = new InitialContext();
		DataSource ds = 
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		//가져온 Connection 객체를 사용하여 PreparedStatement객체를 생헝합니다.
		//미리 사용할 SQL문을 인자로 넘깁니다.
		stmt = conn.prepareStatement(sql);
		
		for(int i=7; i<=10; i++){
			stmt.setInt(1, i); //첫번째 인수(num 필드)에 i값을 설정합니다.
			if(stmt.executeUpdate() != 0){ //SQL문 실행합니다.
				out.println("<h3>" + i + "번 레코드를 등록하였습니다.</h3>");
			}
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