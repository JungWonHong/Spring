package com.json.jsonroot.dao;

import java.util.List;

import com.json.jsonroot.model.BoardVO;

public interface jsonService {
	public int getMaxid();

	public BoardVO get_whereid(int id);

	public void setInsert(BoardVO b);

	public List<BoardVO> selectall();
}
