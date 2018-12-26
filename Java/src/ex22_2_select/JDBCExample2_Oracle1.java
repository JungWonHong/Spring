package ex22_2_select;

import java.sql.*;

public class JDBCExample2_Oracle1 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1�ܰ� : JDBC ����̹��� �ε��Ѵ�.
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);

			// 2�ܰ� : DB�� �����Ѵ�.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			// System.out.println("�����ͺ��̽��� �����߽��ϴ�.");

			// ������ ���̽��� �ִ� ���̺��� �����͸� �о���� ���� Statement ��ü�� �ʿ�
			// 2�ܰ迡�� ���� Connection ��ü�� ���� createStatement �޼ҵ带
			// ȣ���ؼ� ��´�.
			stmt = conn.createStatement();

			// Statement Ÿ���� java.sql ��Ű���� ���ϴ� �������̽� �̸�����
			// select���� �����ϴ� executeQuery��� �޼ҵ尡 �ִ�.
			// �� �޼ҵ忡 �Ķ���ͷ� select ������ �Ѱ��־�� �Ѵ�.
			// �� �޼ҵ�� �Ķ���ͷ� �Ѱ��� select ���� ������ ���̽��� ������ �����ϰ�
			// �� ����� ResultSet ��ü�� �����Ѵ�.
			String select_sql = "select code, name, price, maker from goodsinfo";
			rs = stmt.executeQuery(select_sql);
			// ResultSet rs = stmt.executeQuery("select doe, name, price, maker
			// 									 from goodsinfo";

			System.out.println("��ȣ   ��ǰ�ڵ� \t   ��ǰ��\t\t\t����       ������");
			System.out.println("-------------------------------------------------------------------");

			// ResultSet ��ü�κ��� select���� ���� ����� ��� ���ؼ��� ����
			// next()�޼ҵ带 ȣ���ؾ� �Ѵ�.
			// rs.next() - ���� ����� ���� �� ��ġ�� �̵��ϴ� �޼ҵ�� ������� 
			// boolean���� ������ ���� �о� �Դ��� �����̴�.
			int i = 0;
			while (rs.next()) {// ���̻� ���� �����Ͱ� ���� ������ �ݺ�
				//rs.next() �� �ϸ� �� �ο츦 �����ͼ� �� �÷��� �ڷ����� ���缭 �о���δ�.
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
				rs.close();
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
