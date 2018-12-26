package semi.db.bean;

import java.sql.Date;

public class ReviewBoardBean {
	private int		rv_no;
	private Date	rv_date;
	private String	rv_title;
	private String	rv_id;
	private int		rv_count;
	private String	rv_content;
	private int		rv_score;
	
	public int getRv_no() {
		return rv_no;
	}
	public void setRv_no(int rv_no) {
		this.rv_no = rv_no;
	}
	public Date getRv_date() {
		return rv_date;
	}
	public void setRv_date(Date rv_date) {
		this.rv_date = rv_date;
	}
	public String getRv_title() {
		return rv_title;
	}
	public void setRv_title(String rv_title) {
		this.rv_title = rv_title;
	}
	public String getRv_id() {
		return rv_id;
	}
	public void setRv_id(String rv_id) {
		this.rv_id = rv_id;
	}
	public int getRv_count() {
		return rv_count;
	}
	public void setRv_count(int rv_count) {
		this.rv_count = rv_count;
	}
	public String getRv_content() {
		return rv_content;
	}
	public void setRv_content(String rv_content) {
		this.rv_content = rv_content;
	}
	public int getRv_score() {
		return rv_score;
	}
	public void setRv_score(int rv_score) {
		this.rv_score = rv_score;
	}
}
