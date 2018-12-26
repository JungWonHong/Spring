package semi.db.bean;

import java.sql.Date;

public class PMemberBean {
	private String	p_id;
	private String	p_name;
	private String	p_pw;
	private String	p_hp;
	private String	p_email;
	private Date	p_regdate;
	private int		p_age;
	private int		p_resume;
	private	int		p_certi;
	private String	p_comment;
	private String	p_portpolio;
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_pw() {
		return p_pw;
	}
	public void setP_pw(String p_pw) {
		this.p_pw = p_pw;
	}
	public String getP_hp() {
		return p_hp;
	}
	public void setP_hp(String p_hp) {
		this.p_hp = p_hp;
	}
	public String getP_email() {
		return p_email;
	}
	public void setP_email(String p_email) {
		this.p_email = p_email;
	}
	public Date getP_regdate() {
		return p_regdate;
	}
	public void setP_regdate(Date p_regdate) {
		this.p_regdate = p_regdate;
	}
	public int getP_age() {
		return p_age;
	}
	public void setP_age(int p_age) {
		this.p_age = p_age;
	}
	public int getP_resume() {
		return p_resume;
	}
	public void setP_resume(int p_resume) {
		this.p_resume = p_resume;
	}
	public int getP_certi() {
		return p_certi;
	}
	public void setP_certi(int p_certi) {
		this.p_certi = p_certi;
	}
	public String getP_comment() {
		return p_comment;
	}
	public void setP_comment(String p_comment) {
		this.p_comment = p_comment;
	}
	public String getP_portpolio() {
		return p_portpolio;
	}
	public void setP_portpolio(String p_portpolio) {
		this.p_portpolio = p_portpolio;
	}
}
