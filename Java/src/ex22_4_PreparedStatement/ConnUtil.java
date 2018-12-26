package ex22_4_PreparedStatement;

import java.sql.*;

public class ConnUtil {
	static { //클래스 초기화 블럭 : 클래스 초기화 블럭은 처음 생성했을 때 한번만 실행
		try { 
			Class.forName("oracle.jdbc.driver.OracleDriver"); //DB로드시키는 것
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을수 없습니다." + cnfe.getMessage());
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		return DriverManager.getConnection(url, "scott", "tiger");
	}
}
