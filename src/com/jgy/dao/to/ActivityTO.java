package com.jgy.dao.to;

import java.sql.Time;
import java.util.Date;

public class ActivityTO {
	
	private int userid;
	private String name;
	private String type;
	private Time duration;
	private Time averageRhythm;
	private Date cdate;		
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	public Time getAverageRhythm() {
		return averageRhythm;
	}
	public void setAverageRhythm(Time averageRhythm) {
		this.averageRhythm = averageRhythm;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
}