package ex22_3_insert_delete_update;

import java.sql.*;

public class JDBCExample6_Oracle {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("제조사와 상품코드 입력하세요.");
			return;
		}
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
		
			//update goodsinfo 
			//set maker = 'args[0]'
			//where code = 'args[1]';
			String up_sql = "update goodsinfo " 
						  + "set maker = '" + args[0] + "' "
						  + "where code = '" + args[1] + "'";
			int rowNum = stmt.executeUpdate(up_sql);
			System.out.println(rowNum + "행이 수정되었습니다.");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (Exception ignored) {
			}
			try {
				conn.close(); // 4단계 : DB연결을 끊는다.
			} catch (Exception ignored) {
			}
		}

	}

}
