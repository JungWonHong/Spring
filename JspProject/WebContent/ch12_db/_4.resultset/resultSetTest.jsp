<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	Connection conn = null;
	String sql = "select * from student";
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	try {
		//JNDI�� �̿��Ͽ� ����� Connection��ü�� �����ɴϴ�.
		Context init = new InitialContext();
		DataSource ds =
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		pstm = conn.prepareStatement(sql);
		
		//sql���� �����Ͽ� ������ ���ڵ���� ResultSet ��ü�� �����մϴ�.
		rs = pstm.executeQuery();
		
		out.println("<table border=1>");
		while(rs.next()){ //���ڵ尡 �������� ���� ������ �ݺ��մϴ�.
			out.println("<tr><td>" + rs.getInt("num") + "</td>"); //rs.getInt(1) 
			out.println("<td>" + rs.getString("name") + "</td></tr>"); //rs.getString(2)
		}
		out.println("</table>");
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		
		if(pstm != null)
			try {
				pstm.close(); //��ü�� ����ϰ� �޸𸮿� ��ȯ�մϴ�.
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
		<style>
		      table{
		         margin: 0 auto;
		         border-collapse: collapse;
		         width: 300px;
		         text-align: center;
		      }
		   
		      table, tr, td {
		         height: 50px;
		      }
   		</style>
	</head>
	<body>
		
	</body>
</html>