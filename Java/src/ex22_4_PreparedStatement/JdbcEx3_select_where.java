//PreparedStatement ��뿹
package ex22_4_PreparedStatement;

import java.sql.*;

public class JdbcEx3_select_where {

	public static void main(String[] args) {
		// SQL�� �ۼ��ϱ�
		StringBuffer sql = new StringBuffer();
		sql.append("select a.name, a.profno, a.position, b.dname ");
		sql.append("from professor a, department b ");
		sql.append("where a.deptno = b.deptno ");
		sql.append("and a.deptno = ?");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnUtil.getConnection();

			// PreparedStatement ��ü ���
			pstmt = conn.prepareStatement(sql.toString());

			// �Ķ���� ����
			// ������ ?(���ε� ����)�� ��ü�� ������ �����ϱ�
			pstmt.setInt(1, 203);
			
			// ���� ������� ��� ���� ���
			rs = pstmt.executeQuery();
			
			//��� ���տ��� �� �����ϱ�
			while(rs.next()){
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getInt("profno") + "\t");
				System.out.print(rs.getString("dname") + "\t\t");
				System.out.println(rs.getString("position") + "\t");
			}
			
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

	}

}
