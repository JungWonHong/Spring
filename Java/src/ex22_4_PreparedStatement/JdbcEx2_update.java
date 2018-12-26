//PreparedStatement ��뿹
package ex22_4_PreparedStatement;

import java.sql.*;

public class JdbcEx2_update {

	public static void main(String[] args) {
		// SQL�� �ۼ��ϱ�
		StringBuffer sql = new StringBuffer();
		sql.append("update professor ");
		sql.append("set sal = ? ");
		sql.append("where name = ?");

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = ConnUtil.getConnection();

			// PreparedStatement ��ü ���
			pstmt = conn.prepareStatement(sql.toString());

			// �Ķ���� ����
			// ������ ?(���ε� ����)�� ��ü�� ������ �����ϱ�
			pstmt.setInt(1, 1500);
			pstmt.setString(2, "ȫ�浿");
			
			// ���� ����
			int result = pstmt.executeUpdate();
			System.out.println(result + "���� ���� ���� �Ǿ����ϴ�.");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
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
