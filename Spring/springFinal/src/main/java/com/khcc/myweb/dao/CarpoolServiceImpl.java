package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khcc.myweb.model.CarpoolBean;
import com.khcc.myweb.model.CpReservationBean;

@Service
public class CarpoolServiceImpl implements CarpoolService {
	@Autowired
	private CarpoolDAO cpDAO;
	
	@Override
	public void insertCp(CarpoolBean cpbean) throws Exception {
		cpDAO.insertCp(cpbean);
	}

	@Override
	public int getListCount() throws Exception {
		return cpDAO.getCpListCount();
	}
	
	@Override
	public int getListTotal() throws Exception {
		return cpDAO.getCpTotalCount();
	}

	@Override
	public List<CarpoolBean> getCpList(Map m) throws Exception {
		return cpDAO.getCpList(m);
	}

	@Override
	public int getListCount3(Map m) throws Exception {
		return cpDAO.getCpListCount3(m);
	}

	@Override
	public List<CarpoolBean> getCpList3(Map m) throws Exception {
		return cpDAO.getCpList3(m);
	}

	@Override
	public void updateCp(String cp_num) throws Exception {
		cpDAO.updateCp(cp_num);
	}

	@Override
	public void insertCpr(CpReservationBean cprbean) {
		cpDAO.insertCpr(cprbean);
	}

	@Override
	public String checkDriver(String login_email) {
		return cpDAO.checkDriver(login_email);
	}

	
}
