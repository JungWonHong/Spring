package ex22_4_PreparedStatement;

import java.sql.*;

public class JdbcEx4_transaction {

	public static void main(String[] args) {
		//transaction : ������ �۾� ����
		//insert, delete, update ���� �۾����� �ϳ��� ������ �۾�������
		//��� ���� ����� ��� �۾��� ���� ó�� �� ��쿡�� commit�� �����ؼ�
		//db�� �ݿ��ϰ� ���� ���� �� �ϳ��� ����ó�� ���� �ʴ� ���
		//rollback�� �����ؼ� �۾� �������� ��� �۾��� ����Ѵ�.
		
		// SQL�� �ۼ��ϱ�
		StringBuffer sql1 = new StringBuffer();
		sql1.append("insert into department ");
		sql1.append("values(?, ?, ?, ?) ");
		
		StringBuffer sql2 = new StringBuffer();
		sql2.append("update department ");
		sql2.append("set dname = ?, loc = ? ");
		sql2.append("where deptno = ?");
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			///////// transaction ���� /////////
			//�ϳ��� ������ �۾� ���� ����
			
			conn = ConnUtil.getConnection();
			
			//autoCommit��� ��Ȱ��ȭ ��Ű��
			conn.setAutoCommit(false);

			//-------- 1�� �۾� ���� ---------//
			// PreparedStatement ��ü ���
			pstmt = conn.prepareStatement(sql1.toString());
			// �Ķ���� ����
			// ������ ?(���ε� ����)�� ��ü�� ������ �����ϱ�
			pstmt.setInt(1, 255);
			pstmt.setString(2, "�ٹ����а�");
			pstmt.setInt(3, 200);
			pstmt.setString(4, "9ȣ��");
			pstmt.executeUpdate();
			pstmt.close();
			//-------- 1�� �۾� ���� ---------//
			
			//-------- 2�� �۾� ���� ---------//
			// PreparedStatement ��ü ���
			pstmt = conn.prepareStatement(sql2.toString());
			pstmt.setString(1, "������а�");
			pstmt.setString(2, "8ȣ��");
			pstmt.setInt(3, 255);
			pstmt.executeUpdate();
			//-------- 2�� �۾� ���� ---------//
			
			//������ ���������� ����� ��� db�� �ݿ�
			conn.commit();
			System.out.println("db�� �ݿ���. . . . . . . .");
		} catch (SQLException se) {
			try{
				conn.rollback();
				System.out.println("db �ݿ��� ��� �� . . . . . .");
			} catch(SQLException e1){
				e1.printStackTrace();
			}
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
