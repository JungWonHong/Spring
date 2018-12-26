//PreparedStatement 사용예
package ex22_4_PreparedStatement;

import java.sql.*;

public class JdbcEx3_select_where {

	public static void main(String[] args) {
		// SQL문 작성하기
		StringBuffer sql = new StringBuffer();
		sql.append("select a.name, a.profno, a.position, b.dname ");
		sql.append("from professor a, department b ");
		sql.append("where a.deptno = b.deptno ");
		sql.append("and a.deptno = ?");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();

			// PreparedStatement 객체 얻기
			pstmt = conn.prepareStatement(sql.toString());

			// 파라미터 셋팅
			// 쿼리의 ?(바인딩 변수)에 대체될 실제값 지정하기
			pstmt.setInt(1, 203);
			
			// 쿼리 실행시켜 결과 집합 얻기
			rs = pstmt.executeQuery();
			
			//결과 집합에서 값 추출하기
			while(rs.next()){
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getInt("profno") + "\t");
				System.out.print(rs.getString("dname") + "\t\t");
				System.out.println(rs.getString("position") + "\t");
			}
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

	}

}
