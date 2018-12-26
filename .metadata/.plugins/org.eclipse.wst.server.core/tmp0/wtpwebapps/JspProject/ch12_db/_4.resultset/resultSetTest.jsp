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
		//JNDI를 이용하여 연결된 Connection객체를 가져옵니다.
		Context init = new InitialContext();
		DataSource ds =
				(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		pstm = conn.prepareStatement(sql);
		
		//sql문을 실행하여 가져온 레코드들을 ResultSet 객체에 저장합니다.
		rs = pstm.executeQuery();
		
		out.println("<table border=1>");
		while(rs.next()){ //레코드가 존재하지 않을 때까지 반복합니다.
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
				pstm.close(); //객체를 사용하고 메모리에 반환합니다.
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