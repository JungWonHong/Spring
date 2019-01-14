package com.khcc.myweb.model;

import org.springframework.web.multipart.MultipartFile;

public class ReportBean {
/*
CREATE TABLE REPORTS(
	R_NUM		NUMBER PRIMARY KEY,
	R_CATEGORY  VARCHAR2(100) NOT NULL,
	R_SENDER	VARCHAR2(100),
	R_RECEIVER	VARCHAR2(100) DEFAULT 'admin',
	R_CONTENT	VARCHAR2(4000) NOT NULL,
	R_DATE		DATE DEFAULT SYSDATE,
	R_ILLEGALID	VARCHAR2(100) NOT NULL,
	R_IMG		VARCHAR2(100),
	R_ORGIMG      VARCHAR2(100)
);
 
 */
	
	
	private int R_NUM;
	private String R_CATEGORY;
	private String R_SENDER;
	private String R_RECEIVER;
	private String R_CONTENT;
	private String R_DATE;
	private String R_ILLEGALID;
	private String R_IMG;
	private String R_ORGIMG;
	private MultipartFile uploadfile; //ÆÄÀÏ
	
	public int getR_NUM() {
		return R_NUM;
	}
	public void setR_NUM(int r_NUM) {
		R_NUM = r_NUM;
	}
	public String getR_CATEGORY() {
		return R_CATEGORY;
	}
	public void setR_CATEGORY(String r_CATEGORY) {
		R_CATEGORY = r_CATEGORY;
	}
	public String getR_SENDER() {
		return R_SENDER;
	}
	public void setR_SENDER(String r_SENDER) {
		R_SENDER = r_SENDER;
	}
	public String getR_RECEIVER() {
		return R_RECEIVER;
	}
	public void setR_RECEIVER(String r_RECEIVER) {
		R_RECEIVER = r_RECEIVER;
	}
	public String getR_CONTENT() {
		return R_CONTENT;
	}
	public void setR_CONTENT(String r_CONTENT) {
		R_CONTENT = r_CONTENT;
	}
	public String getR_DATE() {
		return R_DATE;
	}
	public void setR_DATE(String r_DATE) {
		R_DATE = r_DATE;
	}
	public String getR_ILLEGALID() {
		return R_ILLEGALID;
	}
	public void setR_ILLEGALID(String r_ILLEGALID) {
		R_ILLEGALID = r_ILLEGALID;
	}
	public String getR_IMG() {
		return R_IMG;
	}
	public void setR_IMG(String r_IMG) {
		R_IMG = r_IMG;
	}
	public String getR_ORGIMG() {
		return R_ORGIMG;
	}
	public void setR_ORGIMG(String r_ORGIMG) {
		R_ORGIMG = r_ORGIMG;
	}
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}

	
	
}
