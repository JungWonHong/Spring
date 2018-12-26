<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = null;
	
	try {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		//CLOB 데이터를 읽어오기 위해서는 select 문으로 ResultSet객체에 담습니다.
		pstmt = conn.prepareStatement("SELECT * FROM clobtable WHERE num=1");
		rs = pstmt.executeQuery();
		if(rs.next()){
			//getCharacterStream(컬럼명)메서드 : 지정된 열의 값을 검색하여 
			//java.io.Reader 객체로 반환합니다.
			Reader rd = rs.getCharacterStream("content");
			
			sb = new StringBuffer();
			char[] buf = new char[1024];
			int readcnt;
			
			//buf 안에 있는 데이터를 1024만큼 읽어 옵니다.
			while ((readcnt = rd.read(buf, 0, 1024)) != -1) {
				System.out.println("readcon =" + readcnt);
				sb.append(buf, 0, readcnt);
			}
		}
		out.println(sb.toString());
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		
		if(pstmt != null)
			try {
				pstmt.close(); //객체를 사용하고 메모리에 반환합니다.
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