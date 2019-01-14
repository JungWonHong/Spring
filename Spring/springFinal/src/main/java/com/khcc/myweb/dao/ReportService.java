package com.khcc.myweb.dao;

import java.util.List;

import com.khcc.myweb.model.ReportBean;



public interface ReportService {
	
     //게시글 저장
	public void insertreport(ReportBean rb) throws Exception;
	

	/* 자료실 총 게시물 수*/
	public int getListCount() throws Exception;

	
	//게시글 목록
    public  List<ReportBean> getReportList(int page)throws Exception;
    
    
    //번호 기준으로 자료실 내용 가져오기
    public ReportBean getReportCont(int num) throws Exception;


	public void deleteReport(int r_NUM) throws Exception;


	public void submitReport(String illegal);


	public int checkPenalty(String illegal);

}
