package com.khcc.myweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khcc.myweb.model.ReportBean;

@Service("reportService") 
public class ReportServiceImpl implements ReportService{

    @Autowired
	private ReportDAOImpl reportDAO;

	@Override
	public void insertreport(ReportBean rb) throws Exception {
		reportDAO.insertreport(rb);
		
	}

	@Override
	public List<ReportBean> getReportList(int page) throws Exception {
	    return reportDAO.getReportList(page);
	}

	@Override
	public int getListCount() throws Exception {
		return reportDAO.getListCount();
	}

	@Override
	public ReportBean getReportCont(int num) throws Exception {
		return reportDAO.getReportCont(num);
	}

	@Override
	public void deleteReport(int r_num) throws Exception {
		reportDAO.deleteReport(r_num);
	}

	@Override
	public void submitReport(String illegal) {
		reportDAO.submitReport(illegal);
	}

	@Override
	public int checkPenalty(String illegal) {
		return reportDAO.checkPenalty(illegal);
	}


	
}
