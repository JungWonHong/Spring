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
		
		sql = "{call del_name(?)}"; //? ���޵� ��
		
		//CallableStatement�� ��ü�� �����մϴ�.
		cs = conn.prepareCall(sql);
		cs.setString(1, "SCOTT");
		cs.execute();
		
		out.println("���������� ���ν����� �����߽��ϴ�.");
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