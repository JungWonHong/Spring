<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%--
	LOB(Large Object) 타입은 대용량 데이터를 저장하기위한 데이터 타입
	- BLOB (Binary Large Object), 이진 바이너리 데이터의 저장시 사용됩니다.
	- CLOB (Character Large Object), 문서 데이터의 저장시 사용됩니다.
	- BFILE 외부 파일에 저장된 이진 데이터가 있는 경로의 저장시 사용됩니다.
	    최대 4GB까지 저장가능
	
	JAVA 에서 ORACLE의 CLOB 타입 사용하기
	INSERT시
	1. CLOB 타입인 필드의 기본값을 empty_clob() 로 설정합니다.
	2. setAutoCommit(false) 를 선언합니다.
	3. CLOB 타입 필드를 제외한 나머지 필드에 데이터를 저장합니다.
	4. CLOB 타입 필드에 데이터를 넣는 동안 다른 변경 작업을 막기 위해 LOCK을 겁니다.
	5. CLOB 타입 필드에 데이터를 넣습니다.
	6. commit() 합니다.
	7. setAutoCommit(true) 를 선언합니다.
 --%>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = null;
	
	/* 1. CLOB 타입인 필드의 기본값을 empty_clob() 로 설정합니다. */
	//사전에 CLOB을 제외한 Field 데이터를 가지는 Row를 입력합니다.
	String sql = "INSERT INTO clobtable (num, content) VALUES (1, empty_clob())";
	
	//FOR UPDATE문
	//해당 로우에 락을 걸어줍니다.
	//transaction을 해제(commit, rollback) 하기 전까지 결과 셋에
	//대해서 lock이 걸립니다.
	String sql2 = "SELECT content FROM clobtable WHERE num=1 FOR UPDATE";
	
	try {
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		/* 2. setAutoCommit(false) 를 선언합니다. */
		conn.setAutoCommit(false);
		
		//데이터 생성합니다.
		sb = new StringBuffer();
		for(int i=0; i<=10000; i++){
			sb.append("야호!");
		}
		
		/* 3. CLOB 타입 필드를 제외한 나머지 필드에 데이터를 저장합니다. */
		//CLOB 데이터 삽입하기 위한 레코드를 미리 생성합니다.
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		
		//4. CLOB 타입 필드에 데이터를 넣는 동안 다른 변경 작업을 막기 위해 LOCK을 겁니다.
		//CLOB 데이터를 삽입할 레코드를 select문으로 가져옵니다.
		//for update를 붙여주어 가져온 데이터를 사용하여 SQL작업을 하는 동안
		//다른 세션에서 해당 데이터를 변경할 수 없도록
		//트랜잭션을 적용시킵니다.
		pstmt = conn.prepareStatement(sql2);
		rs = pstmt.executeQuery();
		if(rs.next()){
			//getClob(컬럼명)메서드 : 지정된 열 이름의 값을 검색하여
			//Java 프로그래밍 언어의 CLOB 개체로 반환합니다.
			oracle.sql.CLOB clob = (oracle.sql.CLOB)(rs).getClob("content");
			
			//5. CLOB 타입 필드에 데이터를 넣습니다.
			//BufferedWriter를 사용하여 데이터를 삽입합니다.
			BufferedWriter bw =
				new BufferedWriter(clob.getCharacterOutputStream());
			bw.write(sb.toString());
			bw.close();
		}
		pstmt.close();
		
		//6. 삽입한 데이터를 적용하기 위해 commit()를 합니다.
		conn.commit();
		
		//7. AutoCommit을 다시 True로 돌립니다.
		conn.setAutoCommit(true);
		out.println("데이타를 저장했습니다.");
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