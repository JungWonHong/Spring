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

import semi.db.bean.EListBean;
import semi.db.bean.RecruitBoardBean;
import semi.db.bean.ReviewBoardBean;
import semi.db.bean.SourceBoardBean;

public class BoardDAO {
	// 데이터 베이스 작업에 필요한 인터페이스들의 레퍼런스 변수를 선언합니다.
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
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

	public EListBean getEInfo(String name) {
		EListBean info = null;
		String sql = "select * from E_LIST where EL_COMPANY = '" + name + "'";

		try {
			con = ds.getConnection();
			System.out.println("getConnection");

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				info = new EListBean();
				info.setEl_company(rs.getString("EL_COMPANY"));
				info.setEl_environment(rs.getString("EL_ENVIRONMENT"));
				info.setEl_forms(rs.getInt("EL_FORMS"));
				info.setEl_head(rs.getString("EL_HEAD"));
				info.setEl_loc(rs.getString("EL_LOC"));
				info.setEl_part(rs.getString("EL_PART"));
				info.setEl_workernum(rs.getInt("EL_WORKERNUM"));
			}

			return info;
		} catch (Exception e) {
			System.out.println("getEInfo(); 에러 : " + e);
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

	public List<RecruitBoardBean> getBoardList() {
		String board_list_sql = "select * " + "from recruit_board " + "where rc_expire>sysdate " + "order by rc_expire";

		List<RecruitBoardBean> list = new ArrayList<RecruitBoardBean>();

		try {
			con = ds.getConnection();
			System.out.println("getConnection");

			pstmt = con.prepareStatement(board_list_sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RecruitBoardBean board = new RecruitBoardBean();
				board.setRc_ability(rs.getString("RC_ABILITY"));
				board.setRc_career(rs.getInt("RC_CAREER")); // 신입/경력
				board.setRc_company(rs.getString("RC_COMPANY"));
				board.setRc_content(rs.getString("RC_CONTENT"));
				board.setRc_date(rs.getDate("RC_DATE"));
				board.setRc_expire(rs.getDate("RC_EXPIRE"));
				board.setRc_file(rs.getString("RC_FILE"));
				board.setRc_hirekind(rs.getInt("RC_HIREKIND")); // 정규직/계약직
				board.setRc_no(rs.getInt("RC_NO"));
				board.setRc_sal(rs.getInt("RC_SAL"));
				board.setRc_title(rs.getString("RC_TITLE"));
				board.setRc_worktime(rs.getString("RC_WORKTIME"));
				list.add(board);
			}
			return list;
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

	public RecruitBoardBean getDetail(int no) {
		RecruitBoardBean board = null;
		String sql = "select * " + "from RECRUIT_BOARD " + "where RC_NO = ?";

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new RecruitBoardBean();
				board.setRc_ability(rs.getString("RC_ABILITY"));
				board.setRc_career(rs.getInt("RC_CAREER")); // 신입/경력
				board.setRc_company(rs.getString("RC_COMPANY"));
				board.setRc_content(rs.getString("RC_CONTENT"));
				board.setRc_date(rs.getDate("RC_DATE"));
				board.setRc_expire(rs.getDate("RC_EXPIRE"));
				board.setRc_file(rs.getString("RC_FILE"));
				board.setRc_hirekind(rs.getInt("RC_HIREKIND")); // 정규직/계약직
				board.setRc_no(rs.getInt("RC_NO"));
				board.setRc_sal(rs.getInt("RC_SAL"));
				board.setRc_title(rs.getString("RC_TITLE"));
				board.setRc_worktime(rs.getString("RC_WORKTIME"));
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
	
	public boolean recruitInsert(RecruitBoardBean boarddata) {
		int num = 0;
		String sql = "";
		int result = 0;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select max(rc_no) from recruit_board");
			rs = pstmt.executeQuery();
			
			if(rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;
			
			sql = "insert into recruit_board (rc_hirekind, rc_career, rc_sal, "
					+ 							"rc_ability, rc_worktime, rc_title, "
					+ 							"rc_expire, rc_no, rc_content, rc_company, "
					+ 							"rc_file, rc_date) "
					+ 					"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boarddata.getRc_hirekind());
			pstmt.setInt(2, boarddata.getRc_career());
			pstmt.setInt(3, boarddata.getRc_sal());
			pstmt.setString(4, boarddata.getRc_ability());
			pstmt.setString(5, boarddata.getRc_worktime());
			pstmt.setString(6, boarddata.getRc_title());
			pstmt.setDate(7, boarddata.getRc_expire());
			pstmt.setInt(8, num);
			pstmt.setString(9, boarddata.getRc_content());
			pstmt.setString(10, boarddata.getRc_company());
			pstmt.setString(11, boarddata.getRc_file());
			
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

	// 글의 개수 구하기
	public int rvgetListCount() {
		int x = 0;
		String sql = "select count(*) from REVIEW_BOARD";
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("rvgetListCount() 에러: " + ex);
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
		return x;
	}// getListCount
	// 글 목록 보기

	public List<ReviewBoardBean> rvgetBoardList(int page, int limit) {
		String sql = "select * from " + "(select rownum rnum, rv_no, rv_date, rv_title,"
				+ "rv_id, rv_count, rv_score from (select * from review_board order by rv_no desc)) "
				+ "where rnum>=? and rnum<=?";

		List<ReviewBoardBean> list = new ArrayList<ReviewBoardBean>();
		int startrow = (page - 1) * 10 + 1; // 읽기 시작할 row 번호
		int endrow = startrow + limit - 1;// 읽을 마지막 row 번호
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewBoardBean rv = new ReviewBoardBean();
				rv.setRv_no(rs.getInt("rv_no"));
				rv.setRv_id(rs.getString("rv_id"));
				rv.setRv_title(rs.getString("rv_title"));
				rv.setRv_count(rs.getInt("rv_count"));
				rv.setRv_date(rs.getDate("rv_date"));
				list.add(rv);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("rvgetBoardList 에러" + ex);
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
	}// end getBoardList

	// 글 등록
	public boolean rvboardInesrt(ReviewBoardBean rv) {
		int num = 0;
		int result = 0;
		String sql = "";
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement("select max(rv_no) from review_board");
			rs = pstmt.executeQuery();
			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			sql = "insert into review_board(rv_no, rv_id, rv_title," + "rv_content, rv_count, rv_score, rv_date)"
					+ "values (?,?,?,?,?,?,sysdate)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, rv.getRv_id());
			pstmt.setString(3, rv.getRv_title());
			pstmt.setString(4, rv.getRv_content());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, rv.getRv_score());

			result = pstmt.executeUpdate();
			if (result == 0)
				return false;
			return true;
		} catch (Exception ex) {
			System.out.println("rvboardInsert 에러" + ex);
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
		return false;
	}

	// 조회수 업데이트 - 글 번호에 해당하는 조회수를 1 증가
	public void rvsetReadCountUpdate(int num) throws Exception {
		String sql = "update review_board " + "set rv_count=rv_count+1 " + "where rv_no=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("setReadCountUpdate() 에러:" + ex);
		} finally {
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
	}// count 끝

	public ReviewBoardBean rvgetDetail(int num) {
		String sql = "select*from review_board where rv_no=?";
		ReviewBoardBean rv = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				rv = new ReviewBoardBean();
				rv.setRv_no(rs.getInt("rv_no"));
				rv.setRv_id(rs.getString("rv_id"));
				rv.setRv_title(rs.getString("rv_title"));
				rv.setRv_content(rs.getString("rv_content"));
				rv.setRv_count(rs.getInt("rv_count"));
				rv.setRv_date(rs.getDate("rv_date"));
				rv.setRv_score(rs.getInt("rv_score"));
			}
			return rv;
		} catch (SQLException ex) {
			System.out.println("getDetail() 에러:" + ex);
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
	}

	public boolean rvBoardModify(ReviewBoardBean modifyboard) throws Exception {
		String sql = "update review_board " + "set rv_title=?, " + "rv_content=? " + "where rv_no=? ";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modifyboard.getRv_title());
			pstmt.setString(2, modifyboard.getRv_content());
			pstmt.setInt(3, modifyboard.getRv_no());
			pstmt.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println("rvboardModify() 에러: " + ex);
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
		return false;
	}

	public boolean rvboardDelete(int num) {
		String sql = "delete from review_board where rv_no=? ";
		int result = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			// 쿼리 실행 후 삭제된 로우(레코드)개수가 반환
			result = pstmt.executeUpdate();
			// 삭제가 안되는 경우 false
			if (result == 0)
				return false;
			return true;
		} catch (Exception ex) {
			System.out.println("boardDelete() 에러: " + ex);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return false;
	}// boardDelete()메서드 end
	
	public int rvSearchListCount(String keyField, String keyWord) {
		int x = 0;
		String sql = "select count(*) from REVIEW_BOARD ";
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			if(keyWord!=null&&!keyWord.equals("")){
				sql+=" where "+keyField.trim()+" LIKE '%"+keyWord.trim()+"%' order by rv_no desc";
			}else{
				sql+=" where "+keyField.trim()+" =null";
			}
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("rvsearchListCount() 에러: " + ex);
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
		return x;
	}// getListCount
	public ArrayList<ReviewBoardBean> rvSearchBoardList(String keyField, String keyWord, int page, int limit) {
		String sql = "select * "+ 
				"from (select rownum rnum, rv_no, rv_date, rv_title, rv_id, rv_count, rv_content " + 
						 "from (select * "+ 
						 		"from review_board "+ 
						 		"where "+keyField.trim()+ " LIKE '%" + keyWord.trim()+ "%' " +
						 		"order by rv_no desc)) "+  
					"where rnum>=? and rnum<=? " ;

		ArrayList<ReviewBoardBean> list = new ArrayList<ReviewBoardBean>();
		int startrow = (page - 1) * 10 + 1; // 읽기 시작할 row 번호
		int endrow = startrow + limit - 1;// 읽을 마지막 row 번호
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			/*if(keyWord==null&&keyWord.equals("")){
				sql+="where "+keyField.trim()+" is null";
			}*/
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ReviewBoardBean rv = new ReviewBoardBean();
				rv.setRv_no(rs.getInt("rv_no"));
				rv.setRv_id(rs.getString("rv_id"));
				rv.setRv_title(rs.getString("rv_title"));
				rv.setRv_count(rs.getInt("rv_count"));
				rv.setRv_date(rs.getDate("rv_date"));
				list.add(rv);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("rvsearchBoardList 에러" + ex);
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
	}// end getBoardList

	public void sbsetReadCountUpdate(int num) throws Exception {
		String sql = "update source_board " + "set sb_count=sb_count+1 " + "where sb_no=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("sbsetReadCountUpdate() 에러:" + ex);
		} finally {
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
	}// count 끝

	public SourceBoardBean sbgetDetail(int num) {
		String sql = "select*from source_board where sb_no=?";
		SourceBoardBean sb = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				sb = new SourceBoardBean();
				sb.setSb_no(rs.getInt("sb_no"));
				sb.setSb_id(rs.getString("sb_id"));
				sb.setSb_title(rs.getString("sb_title"));
				;
				sb.setSb_content(rs.getString("sb_content"));
				sb.setSb_count(rs.getInt("sb_count"));
				sb.setSb_file(rs.getString("sb_file"));
				sb.setSb_date(rs.getDate("sb_date"));
			}
			return sb;
		} catch (SQLException ex) {
			System.out.println("getDetail() 에러:" + ex);
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
	}

	public boolean sbBoardModify(SourceBoardBean modifyboard) throws Exception {
		String sql = "update source_board " + "set sb_title=?, " + "sb_content=?, " + "sb_file=?" + "where sb_no=? ";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, modifyboard.getSb_title());
			pstmt.setString(2, modifyboard.getSb_content());
			pstmt.setString(3, modifyboard.getSb_file());
			pstmt.setInt(4, modifyboard.getSb_no());
			pstmt.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println("sbboardModify() 에러: " + ex);
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
		return false;
	}

	public boolean sbboardDelete(int num) {
		String sql = "delete from source_board where sb_no=? ";
		int result = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			// 쿼리 실행 후 삭제된 로우(레코드)개수가 반환
			result = pstmt.executeUpdate();
			// 삭제가 안되는 경우 false
			if (result == 0)
				return false;
			return true;
		} catch (Exception ex) {
			System.out.println("sbboardDelete() 에러: " + ex);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return false;
	}// sbboardDelete()메서드 end

	public int sbgetListCount() {
		int x = 0;
		String sql = "select count(*) from SOURCE_BOARD";
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("sbgetListCount() 에러: " + ex);
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
		return x;
	}// getListCount

	public List<SourceBoardBean> sbgetBoardList(int page, int limit) {
		String sql = "select*from " + "(select rownum rnum, sb_no, sb_date, sb_title,"
				+ "sb_id, sb_count from (select * from source_board order by sb_no desc)) " + "where rnum>=? and rnum<=?";

		List<SourceBoardBean> list = new ArrayList<SourceBoardBean>();
		int startrow = (page - 1) * 10 + 1; // 읽기 시작할 row 번호
		int endrow = startrow + limit - 1;// 읽을 마지막 row 번호
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SourceBoardBean sb = new SourceBoardBean();
				sb.setSb_no(rs.getInt("sb_no"));
				sb.setSb_id(rs.getString("sb_id"));
				sb.setSb_title(rs.getString("sb_title"));
				sb.setSb_count(rs.getInt("sb_count"));
				sb.setSb_date(rs.getDate("sb_date"));
				list.add(sb);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("sbgetBoardList 에러" + ex);
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
	}// end getBoardList

	public boolean sbboardInesrt(SourceBoardBean sb) {
		int num = 0;
		int result = 0;
		String sql = "";
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			pstmt = con.prepareStatement("select max(sb_no) from source_board");
			rs = pstmt.executeQuery();
			if (rs.next())
				num = rs.getInt(1) + 1;
			else
				num = 1;

			sql = "insert into source_board(sb_no, sb_id, sb_title," + "sb_content, sb_file, sb_count, sb_date)"
					+ "values (?,?,?,?,?,?,sysdate)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, sb.getSb_id());
			pstmt.setString(3, sb.getSb_title());
			pstmt.setString(4, sb.getSb_content());
			pstmt.setString(5, sb.getSb_file());
			pstmt.setInt(6, 0);

			result = pstmt.executeUpdate();
			if (result == 0)
				return false;
			return true;
		} catch (Exception ex) {
			System.out.println("sbboardInsert 에러" + ex);
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
		return false;
	}
	public int sbSearchListCount(String keyField, String keyWord) {
		int x = 0;
		String sql = "select count(*) from SOURCE_BOARD ";
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			if(keyWord!=null&&!keyWord.equals("")){
				sql+=" where "+keyField.trim()+" LIKE '%"+keyWord.trim()+"%' order by sb_no desc";
			}else{
				sql+=" where "+keyField.trim()+" =null";
			}
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception ex) {
			System.out.println("svsearchListCount() 에러: " + ex);
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
		return x;
	}// getListCount
	public ArrayList<SourceBoardBean> sbSearchBoardList(String keyField, String keyWord, int page, int limit) {
		String sql = "select * "+ 
				"from (select rownum rnum, sb_no, sb_date, sb_title, sb_id, sb_count, sb_content " + 
						 "from (select * "+ 
						 		"from source_board "+ 
						 		"where "+keyField.trim()+ " LIKE '%" + keyWord.trim()+ "%' " +
						 		"order by sb_no desc)) "+  
					"where rnum>=? and rnum<=? " ;
		ArrayList<SourceBoardBean> list = new ArrayList<SourceBoardBean>();
		int startrow = (page - 1) * 10 + 1; // 읽기 시작할 row 번호
		int endrow = startrow + limit - 1;// 읽을 마지막 row 번호
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			/*if(keyWord==null&&keyWord.equals("")){
				sql+="where "+keyField.trim()+" is null";
			}*/
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				SourceBoardBean sb = new SourceBoardBean();
				sb.setSb_no(rs.getInt("sb_no"));
				sb.setSb_id(rs.getString("sb_id"));
				sb.setSb_title(rs.getString("sb_title"));
				sb.setSb_count(rs.getInt("sb_count"));
				sb.setSb_date(rs.getDate("sb_date"));
				list.add(sb);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("sbsearchBoardList 에러" + ex);
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
	}// end getBoardList
}
