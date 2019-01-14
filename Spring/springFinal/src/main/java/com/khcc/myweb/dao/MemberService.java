package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import com.khcc.myweb.model.CardBean;
import com.khcc.myweb.model.MemberBean;

public interface MemberService {
	/* 아이디 중복 체크 */
	public int checkMemberId(String id) throws Exception;

	/* 비번 검색 */
	public MemberBean findpwd(Map pm) throws Exception;

	/* 회원저장 */
	public void insertMember(MemberBean m) throws Exception;

	/* 로그인 인증 체크 */
	public MemberBean userCheck(String email) throws Exception;

	/* 회원 탈퇴 */
	public int deleteMember(MemberBean delm) throws Exception;

	/* 비밀번호 변경 */
	public void updatePass(Map up) throws Exception;

	/* 휴대폰 번호 변경 */
	public void updatePhone(Map up) throws Exception;

	/* 면허정보 등록 */
	public void updateDcode(Map up) throws Exception;

	/* 주소 등록 */
	public void addrUpdate(Map ua) throws Exception;

	/* 카드 등록 */
	public void insertCard(MemberBean c);
	
	/* 카드 정보 조회 */
	public MemberBean selectCard(String login_email) throws Exception;

	/* 카드 삭제 */
	public void deleteCard(Map<String, String> dc) throws Exception;

	/* 결제 내역 조회 */
	public List<MemberBean> selectPay(String login_email) throws Exception;
	
	public List<MemberBean> getMemList() throws Exception;
}
