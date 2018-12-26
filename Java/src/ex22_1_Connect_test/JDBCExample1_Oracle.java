//JDBC 드라이버를 로드하고 데이터베이스에 연결하는 프로그램
package ex22_1_Connect_test;
import java.sql.*;
public class JDBCExample1_Oracle {

	public static void main(String[] args) {
		Connection conn = null;
		try{
			//1단계 : JDBC 드라이버를 로드한다.
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver); //클래스를 쭉 읽어들인다.
			
			//2단계 : DB에 연결한다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			
			//3단계 : 메시지 출력 명령문으로 대체
			System.out.println("데이터베이스에 접속했습니다.");
			
			//4단계 : DB연결을 끊는다.
			conn.close();
		} catch(ClassNotFoundException cnfe){
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch(SQLException se){
			System.out.println(se.getMessage());
		}

	}

}
