package semi.db.bean;

import java.sql.Date;

public class SourceBoardBean {
	private int		sb_no;
	private String	sb_title;
	private	String	sb_id;
	private Date	sb_date;
	private	int		sb_count;
	private String	sb_content;
	private String	sb_file;
	
	public int getSb_no() {
		return sb_no;
	}
	public void setSb_no(int sb_no) {
		this.sb_no = sb_no;
	}
	public String getSb_title() {
		return sb_title;
	}
	public void setSb_title(String sb_title) {
		this.sb_title = sb_title;
	}
	public String getSb_id() {
		return sb_id;
	}
	public void setSb_id(String sb_id) {
		this.sb_id = sb_id;
	}
	public Date getSb_date() {
		return sb_date;
	}
	public void setSb_date(Date sb_date) {
		this.sb_date = sb_date;
	}
	public int getSb_count() {
		return sb_count;
	}
	public void setSb_count(int sb_count) {
		this.sb_count = sb_count;
	}
	public String getSb_content() {
		return sb_content;
	}
	public void setSb_content(String sb_content) {
		this.sb_content = sb_content;
	}
	public String getSb_file() {
		return sb_file;
	}
	public void setSb_file(String sb_file) {
		this.sb_file = sb_file;
	}
}
