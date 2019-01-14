package com.khcc.myweb.model;

/*create table card(
		owner varchar2(100) references member(m_email),
		c_name varchar2() not null,
		c_num varchar2(100) not null,
		c_expdate varchar2(100) not null,
		c_birth number not null,
		c_pass number not null
	)
*/
public class CardBean {

	private String owner;
	private String c_name;
	private String c_num;
	private String c_expdate;
	private String c_birth;
	private String c_pass;
	
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
