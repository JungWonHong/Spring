<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.sql.*" %>

<%
	Connection conn = null; //Connection��ü ����
	
	//JDBC ����̹� �̸��� �����մϴ�. (DBMS���� �ٸ��ϴ�.)
	String driver = "oracle.jdbc.driver.OracleDriver";
	
	//JDBC����̹��� ����Ͽ� ������ URL �Դϴ�.
	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	Boolean connect = false;
	try{
		Class.forName(driver); //JDBC ����̹� �̸����� ����̹��� �ε��մϴ�.
		
		//�����ߴ� JDBC URL�� �̿��Ͽ� Connection ��ü�� ��� �ɴϴ�.
		conn = DriverManager.getConnection(url, "scott", "tiger");
		connect = true;
		conn.close(); //�����ͺ��̽����� ������ �����մϴ�.
	} catch (Exception e) {
		connect = false;
		e.printStackTrace();
	}
%>

<html>
	<head>
		<title>JDBC ���� �׽�Ʈ ����</title>
	</head>
	<body>
		<h3>
			<%
				if(connect == true) {
			%>
				����Ǿ����ϴ�.
			<%
				} else {
			%>
				���ῡ �����Ͽ����ϴ�.
			<%
				}
			%>
		</h3>
	</body>
</html>