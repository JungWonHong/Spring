package ex21_7_with_db;

import java.sql.*;

public class JdbcEx5 {
	public Object[][] infoselect() {
		StringBuffer sql = new StringBuffer();
		StringBuffer sqlcount = new StringBuffer();
		sql.append("select * from minfo ");
		sqlcount.append("select count(*) from minfo ");
		Object a[][] = null;
		Connection conn = null;
		int row;
		PreparedStatement pstmt = null;

		try {
			conn = ConnUtil.getConnection();

			// PreparedStatement ��ü ���
			pstmt = conn.prepareStatement(sqlcount.toString());

			// ���� ���� - row �� ���ؿ���
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			row = rs.getInt(1);
			pstmt.close();

			// row �� ��ŭ �迭�� ���� ����
			a = new Object[row][3];

			int i = 0;
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				a[i][0] = rs.getString(1);
				a[i][1] = rs.getString(2);
				a[i][2] = rs.getString(3);
				i++;
			}
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

		return a;
	}

	public void infoinsert(String args[]) {
		// SQL�� �ۼ��ϱ� - ���������� ��ü�� �κ��� ? �� ó���Ѵ�.
		StringBuffer sql = new StringBuffer();
		sql.append("insert into minfo ");
		sql.append("values(?, ?, ?)");
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnUtil.getConnection();

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, args[0]);
			pstmt.setInt(2, Integer.parseInt(args[1]));
			pstmt.setString(3, args[2]);

			// ��������
			int result = pstmt.executeUpdate();
			System.out.println(result + "���� ���� �߰� �Ǿ����ϴ�.");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
			}
		}
	}
	
	public void infodelete(Object args[]){
		//SQL�� �ۼ��ϱ� - ���������� ��ü�� �κ��� ?�� ó���Ѵ�.
		StringBuffer sql = new StringBuffer();
		sql.append("delete from minfo ");
		sql.append("where name = ? and age = ? and gender = ?");
		
		Connection conn = null;
		
		//SQL������ �̸� �����ϵǰ� ����ð� ���� �μ����� ���� ������ Ȯ���� �� �ִ�.
		//��, SQL������ Ʋ�� �̸� ������ ���� ���� ���߿� �����Ѵ�.
		//������ ? �� ��ġ�ȴ�.
		PreparedStatement pstmt = null;
		
		try{
			conn = ConnUtil.getConnection();
			
			//PreparedStatement ��ü ���
			pstmt = conn.prepareStatement(sql.toString());
			
			//�Ķ���� ����
			//������ ?(���ε� ����)�� ��ü�� ������ �����ϱ�
			//�Է� �Ű����� : SQL������ ? ���ڷ� ǥ�õ� �Է� �׸��� ����ŵ�ϴ�.
			pstmt.setString(1, args[0].toString());
			int age = Integer.parseInt(args[1].toString());
			pstmt.setInt(2, age);
			pstmt.setString(3, args[2].toString());
			
			//Object�� ���
			/* pstmt.setObject(1, args[0]);
			   pstmt.setObject(2, args[1]);
			   pstmt.setObject(3, args[2]);
			*/
			int result = pstmt.executeUpdate();
			System.out.println(result + "���� ���� �����Ǿ����ϴ�.");
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
			}
		}
	}

}
