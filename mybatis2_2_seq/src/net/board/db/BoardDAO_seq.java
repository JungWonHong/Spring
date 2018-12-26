package net.board.db;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO_seq {
	private SqlSession getSession() { // mybatis에서는 SqlSession이 필요. 전에는
										// Connection만 있음됐다.
		SqlSession session = null;
		Reader reader = null; // xml 읽어오기 위해 필요
		try {
			reader = Resources.getResourceAsReader("sqlMapConfig_seq.xml");

			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader); // build를
																					// 통해서
																					// Factory
																					// 생성

			session = sf.openSession(true); // Factory를 통해 SqlSession 생성
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return session;
	}

	// 글의 갯수 구하기
	public int getListCount() {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.selectOne("count");
		} catch (Exception ex) {
			System.out.println("getListCount() 에러: " + ex);
		} finally {
			session.close();
		}
		return result;
	}

	// 글 목록 보기
	public List<BoardBean> getBoardList(int page, int limit) {
		List<BoardBean> list = new ArrayList<BoardBean>();
		SqlSession session = null;
		try {
			session = getSession();
			HashMap<String, Integer> m = new HashMap<String, Integer>();
			
			int startrow = (page - 1) * limit + 1; 
			int endrow = startrow + limit - 1;
			
			m.put("start", startrow);
			m.put("end", endrow);
			list = session.selectList("list", m);
		} catch (Exception e) {
			System.out.println("getListCount 에러: " + e);
		} finally {
			session.close();
		}
		return list;
	}

	// 글 내용 보기
	public BoardBean getDetail(int num) throws Exception {
		BoardBean board = null;
		SqlSession session = null;
		try {
			session = getSession();
			board = session.selectOne("Detail", num);
		} catch (Exception e) {
			System.out.println("getDetail 에러: " + e);
		} finally {
			session.close();
		}
		return board;
	}

	// 글 등록하기
	public boolean boardInsert(BoardBean board) {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			board.setBOARD_RE_LEV(0);
			board.setBOARD_RE_SEQ(0);
			board.setBOARD_READCOUNT(0);
			result = session.insert("insert", board);
		} catch (Exception e) {
			System.out.println("boardInsert 에러: " + e);
		} finally {
			session.close();
		}
		if(result == 0)
			return false;
		
		return true;
	}

	// 글 답변
	public int boardReply(BoardBean board) {
		int num = 1;
		SqlSession session = null;
		try {
			session = getSession();
			
			session.update("reply_update", board);
			board.setBOARD_RE_LEV(board.getBOARD_RE_LEV() + 1);
			board.setBOARD_RE_SEQ(board.getBOARD_RE_SEQ() + 1);
			board.setBOARD_READCOUNT(0);
			session.insert("reply_insert", board);
			num = session.selectOne("max_num");
		} catch (Exception e) {
			System.out.println("boardReply에러: " + e);
		} finally {
			session.close();
		}
		return num;
	}

	// 글 수정
	public boolean boardModify(BoardBean modifyboard) throws Exception {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.update("modify", modifyboard);
		} catch (Exception e) {
			System.out.println("boardModify 에러: " + e);
		} finally {
			session.close();
		}
		
		if (result == 0)
			return false;
		else
			return true;
	}

	// 글 삭제
	public boolean boardDelete(int num) {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.delete("delete", num);
		} catch (Exception e) {
			System.out.println("boardDelete 에러: " + e);
		} finally {
			session.close();
		}
		if(result == 0)
			return false;
		else
			return true;
	}

	// 조회수 업데이트
	public void setReadCountUpdate(int num) throws Exception {

		SqlSession session = null;
		try {
			session = getSession();
			session.update("ReadCountUpdate", num);
		} catch (Exception e) {
			System.out.println("setReadCountUpdate 에러 : " + e);
		} finally {
			session.close();
		}
	}

	// 글쓴이인지 확인
	public boolean isBoardWriter(int num, String pass) {
		BoardBean boardBean = null;
		SqlSession session = null;
		try {
			session = getSession();
			boardBean = (BoardBean) session.selectOne("BoardWriter", num);
			
			if(pass.equals(boardBean.getBOARD_PASS()))
				return true;
		} catch (Exception e) {
			System.out.println("isBoardWriter 에러: " + e);
		} finally {
			session.close();
		}
		System.out.println("여기는 글쓴이인지 확인 하는 곳 : false");
		return false;
	}
}
