<%--직접 JSON 형식으로 만들어 봅니다. --%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String modelnumber = request.getParameter("modelnumber");
	String series = request.getParameter("series");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		conn = ds.getConnection();
		
		//추가 버튼을 클릭한 경우
		if(name != null){
			//id 컬럼을 1씩 증가시키기 위한 것입니다.
			pstmt = conn.prepareStatement("select max(id) from products");
			rs = pstmt.executeQuery();
			int num = 1;
			if(rs.next())
				num = rs.getInt(1) + 1;
			pstmt.close();
			
			//입력 받은 데이터 insert문 실행합니다.
			pstmt = conn.prepareStatement("INSERT INTO products VALUES(?, ?, ?, ?)");
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, modelnumber);
			pstmt.setString(4, series);
			int result = pstmt.executeUpdate();
			pstmt.close();
			rs.close();
		}
		
		//추가 버튼을 클릭한 경우와 처음 페이지 보여줄 때 이미 저장된 자료 가져올 때 사용
		//id에 의해 정렬한 데이터를 가져옵니다.
		String sql = "select * from products order by id";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		//JSON 형태로 데이터를 만듭니다.
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		int i = 0;
		while(rs.next()){
			i++;
			sb.append("{");
			sb.append("\"id\" : "); sb.append("\"" + rs.getInt("id") + "\",");
			sb.append("\"name\" : "); sb.append("\"" + rs.getString("name") + "\",");
			sb.append("\"modelnumber\" : "); sb.append("\"" + rs.getString("modelnumber") + "\",");
			sb.append("\"series\" : "); sb.append("\"" + rs.getString("series") + "\"");
			sb.append("}");
			sb.append(",");
		}
		if(i != 0){
			sb.deleteCharAt(sb.length()-1);
			sb.append("]");
		} else {
			//데이터가 없는 경우 모두 제거합니다.
			//delete(start, end):index가 start부터 end-1까지 제거합니다.
			sb.delete(0, sb.length());
		}
		
		//page가 안바뀐상태에서 한번 요청하면 갱신이 안되고 캐쉬에 남아있는
		//데이터를 계속 쓰게 됩니다.
		//ajax 처리시 캐쉬에 저장하지 않겠다고 세팅해야 합니다.
		response.setHeader("cache-control", "no-cache,no-store");
		System.out.println(sb.toString());
		out.print(sb.toString());
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		if(rs != null) try{rs.close();} catch(SQLException ex){}
		if(pstmt != null) try{pstmt.close();} catch(SQLException ex){}
		if(conn != null) try{conn.close();} catch(SQLException ex){}
	}
%>