package com.naver.myhome7.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.myhome7.model.MemberBean;
import com.naver.myhome7.model.ZipcodeBean2;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Autowired
	private MemberDAOImpl memDAO;

	@Override
	public int checkMemberId(String id) throws Exception {
		return memDAO.checkMemberId(id);
	}

	@Override
	public List<ZipcodeBean2> findZipcode(String dong) throws Exception {
		return memDAO.findZipcode(dong);
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
	public void deleteMember(MemberBean delm) throws Exception {
        memDAO.deleteMember(delm);		
	}

	@Override
	public void updateMember(MemberBean member) throws Exception {
        memDAO.updateMember(member);		
	}

	
	
}
