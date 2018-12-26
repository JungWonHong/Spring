<%--preparedStatementTest.jsp --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	Connection conn = null;
	String sql = "INSERT INTO student(num, name) VALUES (?, 'ȫ�浿')";
	PreparedStatement stmt = null;
	try{
		//Context.xml�� ���ҽ��� ������ ����(JNDI�� ������ ����) OracleDB�� ����
		Context init = new InitialContext();
		DataSource ds = 
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		//������ Connection ��ü�� ����Ͽ� PreparedStatement��ü�� �����մϴ�.
		//�̸� ����� SQL���� ���ڷ� �ѱ�ϴ�.
		stmt = conn.prepareStatement(sql);
		
		for(int i=7; i<=10; i++){
			stmt.setInt(1, i); //ù��° �μ�(num �ʵ�)�� i���� �����մϴ�.
			if(stmt.executeUpdate() != 0){ //SQL�� �����մϴ�.
				out.println("<h3>" + i + "�� ���ڵ带 ����Ͽ����ϴ�.</h3>");
			}
		}
	} catch (Exception e) {
		out.println("<h3>���ڵ� ��Ͽ� �����Ͽ����ϴ�.</h3>");
		e.printStackTrace();
	} finally {
		if(stmt != null)
			try {
				stmt.close(); //��ü�� ����ϰ� �޸𸮿� ��ȯ�մϴ�.
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