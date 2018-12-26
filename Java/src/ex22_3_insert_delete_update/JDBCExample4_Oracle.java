package ex22_3_insert_delete_update;

import java.sql.*;

public class JDBCExample4_Oracle {

	public static void main(String[] args) {
		if (args.length != 4) {
			System.out.println("��ǰ�ڵ� ��ǰ�� ���� �����縦 �Է��ϼ���");
			return;
		}
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
		
			int rowNum = stmt.executeUpdate(
					"insert into goodsinfo " 
				  + "(code, name, price, maker) " 
				  + "values"
				  + "('" + args[0] + "', " 
				  + "'"  + args[1] + "', "
				  +        args[2] + ", '" 
				  +        args[3] + "')");
			System.out.println(rowNum + "���� �߰��Ǿ����ϴ�.");
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
