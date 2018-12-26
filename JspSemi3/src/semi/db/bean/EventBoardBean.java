package semi.db.bean;

import java.sql.Date;

public class EventBoardBean {
	private int		eb_no;
	private Date	eb_date;
	private Date	eb_expire;
	private String	eb_title;
	private String	eb_content;
	
	public int getEb_no() {
		return eb_no;
	}
	public void setEb_no(int eb_no) {
		this.eb_no = eb_no;
	}
	public Date getEb_date() {
		return eb_date;
	}
	public void setEb_date(Date eb_date) {
		this.eb_date = eb_date;
	}
	public Date getEb_expire() {
		return eb_expire;
	}
	public void setEb_expire(Date eb_expire) {
		this.eb_expire = eb_expire;
	}
	public String getEb_title() {
		return eb_title;
	}
	public void setEb_title(String eb_title) {
		this.eb_title = eb_title;
	}
	public String getEb_content() {
		return eb_content;
	}
	public void setEb_content(String eb_content) {
		this.eb_content = eb_content;
	}
}
