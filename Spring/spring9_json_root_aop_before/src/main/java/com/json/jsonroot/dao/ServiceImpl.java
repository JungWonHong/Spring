package com.json.jsonroot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.json.jsonroot.model.BoardVO;

//타겟
@Service
public class ServiceImpl implements jsonService{

	@Autowired
	private DAO dao;
	
	//무엇인가를 실행하기전에 공통적으로 수행해야하는 명령을 수행(호출).
	//이런식으로 하는것은 스프링적이지 못하다.
	//스프링적으로 해주기 위해서는 xml설정 또는 어노테이션으로
	//활용해야 한다.
	private LogAdvice log;
	
	public ServiceImpl() {
		log = new LogAdvice();
	}
	
	//모든 메서드(이 프로그램에서는 4개) -> 조인포인트
	//get으로 시작하는 메서드(2개) -> 포인트 컷
	
	@Override
	public int getMaxid() {
		log.beforeLog(); //공통기능의 코드
		//get메서드에만 적용되게 하는것 -> 포인트 컷
		return dao.getMaxid();
	}

	@Override
	public BoardVO get_whereid(int id) {
		log.beforeLog();
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
