package ex21_6_with_db;
import java.sql.*;
public class JdbcEx4 {
	public Object[][] getData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Object data[][] = null;
		int row_count = 0;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			
			//count(*)를 통한 현재 row수를 구합니다.
			rs = stmt.executeQuery("select count(*) from department");
			rs.next(); //위치를 가리켜주는 역할
			int row = rs.getInt(1);
			
			//구해진 row의 갯수만큼 배열을 만듭니다.
			int col = 4;
			data = new Object[row][col];
			
			rs = stmt.executeQuery("select * from department");
			while(rs.next()){
				int deptno = rs.getInt(1); //rs.getInt("deptno");의미
				String dname = rs.getString(2); //rs.getString("dname");의미
				int college = rs.getInt("college");
				String loc = rs.getString("loc");
				
				System.out.printf("%-10s %-10s\t %-10d %-10s\n", deptno, dname, college, loc);
				
				data[row_count][0] = deptno;
				data[row_count][1] = dname;
				data[row_count][2] = college;
				data[row_count++][3] = loc;
			}
		} catch(ClassNotFoundException cnfe){
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch(SQLException se){
			System.out.println(se.getMessage());
		} finally{
			try{
				if(stmt != null)
					stmt.close();
			} catch(SQLException e){
			}
			try{
				if(conn != null)
					conn.close();
			} catch(SQLException e){
			}
		}
		
		return data;
	}
	
}
