package ex21_7_with_db;

import java.sql.*;

public class ConnUtil {
	static { //Ŭ���� �ʱ�ȭ �� : Ŭ���� �ʱ�ȭ ���� ó�� �������� �� �ѹ��� ����
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver"); //DB�ε��Ű�� ��
		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã���� �����ϴ�." + cnfe.getMessage());
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		return DriverManager.getConnection(url, "scott", "tiger");
	}
}
