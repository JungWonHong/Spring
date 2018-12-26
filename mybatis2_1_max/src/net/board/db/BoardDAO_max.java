package net.board.db;

import java.io.IOException;
import java.io.Reader;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO_max {
	private SqlSession getSession() { // mybatis������ SqlSession�� �ʿ�. ������
										// Connection�� �����ƴ�.
		SqlSession session = null;
		Reader reader = null; // xml �о���� ���� �ʿ�
		try {
			reader = Resources.getResourceAsReader("sqlMapConfig_max.xml");

			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(reader); // build��
																					// ���ؼ�
																					// Factory
																					// ����

			session = sf.openSession(true); // Factory�� ���� SqlSession ����
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return session;
	}

	// ���� ���� ���ϱ�
	public int getListCount() {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.selectOne("count");
		} catch (Exception ex) {
			System.out.println("getListCount() ����: " + ex);
		} finally {
			session.close();
		}
		return result;
	}

	// �� ��� ����
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
			System.out.println("getListCount ����: " + e);
		} finally {
			session.close();
		}
		return list;
	}

	// �� ���� ����
	public BoardBean getDetail(int num) throws Exception {
		BoardBean board = null;
		SqlSession session = null;
		try {
			session = getSession();
			board = session.selectOne("Detail", num);
		} catch (Exception e) {
			System.out.println("getDetail ����: " + e);
		} finally {
			session.close();
		}
		return board;
	}

	// �� ����ϱ�
	public boolean boardInsert(BoardBean board) {
		int result = 0;
		int num = 1;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.selectOne("count");
			if(result != 0){
				result = session.selectOne("max_num");
				num = result + 1;
			}
			board.setBOARD_NUM(num);
			board.setBOARD_RE_LEV(0);
			board.setBOARD_RE_REF(0);
			board.setBOARD_RE_SEQ(0);
			board.setBOARD_READCOUNT(0);
			result = session.insert("insert", board);
		} catch (Exception e) {
			System.out.println("boardInsert ����: " + e);
		} finally {
			session.close();
		}
		if(result == 0)
			return false;
		
		return true;
	}

	// �� �亯
	public int boardReply(BoardBean board) {
		int result = 0;
		int num = 1;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.selectOne("max_num");
			
			if(result != 0)
				num = result + 1;
			
			session.update("reply_update", board);
			board.setBOARD_RE_LEV(board.getBOARD_RE_LEV() + 1);
			board.setBOARD_RE_SEQ(board.getBOARD_RE_SEQ() + 1);
			board.setBOARD_READCOUNT(0);
			board.setBOARD_NUM(num);
			session.insert("reply_insert", board);
		} catch (Exception e) {
			System.out.println("boardReply����: " + e);
		} finally {
			session.close();
		}
		return num;
	}

	// �� ����
	public boolean boardModify(BoardBean modifyboard) throws Exception {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.update("modify", modifyboard);
		} catch (Exception e) {
			System.out.println("boardModify ����: " + e);
		} finally {
			session.close();
		}
		
		if (result == 0)
			return false;
		else
			return true;
	}

	// �� ����
	public boolean boardDelete(int num) {
		int result = 0;
		SqlSession session = null;
		try {
			session = getSession();
			result = session.delete("delete", num);
		} catch (Exception e) {
			System.out.println("boardDelete ����: " + e);
		} finally {
			session.close();
		}
		if(result == 0)
			return false;
		else
			return true;
	}

	// ��ȸ�� ������Ʈ
	public void setReadCountUpdate(int num) throws Exception {

		SqlSession session = null;
		try {
			session = getSession();
			session.update("ReadCountUpdate", num);
		} catch (Exception e) {
			System.out.println("setReadCountUpdate ���� : " + e);
		} finally {
			session.close();
		}
	}

	// �۾������� Ȯ��
	public boolean isBoardWriter(int num, String pass) {
		BoardBean boardBean = null;
		SqlSession session = null;
		try {
			session = getSession();
			boardBean = (BoardBean) session.selectOne("BoardWriter", num);
			
			if(pass.equals(boardBean.getBOARD_PASS()))
				return true;
		} catch (Exception e) {
			System.out.println("isBoardWriter ����: " + e);
		} finally {
			session.close();
		}
		System.out.println("����� �۾������� Ȯ�� �ϴ� �� : false");
		return false;
	}
}
