package com.naver.myhome6.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.myhome6.model.BbsBean;

@Service("boardService")
public class BbsServiceImpl implements BbsService {
    @Autowired
	private BbsDAOImpl bbsDAO;

	@Override
	public void insertBbs(BbsBean bbsbean) throws Exception {
		bbsDAO.insertBbs(bbsbean);
	}

	@Override
	public int getListCount() throws Exception {
		return bbsDAO.getListCount();
	}

	@Override
	public List<BbsBean> getBbsList(int page) throws Exception {
		return bbsDAO.getBbsList(page);
	}

	@Override
	public BbsBean getBbsCont(int num) throws Exception {
		return bbsDAO.getBbsCont(num);
	}

	@Override
	public void bbsHit(int num) throws Exception {
        bbsDAO.bbsHit(num);		
	}

	@Override
	public void editBbs(BbsBean bbsbean) throws Exception {
         bbsDAO.editBbs(bbsbean);		
	}

	@Override
	public void deleteBbs(int bbs_num) throws Exception {
         bbsDAO.deleteBbs(bbs_num);		
	}

	@Override
	public int getListCount3(Map m) throws Exception {
		return bbsDAO.getListCount3(m);
	}

	@Override
	public List<BbsBean> getBbsList3(Map m) throws Exception {
		return bbsDAO.getBbsList3(m);
	}

	@Override
	public void refEdit(BbsBean bbsbean) throws Exception {
        bbsDAO.refEdit(bbsbean);		
	}

	@Override
	public void bbsReplyOk(BbsBean bbsbean) throws Exception {
        bbsDAO.bbsReplyOk(bbsbean);		
	}

	
}
