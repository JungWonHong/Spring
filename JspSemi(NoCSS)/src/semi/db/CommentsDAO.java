package semi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import semi.db.bean.CommentsBean;

public class CommentsDAO {
	// ������ ���̽� �۾��� �ʿ��� �������̽����� ���۷��� ������ �����մϴ�.
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
	// �����ڿ��� JNDI ���ҽ��� �����Ͽ� Connection ��ü�� ���ɴϴ�.
	public CommentsDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}
	
	// ����� ���� ���ϱ�
	public int getCommentsListCount(int boardnum) {
		int count = 0;
		try {
			con = ds.getConnection();
			String sql = "select count(*) from COMMENTS where com_re_ref = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardnum);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				count=rs.getInt(1);
			}
		}catch (Exception ex) {
			System.out.println("getCommentsListCount() ���� : " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return count;
	}
	
	
	//��� ������ ���� ���ϱ�
	public List<CommentsBean> getCommentsList(int page, int limit, int boardnum) {
		String sql = "select * from "
				+ "(select rownum rnum, com_no,com_id,com_content,"
				+ "com_re_ref,com_date from "
				+ "(select * from COMMENTS where com_re_ref = ? order by com_no asc)) "
				+ "where rnum>=? and rnum<=?";
		//String sql2 = "select * from COMMENTS where com_re_ref = ? order by com_no asc";
		List<CommentsBean> list = new ArrayList<CommentsBean>();
		
		int startrow = (page - 1) * limit + 1; // �б� ������ row ��ȣ
		int endrow = startrow + limit - 1; // ���� ������ row ��ȣ
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardnum);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, endrow);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CommentsBean board = new CommentsBean();
				board.setCom_no(rs.getInt("com_no"));
				board.setCom_id(rs.getString("com_id"));
				board.setCom_content(rs.getString("com_content"));
				board.setCom_re_ref(rs.getInt("com_re_ref"));
				board.setCom_date(rs.getDate("com_date"));
				list.add(board);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//��� ����
	public boolean CommentsDelete(int com_no) {
		String sql = "delete from COMMENTS where com_no=?";
		int result=0;
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, com_no);
			
			result=pstmt.executeUpdate();
			
			if(result==0)
				return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("CommentsDelete() ���� �߻� : " +ex);
		}finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
		}
		return false;
	}
	
	
	//��� ���
	public boolean CommentsInsert(CommentsBean boarddata) {
		int num = 0;
		int result = 0;
		String sql = "";
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement("select max(com_no) from COMMENTS");
			rs = pstmt.executeQuery();
			if (rs.next())
				num = rs.getInt(1) + 1; // �ִ밪���� 1��ŭ ū ���� �����մϴ�.
			else
				num = 1; // ó�� �����͸� ����ϴ� ����Դϴ�.

			sql = "INSERT INTO COMMENTS (com_no, com_id, com_content, "
					+ "com_re_ref, com_date) "
					+ "VALUES(?,?,?,?,sysdate)";

			// ���ο� ���� ����ϴ� �κ��Դϴ�.
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, boarddata.getCom_id());
			pstmt.setString(3, boarddata.getCom_content());
			pstmt.setInt(4, boarddata.getCom_re_ref());// df

			result = pstmt.executeUpdate();
			if (result == 0)
				return false;
			else
				return true;
		} catch (Exception ex) {
			System.out.println("CommentsInsert() ����: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
		}
		return false;
	}

	//��� �� (�ۼ����� �� �޾ƿ��� ��)
	public CommentsBean getDetail(int num) throws Exception {
		CommentsBean board = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select * from COMMENTS where com_no = ? ");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new CommentsBean();
				board.setCom_no(rs.getInt("com_no"));
				board.setCom_id(rs.getString("com_id"));
				board.setCom_content(rs.getString("com_content"));
				board.setCom_re_ref(rs.getInt("com_re_ref"));
				board.setCom_date(rs.getDate("com_date"));
			}
			return board;
		} catch (Exception ex) {
			System.out.println("getDetail() ����: " + ex);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException ex) {
				}
		}
		return null;
	}// getDetail()�޼��� end
	
	
	//��� ����
	public boolean CommentsModify(CommentsBean modifycmt) {
		String sql="update COMMENTS " + "set com_content = ? " + "where com_no = ?";
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modifycmt.getCom_content());
			pstmt.setInt(2, modifycmt.getCom_no());
			pstmt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("CommentsModify() ����: " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
			}
		return false;
	}
}