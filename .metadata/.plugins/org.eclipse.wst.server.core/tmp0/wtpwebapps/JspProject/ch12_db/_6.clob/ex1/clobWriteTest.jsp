<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%--
	LOB(Large Object) Ÿ���� ��뷮 �����͸� �����ϱ����� ������ Ÿ��
	- BLOB (Binary Large Object), ���� ���̳ʸ� �������� ����� ���˴ϴ�.
	- CLOB (Character Large Object), ���� �������� ����� ���˴ϴ�.
	- BFILE �ܺ� ���Ͽ� ����� ���� �����Ͱ� �ִ� ����� ����� ���˴ϴ�.
	    �ִ� 4GB���� ���尡��
	
	JAVA ���� ORACLE�� CLOB Ÿ�� ����ϱ�
	INSERT��
	1. CLOB Ÿ���� �ʵ��� �⺻���� empty_clob() �� �����մϴ�.
	2. setAutoCommit(false) �� �����մϴ�.
	3. CLOB Ÿ�� �ʵ带 ������ ������ �ʵ忡 �����͸� �����մϴ�.
	4. CLOB Ÿ�� �ʵ忡 �����͸� �ִ� ���� �ٸ� ���� �۾��� ���� ���� LOCK�� �̴ϴ�.
	5. CLOB Ÿ�� �ʵ忡 �����͸� �ֽ��ϴ�.
	6. commit() �մϴ�.
	7. setAutoCommit(true) �� �����մϴ�.
 --%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = null;
	
	/* 1. CLOB Ÿ���� �ʵ��� �⺻���� empty_clob() �� �����մϴ�. */
	//������ CLOB�� ������ Field �����͸� ������ Row�� �Է��մϴ�.
	String sql = "INSERT INTO clobtable (num, content) VALUES (1, empty_clob())";
	
	//FOR UPDATE��
	//�ش� �ο쿡 ���� �ɾ��ݴϴ�.
	//transaction�� ����(commit, rollback) �ϱ� ������ ��� �¿�
	//���ؼ� lock�� �ɸ��ϴ�.
	String sql2 = "SELECT content FROM clobtable WHERE num=1 FOR UPDATE";
	
	try {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		/* 2. setAutoCommit(false) �� �����մϴ�. */
		conn.setAutoCommit(false);
		
		//������ �����մϴ�.
		sb = new StringBuffer();
		for(int i=0; i<=10000; i++){
			sb.append("��ȣ!");
		}
		
		/* 3. CLOB Ÿ�� �ʵ带 ������ ������ �ʵ忡 �����͸� �����մϴ�. */
		//CLOB ������ �����ϱ� ���� ���ڵ带 �̸� �����մϴ�.
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		
		//4. CLOB Ÿ�� �ʵ忡 �����͸� �ִ� ���� �ٸ� ���� �۾��� ���� ���� LOCK�� �̴ϴ�.
		//CLOB �����͸� ������ ���ڵ带 select������ �����ɴϴ�.
		//for update�� �ٿ��־� ������ �����͸� ����Ͽ� SQL�۾��� �ϴ� ����
		//�ٸ� ���ǿ��� �ش� �����͸� ������ �� ������
		//Ʈ������� �����ŵ�ϴ�.
		pstmt = conn.prepareStatement(sql2);
		rs = pstmt.executeQuery();
		if(rs.next()){
			//getClob(�÷���)�޼��� : ������ �� �̸��� ���� �˻��Ͽ�
			//Java ���α׷��� ����� CLOB ��ü�� ��ȯ�մϴ�.
			oracle.sql.CLOB clob = (oracle.sql.CLOB)(rs).getClob("content");
			
			//5. CLOB Ÿ�� �ʵ忡 �����͸� �ֽ��ϴ�.
			//BufferedWriter�� ����Ͽ� �����͸� �����մϴ�.
			BufferedWriter bw =
				new BufferedWriter(clob.getCharacterOutputStream());
			bw.write(sb.toString());
			bw.close();
		}
		pstmt.close();
		
		//6. ������ �����͸� �����ϱ� ���� commit()�� �մϴ�.
		conn.commit();
		
		//7. AutoCommit�� �ٽ� True�� �����ϴ�.
		conn.setAutoCommit(true);
		out.println("����Ÿ�� �����߽��ϴ�.");
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