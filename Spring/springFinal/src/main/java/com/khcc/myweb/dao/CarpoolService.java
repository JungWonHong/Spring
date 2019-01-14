package com.khcc.myweb.dao;

import java.util.List;
import java.util.Map;

import com.khcc.myweb.model.CarpoolBean;
import com.khcc.myweb.model.CpReservationBean;

public interface CarpoolService {
	public void insertCp(CarpoolBean cpbean) throws Exception;
	
	public int getListCount() throws Exception;
	
	public int getListTotal() throws Exception;
	
	public List<CarpoolBean> getCpList(Map m) throws Exception;

	public int getListCount3(Map m) throws Exception;

	public List<CarpoolBean> getCpList3(Map m) throws Exception;

	public void updateCp(String cp_num) throws Exception;

	public void insertCpr(CpReservationBean cprbean);

	public String checkDriver(String login_email);
}
