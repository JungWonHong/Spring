package com.khcc.myweb.model;

import java.sql.Date;

public class CarpoolBean {
	private int cp_num;
	private String cp_id;
	private String cp_depart;
	private String cp_arrive;
	private String cp_time;
	private Date cp_regdate;
	private int cp_sum;
	private double cp_distance;
	private int cp_valid;

	public int getCp_num() {
		return cp_num;
	}

	public void setCp_num(int cp_num) {
		this.cp_num = cp_num;
	}

	public String getCp_id() {
		return cp_id;
	}

	public void setCp_id(String cp_id) {
		this.cp_id = cp_id;
	}

	public String getCp_depart() {
		return cp_depart;
	}

	public void setCp_depart(String cp_depart) {
		this.cp_depart = cp_depart;
	}

	public String getCp_arrive() {
		return cp_arrive;
	}

	public void setCp_arrive(String cp_arrive) {
		this.cp_arrive = cp_arrive;
	}

	public String getCp_time() {
		return cp_time;
	}

	public void setCp_time(String cp_time) {
		this.cp_time = cp_time;
	}

	public Date getCp_regdate() {
		return cp_regdate;
	}

	public void setCp_regdate(Date cp_regdate) {
		this.cp_regdate = cp_regdate;
	}

	public int getCp_sum() {
		return cp_sum;
	}

	public void setCp_sum(int cp_sum) {
		this.cp_sum = cp_sum;
	}

	public double getCp_distance() {
		return cp_distance;
	}

	public void setCp_distance(double cp_distance) {
		this.cp_distance = cp_distance;
	}

	public int getCp_valid() {
		return cp_valid;
	}

	public void setCp_valid(int cp_valid) {
		this.cp_valid = cp_valid;
	}

}
