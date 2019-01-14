package com.naver.myhome7.model;

import org.springframework.web.multipart.MultipartFile;

public class MemberBean {
	private int    join_code;
	private String join_id;
	private String join_pwd;	
	private String join_name;
	private String join_zip1;
	private String join_zip2;
	private String join_addr1;
	private String join_addr2;
	private String join_tel;
	private String join_tel1;
	private String join_tel2;
	private String join_tel3;
	private String join_phone;
	private String join_phone1;
	private String join_phone2;
	private String join_phone3;
	private String join_email;
	private String join_mailid;
	private String join_maildomain;	
	
	private MultipartFile join_profile;
	private String join_regdate;
	private int    join_state;
	private String join_delcont;
	private String join_deldate;
	private String join_original;
	
	private String join_file;  //변경된 첨부 파일명
	
	public String getJoin_tel1() {
		return join_tel1;
	}
	public void setJoin_tel1(String join_tel1) {
		this.join_tel1 = join_tel1;
	}
	public String getJoin_tel2() {
		return join_tel2;
	}
	public void setJoin_tel2(String join_tel2) {
		this.join_tel2 = join_tel2;
	}
	public String getJoin_tel3() {
		return join_tel3;
	}
	public void setJoin_tel3(String join_tel3) {
		this.join_tel3 = join_tel3;
	}
	
	
	
	public String getJoin_original() {
		return join_original;
	}
	public void setJoin_original(String join_original) {
		this.join_original = join_original;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	private MultipartFile upload;
	
	public int getJoin_code() {
		return join_code;
	}
	public void setJoin_code(int join_code) {
		this.join_code = join_code;
	}
	public String getJoin_id() {
		return join_id;
	}
	public void setJoin_id(String join_id) {
		this.join_id = join_id;
	}
	public String getJoin_pwd() {
		return join_pwd;
	}
	public void setJoin_pwd(String join_pwd) {
		this.join_pwd = join_pwd;
	}
	public String getJoin_name() {
		return join_name;
	}
	public void setJoin_name(String join_name) {
		this.join_name = join_name;
	}
	public String getJoin_zip1() {
		return join_zip1;
	}
	public void setJoin_zip1(String join_zip1) {
		this.join_zip1 = join_zip1;
	}
	public String getJoin_zip2() {
		return join_zip2;
	}
	public void setJoin_zip2(String join_zip2) {
		this.join_zip2 = join_zip2;
	}
	public String getJoin_addr1() {
		return join_addr1;
	}
	public void setJoin_addr1(String join_addr1) {
		this.join_addr1 = join_addr1;
	}
	public String getJoin_addr2() {
		return join_addr2;
	}
	public void setJoin_addr2(String join_addr2) {
		this.join_addr2 = join_addr2;
	}
	public String getJoin_tel() {
		return join_tel;
	}
	public void setJoin_tel(String join_tel) {
		this.join_tel = join_tel;
	}
	public String getJoin_phone() {
		return join_phone;
	}
	public void setJoin_phone(String join_phone) {
		this.join_phone = join_phone;
	}
	public String getJoin_email() {
		return join_email;
	}
	public void setJoin_email(String join_email) {
		this.join_email = join_email;
	}
	
	//첨부 파일
	public MultipartFile getJoin_profile() {
		return join_profile;
	}

	public void setJoin_profile(MultipartFile join_profile) {
		this.join_profile = join_profile;
	}
	public String getJoin_regdate() {
		return join_regdate;
	}
	public void setJoin_regdate(String join_regdate) {
		this.join_regdate = join_regdate;
	}
	public int getJoin_state() {
		return join_state;
	}
	public void setJoin_state(int join_state) {
		this.join_state = join_state;
	}
	public String getJoin_delcont() {
		return join_delcont;
	}
	public void setJoin_delcont(String join_delcont) {
		this.join_delcont = join_delcont;
	}
	public String getJoin_deldate() {
		return join_deldate;
	}
	public void setJoin_deldate(String join_deldate) {
		this.join_deldate = join_deldate;
	}
	public String getJoin_phone1() {
		return join_phone1;
	}
	public void setJoin_phone1(String join_phone1) {
		this.join_phone1 = join_phone1;
	}
	public String getJoin_phone2() {
		return join_phone2;
	}
	public void setJoin_phone2(String join_phone2) {
		this.join_phone2 = join_phone2;
	}
	public String getJoin_phone3() {
		return join_phone3;
	}
	public void setJoin_phone3(String join_phone3) {
		this.join_phone3 = join_phone3;
	}
	public String getJoin_mailid() {
		return join_mailid;
	}
	public void setJoin_mailid(String join_mailid) {
		this.join_mailid = join_mailid;
	}
	public String getJoin_maildomain() {
		return join_maildomain;
	}
	public void setJoin_maildomain(String join_maildomain) {
		this.join_maildomain = join_maildomain;
	}
	public String getJoin_file() {
		return join_file;
	}
	public void setJoin_file(String join_file) {
		this.join_file = join_file;
	}	
}
