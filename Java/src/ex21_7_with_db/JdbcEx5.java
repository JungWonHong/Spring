package ex21_7_with_db;

import java.sql.*;

public class JdbcEx5 {
	public Object[][] infoselect() {
		StringBuffer sql = new StringBuffer();
		StringBuffer sqlcount = new StringBuffer();
		sql.append("select * from minfo ");
		sqlcount.append("select count(*) from minfo ");
		Object a[][] = null;
		Connection conn = null;
		int row;
		PreparedStatement pstmt = null;

		try {
			conn = ConnUtil.getConnection();

			// PreparedStatement 객체 얻기
			pstmt = conn.prepareStatement(sqlcount.toString());

			// 쿼리 실행 - row 수 구해오기
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			row = rs.getInt(1);
			pstmt.close();

			// row 수 만큼 배열의 행을 만듬
			a = new Object[row][3];

			int i = 0;
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				a[i][0] = rs.getString(1);
				a[i][1] = rs.getString(2);
				a[i][2] = rs.getString(3);
				i++;
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
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

		return a;
	}

	public void infoinsert(String args[]) {
		// SQL문 작성하기 - 실제값으로 대체될 부분을 ? 로 처리한다.
		StringBuffer sql = new StringBuffer();
		sql.append("insert into minfo ");
		sql.append("values(?, ?, ?)");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, args[0]);
			pstmt.setInt(2, Integer.parseInt(args[1]));
			pstmt.setString(3, args[2]);

			// 쿼리실행
			int result = pstmt.executeUpdate();
			System.out.println(result + "개의 행이 추가 되었습니다.");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
			}
		}
	}
	
	public void infodelete(Object args[]){
		//SQL문 작성하기 - 실제값으로 대체될 부분을 ?로 처리한다.
		StringBuffer sql = new StringBuffer();
		sql.append("delete from minfo ");
		sql.append("where name = ? and age = ? and gender = ?");
		
		Connection conn = null;
		
		//SQL문장이 미리 컴파일되고 실행시간 동안 인수값을 위한 공간을 확보할 수 있다.
		//즉, SQL쿼리의 틀을 미리 생성해 놓고 값을 나중에 지정한다.
		//값들이 ? 로 대치된다.
		PreparedStatement pstmt = null;
		
		try{
			conn = ConnUtil.getConnection();
			
			//PreparedStatement 객체 얻기
			pstmt = conn.prepareStatement(sql.toString());
			
			//파라미터 셋팅
			//쿼리의 ?(바인딩 변수)에 대체될 실제값 지정하기
			//입력 매개변수 : SQL문에서 ? 문자로 표시된 입력 항목을 가리킵니다.
			pstmt.setString(1, args[0].toString());
			int age = Integer.parseInt(args[1].toString());
			pstmt.setInt(2, age);
			pstmt.setString(3, args[2].toString());
			
			//Object형 사용
			/* pstmt.setObject(1, args[0]);
			   pstmt.setObject(2, args[1]);
			   pstmt.setObject(3, args[2]);
			*/
			int result = pstmt.executeUpdate();
			System.out.println(result + "개의 행이 삭제되었습니다.");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
			}
		}
	}

}
