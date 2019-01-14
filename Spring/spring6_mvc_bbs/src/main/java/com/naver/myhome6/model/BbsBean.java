package com.naver.myhome6.model;

import org.springframework.web.multipart.MultipartFile;

public class BbsBean {

	private int bbs_num;
	private String bbs_name;
	private String bbs_pass;
	private String bbs_subject; //글제목
	private String bbs_content; //글내용
	
	private MultipartFile uploadfile; //파일
	
	private int bbs_re_ref; //글그룹번호
	private int bbs_re_lev; //화면에 보이는 답변글 위치번호
	private int bbs_re_seq; //답변글 레벨 순서
	private int bbs_readcount; //조회수
	private String bbs_date; //글 등록날짜
	
	private String bbs_file; //DB등록시 파일명
	private String bbs_original; //파일 첨부시 원본파일명
	
	
	public String getBbs_original() {
		return bbs_original;
	}
	public void setBbs_original(String bbs_original) {
		this.bbs_original = bbs_original;
	}
	public MultipartFile getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getBbs_file() {
		return bbs_file;
	}
	public void setBbs_file(String bbs_file) {
		this.bbs_file = bbs_file;
	}
	public int getBbs_num() {
		return bbs_num;
	}
	public void setBbs_num(int bbs_num) {
		this.bbs_num = bbs_num;
	}
	public String getBbs_name() {
		return bbs_name;
	}
	public void setBbs_name(String bbs_name) {
		this.bbs_name = bbs_name;
	}
	public String getBbs_pass() {
		return bbs_pass;
	}
	public void setBbs_pass(String bbs_pass) {
		this.bbs_pass = bbs_pass;
	}
	public String getBbs_subject() {
		return bbs_subject;
	}
	public void setBbs_subject(String bbs_subject) {
		this.bbs_subject = bbs_subject;
	}
	public String getBbs_content() {
		return bbs_content;
	}
	public void setBbs_content(String bbs_content) {
		this.bbs_content = bbs_content;
	}
	
	public int getBbs_re_ref() {
		return bbs_re_ref;
	}
	public void setBbs_re_ref(int bbs_re_ref) {
		this.bbs_re_ref = bbs_re_ref;
	}
	public int getBbs_re_lev() {
		return bbs_re_lev;
	}
	public void setBbs_re_lev(int bbs_re_lev) {
		this.bbs_re_lev = bbs_re_lev;
	}
	public int getBbs_re_seq() {
		return bbs_re_seq;
	}
	public void setBbs_re_seq(int bbs_re_seq) {
		this.bbs_re_seq = bbs_re_seq;
	}
	public int getBbs_readcount() {
		return bbs_readcount;
	}
	public void setBbs_readcount(int bbs_readcount) {
		this.bbs_readcount = bbs_readcount;
	}
	public String getBbs_date() {
		return bbs_date;
	}
	public void setBbs_date(String bbs_date) {
		this.bbs_date = bbs_date.substring(0,10);
	}	
}






