package com.naver.myhome5.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.myhome5.model.BoardBean;

/*
	@Component�� �̿��ؼ� ������ �����̳ʰ� �ش� Ŭ���� ��ü�� �����ϵ��� ������ �� ������
	��� Ŭ������ @Component�� �Ҵ��ϸ� � Ŭ������ � ������ �����ϴ��� �ľ��ϱ�
	��ƽ��ϴ�. ������ �����ӿ�ũ������ �̷� Ŭ�������� �з��ϱ� ���ؼ�
	@Component�� ����Ͽ� ������ ���� �� ���� �ֳ����̼��� �����մϴ�.
	
	1. @Controller - ������� ��û�� �����ϴ� Controller Ŭ����
	2. @Repository - ������ ���̽� ������ ó���ϴ� DAO Ŭ����
	3. @Service - ����Ͻ� ������ ó���ϴ� Service Ŭ����
	
 */
@Repository
public class BoardDAOImpl {
	@Autowired
	private SqlSession sqlSession;
	
	// �Խ��� ����
	public void insertBoard(BoardBean b) throws Exception {
		sqlSession.insert("Test.board_insert", b);
	}
	
	// �Խù� ���
	public List<BoardBean> getBoardList(int page) throws Exception {
		List<BoardBean> list =
				sqlSession.selectList("Test.board_list", page);
		return list;
	}
	
	// �Խ��� �� �Խù� ��
	public int getListCount() throws Exception {
		int count = 0;
		count = ((Integer)sqlSession.selectOne("Test.board_count")).intValue();
		return count;
	}

	// �Խ��� �۳��뺸��
	public BoardBean getBoardCont(int board_num) throws Exception {
		return (BoardBean)sqlSession.selectOne("Test.board_cont", board_num);
	}
	
	// �Խ��� ��ȸ�� ����
	public void boardHit(int board_num) throws Exception {
		sqlSession.update("Test.board_hit", board_num);
	}

	// �Խù� ����
	public void boardEdit(BoardBean b) throws Exception {
		sqlSession.update("Test.board_edit", b);
	}
	
	// �Խù� ����
	public void boardDelete(int board_num) throws Exception {
		sqlSession.delete("Test.board_del", board_num);
	}
	
	// �亯�� ���� ����
	public void refEdit(BoardBean b) throws Exception {
		sqlSession.update("Test.board_level", b);
	}
	
	// �亯�� ����
	public void boardReplyOk(BoardBean b) throws Exception {
		sqlSession.insert("Test.board_reply", b);
	}
	
}
