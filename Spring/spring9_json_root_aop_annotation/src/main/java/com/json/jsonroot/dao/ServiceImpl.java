package com.json.jsonroot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.json.jsonroot.model.BoardVO;

//타겟(Target) : 핵심 기능이 구현된 객체로 공통기능의 적용 대상이 되는 객체를 의미합니다.
@Service
public class ServiceImpl implements jsonService{

	@Autowired
	private DAO dao;
	
	//Pointcut
	@Override
	public int getMaxid() {
		return dao.getMaxid();
	}

	//Pointcut
	@Override
	public BoardVO get_whereid(int id) {
		return dao.get_whereid(id);
	}

	@Override
	public void setInsert(BoardVO b) {
       dao.setInsert(b);		
	}

	@Override
	public List<BoardVO> selectall() {
		return dao.selectall();
	}

}
