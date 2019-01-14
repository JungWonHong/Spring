package com.naver.myhome7.dao;

import java.util.List;
import java.util.Map;

import com.naver.myhome7.model.MemberBean;
import com.naver.myhome7.model.ZipcodeBean2;

public interface MemberService {
	/* 아이디 중복 체크 */
	public int checkMemberId(String id) throws Exception;

	/* 우편 검색 */
	public List<ZipcodeBean2> findZipcode(String dong) throws Exception;

	/* 비번 검색 */
	public MemberBean findpwd(Map pm) throws Exception;

	/* 회원저장 */
	public void insertMember(MemberBean m) throws Exception;

	/* 로그인 인증 체크 */
	public MemberBean userCheck(String id) throws Exception;

	/* 회원삭제 */
	public void deleteMember(MemberBean delm) throws Exception;

	/* 회원수정 */
	public void updateMember(MemberBean member) throws Exception;

}
