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
			
			//count(*)�� ���� ���� row���� ���մϴ�.
			rs = stmt.executeQuery("select count(*) from department");
			rs.next(); //��ġ�� �������ִ� ����
			int row = rs.getInt(1);
			
			//������ row�� ������ŭ �迭�� ����ϴ�.
			int col = 4;
			data = new Object[row][col];
			
			rs = stmt.executeQuery("select * from department");
			while(rs.next()){
				int deptno = rs.getInt(1); //rs.getInt("deptno");�ǹ�
				String dname = rs.getString(2); //rs.getString("dname");�ǹ�
				int college = rs.getInt("college");
				String loc = rs.getString("loc");
				
				System.out.printf("%-10s %-10s\t %-10d %-10s\n", deptno, dname, college, loc);
				
				data[row_count][0] = deptno;
				data[row_count][1] = dname;
				data[row_count][2] = college;
				data[row_count++][3] = loc;
			}
		} catch(ClassNotFoundException cnfe){
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
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
