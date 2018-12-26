package ex22_2_select;

import java.sql.*;

public class JDBCExample3_Oracle2 {

	public static void main(String[] args) {
		if(args.length != 1){
			System.out.println("��ǰ�� �Է��ϼ���");
			return;
		}
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();

			String sel_where_sql = "select code, name, price, maker "
					+ "from goodsinfo "
					+ "where name = '" + args[0] + "'";
			ResultSet rs = stmt.executeQuery(sel_where_sql);

			System.out.println("��ȣ   ��ǰ�ڵ� \t   ��ǰ��\t\t\t����       ������");
			System.out.println("-------------------------------------------------------------------");

			// ResultSet ��ü�κ��� select���� ���� ����� ��� ���ؼ��� ����
			// next()�޼ҵ带 ȣ���ؾ� �Ѵ�.
			// rs.next() - ���� ����� ���� �� ��ġ�� �̵��ϴ� �޼ҵ�� ������� 
			// boolean���� ������ ���� �о� �Դ��� �����̴�.
			int i = 0;
			while (rs.next()) {// ���̻� ���� �����Ͱ� ���� ������ �ݺ�
				// getString("code") : �÷� code ���� String ������ �����ϴ� �޼ҵ�
				String code = rs.getString("code");
				String name = rs.getString("name");

				// getInt("price") : �÷� price ���� int ������ �����ϴ� �޼ҵ�
				int price = rs.getInt("price");
				String maker = rs.getString("maker");

				System.out.printf("%-5d%-7s\t %-10s \t %10d \t %-5s \n", 
						++i, code, name, price, maker);
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				// Statement ��ü�� close �ϸ�
				// �׿� ������ ResultSet��ü�� �ڵ����� close�Ǳ� ������
				// �� ��ü�� �����ؼ� close �ؾ� �� ���״�
				// Statement ��ü�� close �ص� �ȴ�.
				stmt.close();
			} catch (Exception ignored) {
			}
			try{
				conn.close(); //4�ܰ� : DB������ ���´�.
			} catch (Exception ignored){
			}
		}

	}

}
