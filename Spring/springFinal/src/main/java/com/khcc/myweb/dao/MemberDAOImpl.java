package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khcc.myweb.model.CardBean;
import com.khcc.myweb.model.MemberBean;

@Repository
public class MemberDAOImpl {

	@Autowired
	private SqlSessionTemplate sqlsession;

	/***** 아이디 중복 체크 *****/
	public int checkMemberId(String id) throws Exception {
		int re = -1;
		try {
			MemberBean mb = (MemberBean) sqlsession.selectOne("id_check", id);
			if (mb != null)
				re = 1;
		} catch (Exception e) {
			System.out.println("아이디 중복 체크 에러");
		}
		return re;
	}

	/***** 아이디 중복 체크 끝 *****/

	/* 비번 검색 */
	public MemberBean findpwd(Map pm) throws Exception {
		return (MemberBean) sqlsession.selectOne("pwd_find", pm);
	}

	/* 회원저장 */
	public void insertMember(MemberBean m) throws Exception {
		sqlsession.insert("member_join", m);
	}

	/* 로그인 인증 체크 */
	public MemberBean userCheck(String email) throws Exception {
		MemberBean m = (MemberBean) sqlsession.selectOne("login_check", email);
		return m;
	}

	/* 회원삭제 */
	public int deleteMember(MemberBean delm) throws Exception {
		return sqlsession.update("member_delete", delm);
	}

	/* 회원수정 */
	public void updateMember(MemberBean member) throws Exception {
		sqlsession.update("member_edit", member);
	}

	/* 비밀번호 수정 */
	public void updatePass(Map up) throws Exception {
		sqlsession.update("pass_edit", up);
	}

	/* 휴대폰 번호 변경 */
	public void updatePhone(Map up) throws Exception {
		sqlsession.update("phone_edit", up);
	}

	/* 운전면허 정보 등록 */
	public void updateDcode(Map ud) {
		sqlsession.update("drivercode_edit", ud);
	}

	/* 주소 등록 */
	public void addrUpdate(Map ua) {
		sqlsession.update("addr_update", ua);
	}
	
	/* 카드 등록 */
	public void insertCard(MemberBean c) {
		sqlsession.insert("reg_card",c);
	}
	
	/* 카드 정보조회 */
	public MemberBean selectCard(String login_email) throws Exception {
		return (MemberBean)sqlsession.selectOne("Card_select", login_email);
	}
	
	/* 카드 삭제 */
	public void deleteCard(Map dc) {
		sqlsession.delete("delete_card", dc);
	}

	/* 결제 내역 조회 */
	public List<MemberBean> selectPay(String login_email) {
		return sqlsession.selectList("select_pay", login_email);
	}

	public List<MemberBean> getMemList() {
		return sqlsession.selectList("memlist");
	}
}
