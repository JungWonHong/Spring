package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khcc.myweb.model.CarpoolBean;
import com.khcc.myweb.model.CpReservationBean;

@Repository
public class CarpoolDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//카풀서비스 등록
	public void insertCp(CarpoolBean cpbean) throws Exception {
		sqlSession.insert("Carpool.cp_insert", cpbean);
	}
	
	//오늘 등록된 카풀서비스 개수
	public int getCpListCount() throws Exception {
		//int count = ((Integer)sqlSession.selectOne("cp_count")).intValue();
		int count = sqlSession.selectOne("cp_count");
		return count;
	}
	
	//이용 가능한 카풀서비스 개수
	public int getCpTotalCount() {
		int count = ((Integer)sqlSession.selectOne("cp_total")).intValue();
		return count;
	}
	
	//이용 가능한 카풀서비스 리스트(원하는 방식으로 정렬, 페이지)
	public List<CarpoolBean> getCpList(Map m) throws Exception {
		List<CarpoolBean> list = sqlSession.selectList("cp_list", m);
		return list;
	}

	public int getCpListCount3(Map m) {
		int count = 0;
		count = ((Integer)sqlSession.selectOne("cpfind_count", m)).intValue();
		return count;
	}

	public List<CarpoolBean> getCpList3(Map m) {
		List<CarpoolBean> list = sqlSession.selectList("cpfind_list", m);
		return list;
	}

	public void updateCp(String cp_num) {
		sqlSession.update("cp_update", cp_num);
	}

	public void insertCpr(CpReservationBean cprbean) {
		sqlSession.insert("cpr_insert", cprbean);
	}

	public String checkDriver(String login_email) {
		return sqlSession.selectOne("check", login_email);
	}
	
}
