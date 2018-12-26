package ex22_3_insert_delete_update;

import java.sql.*;

public class JDBCExample5_Oracle {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("��ǰ���� �Է��ϼ���.");
			return;
		}
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
		
			//delete from goodsinfo where code = 'args[0]'
			String del_sql = "delete from goodsinfo where code = '" 
							+ args[0] + "'";
			int rowNum = stmt.executeUpdate(del_sql);
			System.out.println(rowNum + "���� �����Ǿ����ϴ�.");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (Exception ignored) {
			}
			try {
				conn.close(); // 4�ܰ� : DB������ ���´�.
			} catch (Exception ignored) {
			}
		}

	}

}
