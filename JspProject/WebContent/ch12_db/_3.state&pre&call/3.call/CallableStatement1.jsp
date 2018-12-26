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
		
		sql = "{call del_all()}";
		
		//CallableStatement를 객체를 생성합니다.
		cs = conn.prepareCall(sql);
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
				//close()메서드 실행 후에는 오라클에서 roll back 수행 안됩니다.
				//자원 회수 되면서 오라클에서 자동 커밋이 되었기 때문입니다.
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