package com.naver.myhome6.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.myhome6.model.BbsBean;
/*
@Component를 이용해서 스프링 컨테이너가 해당 클래스 객체를 생성하도록 설정할 수 있지만   
 모든 클래스에 @Component를 할당하면 어떤 클래스가 어떤 역할을 수행하는지 파악하기 어렵습니다
 스프링 프레임워크에서는 이런 클래스들을 분류하기 위해서 @Component를 상속하여 다음과 같은 세 개의 애노테이션을 제공합니다.

1. @Controller - 사용자의 요청을 제어하는 Controller 클래스
2. @Repository - 데이터 베이스 연동을 처리하는 DAO클래스
3. @Service - 비즈니스 로직을 처리하는 Service 클래스 

*/
@Repository
public class BbsDAOImpl {

	@Autowired
	private SqlSessionTemplate sqlSession;

	/*자료실 저장*/
	public void insertBbs(BbsBean bbsbean) throws Exception{
		sqlSession.insert("bbs_insert",bbsbean);		
	}

	/* 자료실 총 게시물 수*/
	public int getListCount() throws Exception{
		int count=
	((Integer)sqlSession.selectOne("bbs_count")).intValue();
		return count;
	}
	
	/* 자료실 목록과 페이징 */
	public List<BbsBean> getBbsList(int page) throws Exception {
		List<BbsBean>  list = 
				sqlSession.selectList("bbs_list", page);
	    return list;
	}

	/*번호를 기준으로 자료실 내용 가져오기 */
	public BbsBean getBbsCont(int num) throws Exception{
		return (BbsBean)sqlSession.selectOne("bbs_cont", num);
	}

	/*내용보기 할때만 조회수 증가*/
	public void bbsHit(int num) throws Exception{
		sqlSession.update("bbs_hit",num);		
	}

	/*자료실 수정*/
	public void editBbs(BbsBean bbsbean) throws Exception{
		sqlSession.update("bbs_edit",bbsbean);		
	}

	/*자료실 삭제*/
	public void deleteBbs(int bbs_num) throws Exception{
		sqlSession.delete("bbs_delete",bbs_num);		
	}

	/*검색 결과 게시물 수*/
//	public int getListCount3(String find_name,String find_field) throws SQLException{
	public int getListCount3(Map m) throws Exception{
		int count=0;
		count=((Integer)sqlSession.selectOne("bbsfind_cnt", m)).intValue();
		return count;
	}

	/*검색 결과 페이징 목록*/
	public List<BbsBean> getBbsList3(Map m) throws Exception {
		List<BbsBean>  list = sqlSession.selectList("bbs_find", m);
	    return list;
	}

	/*답변글 레벨 증가*/
	public void refEdit(BbsBean bbsbean) throws Exception{
		sqlSession.update("bbs_Level",bbsbean); 		
	}

	/*답변글 저장*/
	public void bbsReplyOk(BbsBean bbsbean) throws Exception{
		sqlSession.insert("bbs_reply",bbsbean);
	}
}











