package ex22_3_insert_delete_update;

import java.sql.*;

public class JDBCExample6_Oracle {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("������� ��ǰ�ڵ� �Է��ϼ���.");
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
