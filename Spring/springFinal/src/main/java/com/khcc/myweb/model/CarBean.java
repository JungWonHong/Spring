package com.khcc.myweb.model;

public class CarBean {

/*	
		CREATE TABLE CAR( 
			   C_ID      VARCHAR2(100) PRIMARY KEY, -- 로그인 사용자 아이디
			   C_IMG      VARCHAR2(100) NOT NULL,   -- 차 이미지 파일 이름
			   C_KIND      VARCHAR2(100) NOT NULL,	-- 차 종류
			   C_MODEL      VARCHAR2(100) NOT NULL, -- 차 모델 이름
			   C_RENTFEE   NUMBER NOT NULL,			-- 차 가격 ex)3500원/30분
			   C_OILFEE   NUMBER NOT NULL,			-- 기름값  ex) 170원/km
			   C_PLACE      VARCHAR2(100) NOT NULL, -- 차의 위치
			   C_START		DATE,					-- 대여 일
			   C_END		DATE,					-- 반납일
			   C_STATE      NUMBER DEFAULT 0 		-- 0이면 반납 가능, 예약 시 1로 update.
			)
*/
	private String c_id;
	private String c_img;
	private String c_kind;
	private String c_model;
	private int c_rentfee;
	private int c_oilfee;
	private String c_place;
	private String c_start;
	private String c_end;
	private int c_state;
	
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_img() {
		return c_img;
	}
	public void setC_img(String c_img) {
		this.c_img = c_img;
	}
	public String getC_kind() {
		return c_kind;
	}
	public void setC_kind(String c_kind) {
		this.c_kind = c_kind;
	}
	public String getC_model() {
		return c_model;
	}
	public void setC_model(String c_model) {
		this.c_model = c_model;
	}
	public int getC_rentfee() {
		return c_rentfee;
	}
	public void setC_rentfee(int c_rentfee) {
		this.c_rentfee = c_rentfee;
	}
	public int getC_oilfee() {
		return c_oilfee;
	}
	public void setC_oilfee(int c_oilfee) {
		this.c_oilfee = c_oilfee;
	}
	public String getC_place() {
		return c_place;
	}
	public void setC_place(String c_place) {
		this.c_place = c_place;
	}
	public String getC_start() {
		return c_start;
	}
	public void setC_start(String c_start) {
		this.c_start = c_start;
	}
	public String getC_end() {
		return c_end;
	}
	public void setC_end(String c_end) {
		this.c_end = c_end;
	}
	public int getC_state() {
		return c_state;
	}
	public void setC_state(int c_state) {
		this.c_state = c_state;
	}
}
