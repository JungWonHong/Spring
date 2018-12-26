package semi.db.bean;

import java.sql.Date;

public class EMemberBean {
	private String	e_memname;
	private String	e_id;
	private String	e_pw;
	private String	e_email;
	private String	e_phone;
	private String	e_company;
	private Date	e_regdate;
	public String getE_memname() {
		return e_memname;
	}
	public void setE_memname(String e_memname) {
		this.e_memname = e_memname;
	}
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String e_id) {
		this.e_id = e_id;
	}
	public String getE_pw() {
		return e_pw;
	}
	public void setE_pw(String e_pw) {
		this.e_pw = e_pw;
	}
	public String getE_email() {
		return e_email;
	}
	public void setE_email(String e_email) {
		this.e_email = e_email;
	}
	public String getE_phone() {
		return e_phone;
	}
	public void setE_phone(String e_phone) {
		this.e_phone = e_phone;
	}
	public String getE_company() {
		return e_company;
	}
	public void setE_company(String e_company) {
		this.e_company = e_company;
	}
	public Date getE_regdate() {
		return e_regdate;
	}
	public void setE_regdate(Date e_regdate) {
		this.e_regdate = e_regdate;
	}
}
