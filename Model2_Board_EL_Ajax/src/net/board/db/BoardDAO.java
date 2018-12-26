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
	//데이터 베이스 작업에 필요한 인터페이스들의 레퍼런스 변수를 선언합니다.
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 생성자에서 JNDI 리소스를 참조하여 Connection 객체를 얻어옵니다.
	public BoardDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception ex) {
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//글의 갯수 구하기
	public int getListCount() {
		int result = 0;
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			String sql = "select count(*) from board11";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				result = rs.getInt(1);
		} catch (Exception ex) {
			System.out.println("getListCount() 에러: " + ex);
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

	//글 목록 보기 
	public List<BoardBean> getBoardList(int page, int limit) {
		//page : 페이지
		//limit : 페이지 당 목록의 수
		//BOARD_RE_REF desc, BOARD_RE_SEQ asc에 의해 정렬한 것을 조건절에
		//맞는 rnum의 범위 만큼 가져오는 쿼리문입니다.
		String board_list_sql = 
				"select * "
				+"from (select rownum rnum, BOARD_NUM, BOARD_NAME, "
				+ 			"BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, "
				+			"BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE "
				+ 		"from (select * "
				+ 			  "from board11 "
				+ 			  "order by BOARD_RE_REF desc, BOARD_RE_SEQ asc)) "
				+"where rnum>=? and rnum<=?";
		
		List<BoardBean> list = new ArrayList<BoardBean>();
								//한 페이지당 10개씩 목록인 경우		1페이지, 2페이지, 
		int startrow = (page - 1) * limit + 1; //읽기 시작할 row 번호(1		11
		int endrow = startrow + limit - 1; 	   //읽을 마지막 row 번호(10		20
		
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			//DB에서 가져온 데이터를 VO객체에 담습니다.
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
				list.add(board); //값을 담은 객체를 리스트에 저장합니다.
			}
			return list; //값을 담은 객체를 저장한 리스트를 호출한 곳으로 가져갑니다.
		} catch (Exception e) {
			System.out.println("getBoardList(); 에러 : " + e);
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
		//int num = 0;
		String sql = "";
		int result = 0;
		
		try{
			con = ds.getConnection();
			
			//아래에서 sequence를 사용했기 때문에 주석으로 처리해도 된다.
			/*pstmt = con.prepareStatement("select max(board_num) from board11");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				num = rs.getInt(1) + 1; //최대값보다 1만큼 큰값을 지정합니다.
			else
				num = 1; //처음 데이터를 등록하는 경우입니다.
			//글번호는 최대값  없으면 1*/
			
			sql = "insert into board11 (BOARD_NUM, BOARD_NAME, BOARD_PASS, "
					+ 					"BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, "
					+ 					"BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, "
					+ 					"BOARD_READCOUNT, BOARD_DATE) "
					+ 			"values(board11_seq.nextval,?,?,?,?,?,"
					+ 				   "board11_seq.nextval,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			//pstmt.setInt(1, num);
			pstmt.setString(1, boarddata.getBOARD_NAME());
			pstmt.setString(2, boarddata.getBOARD_PASS());
			pstmt.setString(3, boarddata.getBOARD_SUBJECT());
			pstmt.setString(4, boarddata.getBOARD_CONTENT());
			pstmt.setString(5, boarddata.getBOARD_FILE());
			//pstmt.setInt(7, num); //BOARD_RE_REF필드
			pstmt.setInt(6, 0);	//BOARD_RE_LEV 필드
			pstmt.setInt(7, 0);	//BOARD_RE_SEQ 필드
			pstmt.setInt(8, 0);
			
			result = pstmt.executeUpdate();
			if(result == 0)
				return false;
			
			return true;
		} catch (Exception e) {
			System.out.println("boardInsert() 에러: " + e);
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

	//조회수 업데이트 - 글번호에 해당하는 조회수를 1 증가합니다.
	public void setReadCountUpdate(int num) throws Exception {
		String sql = "update board11 "
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
			System.out.println("setReadCountUpdate() 에러: " + ex);
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
				+ "from board11 "
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
			System.out.println("getDetail() 에러 : " + e);
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

	//글 답변
	public int boardReply(BoardBean board) {
		//board 테이블의 board_num 필드의 최대값을 구해와서 글을 등록할 때
		//글 번호를 순차적으로 지정하기 위함입니다.
		//String board_max_sql = "select max(board_num) from board11";
		String sql = "";
		int num = 0;
		
		//답변을 할 원문 글 그룹 번호입니다.
		//답변을 달게 되면 답변 글은 이 번호와 같은 관련글 번호를 갖게 처리되면서
		//같은 그룹에 속하게 됩니다.
		//글 목록에서 보여줄때 하나의 그룹으로 묶여서 출력됩니다.
		int re_ref = board.getBOARD_RE_REF();
		
		//답글의 깊이를 의미합니다. 원문에 대한 답글이 출력될 때 한 번 들여쓰기 처리가
		//되고 답글에 대한 답글은 들여쓰기가 두 번 처리되게 합니다.
		//원문인 경우에는 이 값이 0이고 원문의 답글은 1, 답글의 답글은 2가 됩니다.
		int re_lev = board.getBOARD_RE_LEV();
		
		//같은 관련 글 중에서 해당 글이 출력되는 순서입니다.
		int re_seq = board.getBOARD_RE_SEQ();
		
		try {
			con = ds.getConnection();
			/*pstmt = con.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;*/
			
			//BOARD_RE_REF, BOARD_RE_SEQ 값을 확인하여 원문 글에 다른 답글이 있으면
			//다른 답글들의 BOARD_RE_SEQ값을 1씩 증가시킵니다.
			//현재 글을 다른 답글보다 앞에 출력되게 하기 위해서 입니다.
			sql = "update board11 "
				+ "set BOARD_RE_SEQ = BOARD_RE_SEQ+1 "
				+ "where BOARD_RE_REF = ? and BOARD_RE_SEQ > ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			pstmt.executeUpdate();
			
			//등록할 답변 글의 BOARD_RE_LEV, BOARD_RE_SEQ 값을 원문 글보다 1씩 증가시킨다
			re_seq = re_seq + 1;
			re_lev = re_lev + 1;
			
			sql = "insert into board11 "
				+ "(BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, "
				+  "BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, "
				+  "BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE) "
				+ "values(board11_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = con.prepareStatement(sql);
			//pstmt.setInt(1, num);
			pstmt.setString(1, board.getBOARD_NAME());
			pstmt.setString(2, board.getBOARD_PASS());
			pstmt.setString(3, board.getBOARD_SUBJECT());
			pstmt.setString(4, board.getBOARD_CONTENT());
			pstmt.setString(5, ""); //답변에는 파일을 업로드하지 않습니다.
			pstmt.setInt(6, re_ref);
			pstmt.setInt(7, re_lev);
			pstmt.setInt(8, re_seq);
			pstmt.setInt(9, 0); //BOARD_READCOUNT(조회수)는 0
			pstmt.executeUpdate();
			
			sql = "select board11_seq.currval from dual";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				num = rs.getInt(1);
			
			return num; //글번호
		} catch (Exception e) {
			System.out.println("boardReply() 에러 : " + e);
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
	}//boardReply()메서드 end
	
	//글 수정
		public boolean boardModify(BoardBean modifyboard) 
				throws Exception{
			String sql="update board11 "
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
				System.out.println("boardModify() 에러: " + ex);
			}finally{
				if(rs!=null)try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
				if(con!=null) try{con.close();}catch(SQLException ex){}
				}
			return false;
		}//boardModify()메서드 end
		
		//글 삭제
		public boolean boardDelete(int num){
			String board_delete_sql
			  ="delete from board11 where BOARD_num=?";
			int result=0;
			try{
				con = ds.getConnection();
				pstmt=con.prepareStatement(board_delete_sql);
				pstmt.setInt(1, num);
				
				//쿼리 실행 후 삭제된 로우(레코드)갯수가 반환됩니다.
				result=pstmt.executeUpdate();
				//삭제가 안된 경우에는 false를 반환합니다.
				if(result==0)return false;
				
				return true;
			}catch(Exception ex){
				System.out.println("boardDelete() 에러: "+ex);
			}finally{
			         try{
					       if(pstmt!=null)pstmt.close();
					       if(con!=null) con.close();
					      }
					   catch(Exception ex){}
			}
			
			return false;
		}//boardDelete()메서드 end

		//글쓴이인지 확인 - 비밀번호로 확인합니다.
		public boolean isBoardWriter(int num, String pass){
			String board_sql="select * from board11 where BOARD_NUM=?";
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
				System.out.println("isBoardWriter() 에러 : "+ex);
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null) try{pstmt.close();}
				                catch(SQLException ex){}
				if(con!=null) try{con.close();}catch(SQLException ex){}
			}
			return false;
		}//isBoardWriter end
}
