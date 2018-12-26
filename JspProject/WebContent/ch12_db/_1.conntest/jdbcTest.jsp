<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>

<%
	Connection conn = null; //Connection객체 생성
	
	//JDBC 드라이버 이름을 설정합니다. (DBMS마다 다릅니다.)
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	//JDBC드라이버를 사용하여 접속할 URL 입니다.
	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	Boolean connect = false;
	try{
		Class.forName(driver); //JDBC 드라이버 이름으로 드라이버를 로드합니다.
		
		//설정했던 JDBC URL을 이용하여 Connection 객체를 얻어 옵니다.
		conn = DriverManager.getConnection(url, "scott", "tiger");
		connect = true;
		conn.close(); //데이터베이스와의 연결을 해제합니다.
	} catch (Exception e) {
		connect = false;
		e.printStackTrace();
	}
%>

<html>
	<head>
		<title>JDBC 연동 테스트 예제</title>
	</head>
	<body>
		<h3>
			<%
				if(connect == true) {
			%>
				연결되었습니다.
			<%
				} else {
			%>
				연결에 실패하였습니다.
			<%
				}
			%>
		</h3>
	</body>
</html>