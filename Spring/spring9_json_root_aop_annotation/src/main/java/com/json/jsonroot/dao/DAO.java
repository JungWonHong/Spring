package com.json.jsonroot.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.json.jsonroot.model.BoardVO;

@Repository
public class DAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int getMaxid() {
		int result = 0;
		
		result = ((Integer)sqlSession.selectOne("count")).intValue();
		
		if(result != 0) {
			result = ((Integer)sqlSession.selectOne("maxid")).intValue();
		}
		
		return result;
	}

	public BoardVO get_whereid(int id) {
		return sqlSession.selectOne("select_whereid", id);
	}

	public void setInsert(BoardVO b) {
		sqlSession.insert("data_insert", b);
	}

	public List<BoardVO> selectall() {
		List<BoardVO> list = sqlSession.selectList("select_all");
		return list;
	}

}
