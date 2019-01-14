package com.naver.myhome7.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.myhome7.model.MemberBean;
import com.naver.myhome7.model.ZipcodeBean2;

@Repository
public class MemberDAOImpl {
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	
	/***** 아이디 중복 체크 *****/
	public int checkMemberId(String id) throws Exception{
		int re=-1; 
		try {
			MemberBean mb = (MemberBean) sqlsession.selectOne("login_check", id);
			if(mb != null)
				re = 1;
		} catch(Exception e) {
			System.out.println("아이디 중복 체크 에러");
		}
			// 중복id
		return re;
	}
	/***** 아이디 중복 체크 끝 *****/

	/*우편 검색*/
	public List<ZipcodeBean2> findZipcode(String dong) throws Exception{
		List<ZipcodeBean2> list=sqlsession.selectList("zipcodeList",dong);
		return list;
	}

	/* 비번 검색 */
	public MemberBean findpwd(Map pm) throws Exception{
	     return (MemberBean)sqlsession.selectOne("pwd_find",pm);
		}

	/*회원저장*/
	public void insertMember(MemberBean m) throws Exception{
	     sqlsession.insert("member_join",m);		
	}

	/*로그인 인증 체크 */
	public MemberBean userCheck(String id) throws Exception{
		MemberBean m = 
			(MemberBean)sqlsession.selectOne("Test.login_check",id);
		return m;
	}
	
	/*회원삭제*/
	public void deleteMember(MemberBean delm) throws Exception{
		sqlsession.update("member_delete",delm);		
	}
	
	
	
    /*회원수정*/
	public void updateMember(MemberBean member) throws Exception{
		sqlsession.update("member_edit",member);		
	}
	
	
}
