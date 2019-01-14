package com.khcc.myweb.model;

/**
 * @author 건욱
 *
 */
public class MemberBean {
	/*
	 * ============= 회원 빈 ================== M_EMAIL VARCHAR2(100) PRIMARY KEY,
	 * M_PASSWORD VARCHAR2(100) NOT NULL, M_NAME VARCHAR2(100) NOT NULL, M_BIRTH
	 * VARCHAR2(100) NOT NULL, M_PHONE1 VARCHAR2(100) NOT NULL, M_PHONE2
	 * VARCHAR2(100) NOT NULL, M_PHONE3 VARCHAR2(100) NOT NULL, M_ZIPCODE
	 * VARCHAR2(100), M_ADDR1 VARCHAR2(100), M_ADDR2 VARCHAR2(100), M_DRIVERCODE
	 * VARCHAR2(100), M_COUPON VARCHAR2(100), M_POINT NUMBER, M_DRIVER NUMBER
	 * DEFAULT 0, M_ACCOUNT VARCHAR2(100)
	 */
	private String m_email;
	private String m_mailid;
	private String m_maildomain;
	private String m_password;
	private String m_name;
	private String m_birth;
	private String m_phone;
	private String m_phone1;
	private String m_phone2;
	private String m_phone3;
	private String m_zipcode;
	private String m_addr1;
	private String m_addr2;
	private String m_drivercode;
	private String m_driver; // 카풀 드라이버 일 경우
	private String m_account;
	private int m_state;
	public int getM_state() {
		return m_state;
	}

	public void setM_state(int m_state) {
		this.m_state = m_state;
	}

	private int m_penalty;

	public int getM_penalty() {
		return m_penalty;
	}

	public void setM_penalty(int m_penalty) {
		this.m_penalty = m_penalty;
	}

	/////////// 카드 정보
	private String owner;
	private String c_name;
	private String c_num;
	private String c_expdate;
	private String c_birth;
	private String c_pass;

	//// 결제 정보
	private String RES_ID;
	private String c_kind;
	private String c_model;
	private String c_place;
	private String startDate;
	private String startTime;
	private String endDate;
	private String  endTime;
	private int tot_price;
	private String settle_day;
	
	public String getRES_ID() {
		return RES_ID;
	}

	public void setRES_ID(String rES_ID) {
		RES_ID = rES_ID;
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

	public String getC_place() {
		return c_place;
	}

	public void setC_place(String c_place) {
		this.c_place = c_place;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getTot_price() {
		return tot_price;
	}

	public void setTot_price(int tot_price) {
		this.tot_price = tot_price;
	}

	public String getSettle_day() {
		return settle_day;
	}

	public void setSettle_day(String settle_day) {
		this.settle_day = settle_day;
	}

	public String getM_mailid() {
		return m_mailid;
	}

	public void setM_mailid(String m_mailid) {
		this.m_mailid = m_mailid;
	}

	public String getM_maildomain() {
		return m_maildomain;
	}

	public void setM_maildomain(String m_maildomain) {
		this.m_maildomain = m_maildomain;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_birth() {
		return m_birth;
	}

	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}

	public String getM_phone1() {
		return m_phone1;
	}

	public void setM_phone1(String m_phone) {
		this.m_phone1 = m_phone;
	}

	public String getM_phone2() {
		return m_phone2;
	}

	public void setM_phone2(String m_phone) {
		this.m_phone2 = m_phone;
	}

	public String getM_phone3() {
		return m_phone3;
	}

	public void setM_phone3(String m_phone) {
		this.m_phone3 = m_phone;
	}

	public String getM_zipcode() {
		return m_zipcode;
	}

	public void setM_zipcode(String m_zipcode) {
		this.m_zipcode = m_zipcode;
	}

	public String getM_addr1() {
		return m_addr1;
	}

	public void setM_addr1(String m_addr1) {
		this.m_addr1 = m_addr1;
	}

	public String getM_addr2() {
		return m_addr2;
	}

	public void setM_addr2(String m_addr2) {
		this.m_addr2 = m_addr2;
	}

	public String getM_drivercode() {
		return m_drivercode;
	}

	public void setM_drivercode(String m_drivercode) {
		this.m_drivercode = m_drivercode;
	}

	public String getM_driver() {
		return m_driver;
	}

	public void setM_driver(String m_driver) {
		this.m_driver = m_driver;
	}

	public String getM_account() {
		return m_account;
	}

	public void setM_account(String m_account) {
		this.m_account = m_account;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
	}

	public String getC_expdate() {
		return c_expdate;
	}

	public void setC_expdate(String c_expdate) {
		this.c_expdate = c_expdate;
	}

	public String getC_birth() {
		return c_birth;
	}

	public void setC_birth(String c_birth) {
		this.c_birth = c_birth;
	}

	public String getC_pass() {
		return c_pass;
	}

	public void setC_pass(String c_pass) {
		this.c_pass = c_pass;
	}
}
