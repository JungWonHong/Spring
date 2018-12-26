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
		
		//CLOB �����͸� �о���� ���ؼ��� select ������ ResultSet��ü�� ����ϴ�.
		pstmt = conn.prepareStatement("SELECT * FROM clobtable WHERE num=1");
		rs = pstmt.executeQuery();
		if(rs.next()){
			//getCharacterStream(�÷���)�޼��� : ������ ���� ���� �˻��Ͽ� 
			//java.io.Reader ��ü�� ��ȯ�մϴ�.
			Reader rd = rs.getCharacterStream("content");
			
			sb = new StringBuffer();
			char[] buf = new char[1024];
			int readcnt;
			
			//buf �ȿ� �ִ� �����͸� 1024��ŭ �о� �ɴϴ�.
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
				pstmt.close(); //��ü�� ����ϰ� �޸𸮿� ��ȯ�մϴ�.
							  //�޸� ���� ���� �� �ֽ��ϴ�.
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