package semi.db.bean;

import java.sql.Date;

public class CommentsBean {
	private int		com_no;
	private String	com_id;
	private String	com_content;
	private int		com_re_ref;
	private Date	com_date;
	
	public int getCom_no() {
		return com_no;
	}
	public void setCom_no(int com_no) {
		this.com_no = com_no;
	}
	public String getCom_id() {
		return com_id;
	}
	public void setCom_id(String com_id) {
		this.com_id = com_id;
	}
	public String getCom_content() {
		return com_content;
	}
	public void setCom_content(String com_content) {
		this.com_content = com_content;
	}
	public int getCom_re_ref() {
		return com_re_ref;
	}
	public void setCom_re_ref(int com_re_ref) {
		this.com_re_ref = com_re_ref;
	}
	public Date getCom_date() {
		return com_date;
	}
	public void setCom_date(Date com_date) {
		this.com_date = com_date;
	}
}
