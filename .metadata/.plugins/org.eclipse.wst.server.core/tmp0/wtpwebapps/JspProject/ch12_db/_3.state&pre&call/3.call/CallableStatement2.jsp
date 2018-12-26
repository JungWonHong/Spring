<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	Connection conn = null;
	String sql;
	CallableStatement cs = null;
	
	try {
		Context init = new InitialContext();
		DataSource ds = 
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		sql = "{call del_name(?)}"; //? 전달될 값
		
		//CallableStatement를 객체를 생성합니다.
		cs = conn.prepareCall(sql);
		cs.setString(1, "SCOTT");
		cs.execute();
		
		out.println("성공적으로 프로시저를 실행했습니다.");
	} catch (Exception e) {
		out.println(e);
		e.printStackTrace();
	} finally {
		if(cs != null)
			try{
				cs.close();
			} catch (SQLException ex) {
			}
		
		if(conn != null)
			try{
				conn.close();
			} catch (SQLException ex) {
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