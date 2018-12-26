package ex22_2_select;

import java.sql.*;

public class JDBCExample2_Oracle2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1단계 : JDBC 드라이버를 로드한다.
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);

			// 2단계 : DB에 연결한다.
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			// System.out.println("데이터베이스에 접속했습니다.");

			// 데이터 베이스에 있는 테이블의 데이터를 읽어오기 위해 Statement 객체가 필요
			// 2단계에서 얻은 Connection 객체에 대해 createStatement 메소드를
			// 호출해서 얻는다.
			stmt = conn.createStatement();

			// Statement 타입은 java.sql 패키지에 속하는 인터페이스 이름으로
			// select문을 실행하는 executeQuery라는 메소드가 있다.
			// 이 메소드에 파라미터로 select 문장을 넘겨주어야 한다.
			// 이 메소드는 파라미터로 넘겨준 select 문을 데이터 베이스로 보내서 실행하고
			// 그 결과로 ResultSet 객체를 리턴한다.
			String select_sql = "select code, name, price, maker from goodsinfo";
			rs = stmt.executeQuery(select_sql);
			// ResultSet rs = stmt.executeQuery("select doe, name, price, maker
			// 									 from goodsinfo";

			System.out.println("번호   상품코드 \t   상품명\t\t\t가격       제조사");
			System.out.println("-------------------------------------------------------------------");

			// ResultSet 객체로부터 select문의 실행 결과를 얻기 위해서는 먼저
			// next()메소드를 호출해야 한다.
			// rs.next() - 실행 결과의 다음 행 위치로 이동하는 메소드로 결과값은 
			// boolean으로 실제로 행을 읽어 왔는지 여부이다.
			int i = 0;
			while (rs.next()) {// 더이상 읽을 데이터가 없을 때까지 반복
				// getString("code") : 컬럼 code 값을 String 형으로 리턴하는 메소드
				String code = rs.getString(1); //1 : 테이블에서 첫번째 컬럼
				String name = rs.getString(2); //2 : 테이블에서 두번째 컬럼

				// getInt("price") : 컬럼 price 값을 int 형으로 리턴하는 메소드
				int price = rs.getInt(3);
				String maker = rs.getString(4);

				System.out.printf("%-5d%-7s\t %-10s \t %10d \t %-5s \n", 
						++i, code, name, price, maker);
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				// Statement 객체를 close 하면
				// 그에 연관된 ResultSet객체도 자동으로 close되기 때문에
				// 두 객체를 연속해서 close 해야 할 경우네는
				// Statement 객체만 close 해도 된다.
				rs.close();
				stmt.close();
			} catch (Exception ignored) {
			}
			try{
				conn.close(); //4단계 : DB연결을 끊는다.
			} catch (Exception ignored){
			}
		}

	}

}
