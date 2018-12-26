package net.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	//������ ���̽� �۾��� �ʿ��� �������̽����� ���۷��� ������ �����մϴ�.
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// �����ڿ��� JNDI ���ҽ��� �����Ͽ� Connection ��ü�� ���ɴϴ�.
	public BoardDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}
	
	//���� ���� ���ϱ�
	public int getListCount() {
		int result = 0;
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			String sql = "select count(*) from board";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				result = rs.getInt(1);
		} catch (Exception ex) {
			System.out.println("getListCount() ����: " + ex);
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
				}
		}
			
		return result;
	}

	//�� ��� ���� 
	public List<BoardBean> getBoardList(int page, int limit) {
		//page : ������
		//limit : ������ �� ����� ��
		//BOARD_RE_REF desc, BOARD_RE_SEQ asc�� ���� ������ ���� ��������
		//�´� rnum�� ���� ��ŭ �������� �������Դϴ�.
		String board_list_sql = 
				"select * "
				+"from (select rownum rnum, BOARD_NUM, BOARD_NAME, "
				+ 			"BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, "
				+			"BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE "
				+ 		"from (select * "
				+ 			  "from board "
				+ 			  "order by BOARD_RE_REF desc, BOARD_RE_SEQ asc)) "
				+"where rnum>=? and rnum<=?";
		
		List<BoardBean> list = new ArrayList<BoardBean>();
								//�� �������� 10���� ����� ���		1������, 2������, 
		int startrow = (page - 1) * limit + 1; //�б� ������ row ��ȣ(1		11
		int endrow = startrow + limit - 1; 	   //���� ������ row ��ȣ(10		20
		
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			//DB���� ������ �����͸� VO��ü�� ����ϴ�.
			while(rs.next()) {
				BoardBean board = new BoardBean();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
				list.add(board); //���� ���� ��ü�� ����Ʈ�� �����մϴ�.
			}
			return list; //���� ���� ��ü�� ������ ����Ʈ�� ȣ���� ������ �������ϴ�.
		} catch (Exception e) {
			System.out.println("getBoardList(); ���� : " + e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
				}
		}
		
		return null;
	}

	public boolean boardInsert(BoardBean boarddata) {
		int num = 0;
		String sql = "";
		int result = 0;
		
		try{
			con = ds.getConnection();
			//board ���̺��� board_num �ʵ��� �ִ밪�� ���ؿͼ� ���� ����� ��
			//�� ��ȣ�� ���������� �����ϱ� �����Դϴ�.
			pstmt = con.prepareStatement("select max(board_num) from board");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				num = rs.getInt(1) + 1; //�ִ밪���� 1��ŭ ū���� �����մϴ�.
			else
				num = 1; //ó�� �����͸� ����ϴ� ����Դϴ�.
			//�۹�ȣ�� �ִ밪  ������ 1
			
			sql = "insert into board (BOARD_NUM, BOARD_NAME, BOARD_PASS, "
					+ 					"BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, "
					+ 					"BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, "
					+ 					"BOARD_READCOUNT, BOARD_DATE) "
					+ 			"values(?,?,?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, boarddata.getBOARD_NAME());
			pstmt.setString(3, boarddata.getBOARD_PASS());
			pstmt.setString(4, boarddata.getBOARD_SUBJECT());
			pstmt.setString(5, boarddata.getBOARD_CONTENT());
			pstmt.setString(6, boarddata.getBOARD_FILE());
			pstmt.setInt(7, num); //BOARD_RE_REF�ʵ�
			
			//������ ��� BOARD_RE_LEV, BOARD_RE_SEQ �ʵ� ���� 0 �Դϴ�.
			pstmt.setInt(8, 0);	//BOARD_RE_LEV �ʵ�
			pstmt.setInt(9, 0);	//BOARD_RE_SEQ �ʵ�
			
			pstmt.setInt(10, 0);
			
			result = pstmt.executeUpdate();
			if(result == 0)
				return false;
			
			return true;
		} catch (Exception e) {
			System.out.println("boardInsert() ����: " + e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
				}
		}
		return false;
	}

	//��ȸ�� ������Ʈ - �۹�ȣ�� �ش��ϴ� ��ȸ���� 1 �����մϴ�.
	public void setReadCountUpdate(int num) throws Exception {
		String sql = "update board "
				+ "set BOARD_READCOUNT = BOARD_READCOUNT + 1 "
				+ "where BOARD_NUM = " + num;
		
/*		String sql = "update board "
				+ "set BOARD_READCOUNT = BOARD_READCOUNT + 1 "
				+ "where BOARD_NUM = ?";*/
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			//pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("setReadCountUpdate() ����: " + ex);
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
			}
		}
	}

	public BoardBean getDetail(int num) {
		BoardBean board = null;
		String sql = "select * "
				+ "from board "
				+ "where BOARD_NUM = ?";
		try {
			con = ds.getConnection();	
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				board = new BoardBean();
				board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
				board.setBOARD_NAME(rs.getString("BOARD_NAME"));
				board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
				board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
				board.setBOARD_FILE(rs.getString("BOARD_FILE"));
				board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
				board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
				board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
				board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
				board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
			}
			
			return board;
		} catch (Exception e) {
			System.out.println("getDetail() ���� : " + e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
				}
		}
		return null;
	}

	//�� �亯
	public int boardReply(BoardBean board) {
		//board ���̺��� board_num �ʵ��� �ִ밪�� ���ؿͼ� ���� ����� ��
		//�� ��ȣ�� ���������� �����ϱ� �����Դϴ�.
		String board_max_sql = "select max(board_num) from board";
		String sql = "";
		int num = 0;
		
		//�亯�� �� ���� �� �׷� ��ȣ�Դϴ�.
		//�亯�� �ް� �Ǹ� �亯 ���� �� ��ȣ�� ���� ���ñ� ��ȣ�� ���� ó���Ǹ鼭
		//���� �׷쿡 ���ϰ� �˴ϴ�.
		//�� ��Ͽ��� �����ٶ� �ϳ��� �׷����� ������ ��µ˴ϴ�.
		int re_ref = board.getBOARD_RE_REF();
		
		//����� ���̸� �ǹ��մϴ�. ������ ���� ����� ��µ� �� �� �� �鿩���� ó����
		//�ǰ� ��ۿ� ���� ����� �鿩���Ⱑ �� �� ó���ǰ� �մϴ�.
		//������ ��쿡�� �� ���� 0�̰� ������ ����� 1, ����� ����� 2�� �˴ϴ�.
		int re_lev = board.getBOARD_RE_LEV();
		
		//���� ���� �� �߿��� �ش� ���� ��µǴ� �����Դϴ�.
		int re_seq = board.getBOARD_RE_SEQ();
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;
			
			//BOARD_RE_REF, BOARD_RE_SEQ ���� Ȯ���Ͽ� ���� �ۿ� �ٸ� ����� ������
			//�ٸ� ��۵��� BOARD_RE_SEQ���� 1�� ������ŵ�ϴ�.
			//���� ���� �ٸ� ��ۺ��� �տ� ��µǰ� �ϱ� ���ؼ� �Դϴ�.
			sql = "update board "
				+ "set BOARD_RE_SEQ = BOARD_RE_SEQ+1 "
				+ "where BOARD_RE_REF = ? and BOARD_RE_SEQ > ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			pstmt.executeUpdate();
			
			//����� �亯 ���� BOARD_RE_LEV, BOARD_RE_SEQ ���� ���� �ۺ��� 1�� ������Ų��
			re_seq = re_seq + 1;
			re_lev = re_lev + 1;
			
			sql = "insert into board "
				+ "(BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, "
				+  "BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, "
				+  "BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE) "
				+ "values(?,?,?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getBOARD_NAME());
			pstmt.setString(3, board.getBOARD_PASS());
			pstmt.setString(4, board.getBOARD_SUBJECT());
			pstmt.setString(5, board.getBOARD_CONTENT());
			pstmt.setString(6, ""); //�亯���� ������ ���ε����� �ʽ��ϴ�.
			pstmt.setInt(7, re_ref);
			pstmt.setInt(8, re_lev);
			pstmt.setInt(9, re_seq);
			pstmt.setInt(10, 0); //BOARD_READCOUNT(��ȸ��)�� 0
			pstmt.executeUpdate();
			
			return num; //�۹�ȣ
		} catch (Exception e) {
			System.out.println("boardReply() ���� : " + e);
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
				}
		}
		
		return 0;
	}//boardReply()�޼��� end
	
	//�� ����
		public boolean boardModify(BoardBean modifyboard) 
				throws Exception{
			String sql="update board "
					 + "set BOARD_SUBJECT= ?, "
					 + "BOARD_CONTENT=? "
					 + "where BOARD_NUM=? ";
			try{
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, modifyboard.getBOARD_SUBJECT());
				pstmt.setString(2, modifyboard.getBOARD_CONTENT());
				pstmt.setInt(3, modifyboard.getBOARD_NUM());
				pstmt.executeUpdate();
				return true;
			}catch(Exception ex){
				System.out.println("boardModify() ����: " + ex);
			}finally{
				if(rs!=null)try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
				if(con!=null) try{con.close();}catch(SQLException ex){}
				}
			return false;
		}//boardModify()�޼��� end
		
		//�� ����
		public boolean boardDelete(int num){
			String board_delete_sql
			  ="delete from board where BOARD_num=?";
			int result=0;
			try{
				con = ds.getConnection();
				pstmt=con.prepareStatement(board_delete_sql);
				pstmt.setInt(1, num);
				
				//���� ���� �� ������ �ο�(���ڵ�)������ ��ȯ�˴ϴ�.
				result=pstmt.executeUpdate();
				//������ �ȵ� ��쿡�� false�� ��ȯ�մϴ�.
				if(result==0)return false;
				
				return true;
			}catch(Exception ex){
				System.out.println("boardDelete() ����: "+ex);
			}finally{
			         try{
					       if(pstmt!=null)pstmt.close();
					       if(con!=null) con.close();
					      }
					   catch(Exception ex){}
			}
			
			return false;
		}//boardDelete()�޼��� end

		//�۾������� Ȯ�� - ��й�ȣ�� Ȯ���մϴ�.
		public boolean isBoardWriter(int num, String pass){
			String board_sql="select * from board where BOARD_NUM=?";
			try{
				con = ds.getConnection();
				pstmt=con.prepareStatement(board_sql);
				pstmt.setInt(1, num);
				rs=pstmt.executeQuery();
				rs.next();
				
				if(pass.equals(rs.getString("BOARD_PASS"))){
					return true;
				}
			}catch(SQLException ex){
				System.out.println("isBoardWriter() ���� : "+ex);
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null) try{pstmt.close();}
				                catch(SQLException ex){}
				if(con!=null) try{con.close();}catch(SQLException ex){}
			}
			return false;
		}//isBoardWriter end
}
