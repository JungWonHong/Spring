package com.json.jsonroot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.json.jsonroot.model.BoardVO;

@Service
public class ServiceImpl implements jsonService{

	@Autowired
	private DAO dao;
	
	@Override
	public int getMaxid() {
		return dao.getMaxid();
	}

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
