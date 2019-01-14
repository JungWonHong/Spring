package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khcc.myweb.model.CardBean;
import com.khcc.myweb.model.MemberBean;

@Service("memberdService") // ("memberdService") : 이름설정 @Resource로 이름 불러올때 사용
public class MemberServiceImpl implements MemberService {
    @Autowired
	private MemberDAOImpl memDAO;

	@Override
	public int checkMemberId(String id) throws Exception {
		return memDAO.checkMemberId(id);
	}

	@Override
	public MemberBean findpwd(Map pm) throws Exception {
		return memDAO.findpwd(pm);
	}

	@Override
	public void insertMember(MemberBean m) throws Exception {
        memDAO.insertMember(m);
	}

	@Override
	public MemberBean userCheck(String id) throws Exception {
		return memDAO.userCheck(id);
	}

	@Override
	public int deleteMember(MemberBean delm) throws Exception {
        return memDAO.deleteMember(delm);		
	}

	@Override
	public void updatePass(Map up) throws Exception {
		memDAO.updatePass(up);
	}

	@Override
	public void updatePhone(Map up) throws Exception {
		memDAO.updatePhone(up);		
	}

	@Override
	public void updateDcode(Map ud) throws Exception {
		memDAO.updateDcode(ud);
	}

	@Override
	public void addrUpdate(Map ua) throws Exception {
		memDAO.addrUpdate(ua);
	}

	@Override
	public void insertCard(MemberBean c) {
		memDAO.insertCard(c);
	}
	@Override
	public MemberBean selectCard(String login_email) throws Exception {
		return memDAO.selectCard(login_email);
	}

	@Override
	public void deleteCard(Map dc) throws Exception {
		memDAO.deleteCard(dc);
	}

	@Override
	public List<MemberBean> selectPay(String login_email) throws Exception {
		return memDAO.selectPay(login_email);
	}

	@Override
	public List<MemberBean> getMemList() throws Exception {
		return memDAO.getMemList();
	}
}
