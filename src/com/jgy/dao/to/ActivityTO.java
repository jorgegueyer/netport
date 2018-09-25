package com.jgy.dao.to;

import java.time.LocalTime;
import java.time.LocalDate;

public class ActivityTO {
	
	private int userid;
	private String name;
	private String type;
	private LocalTime duration;
	private LocalTime averageRhythm;
	private LocalDate cdate;		
	
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
	public LocalTime getDuration() {
		return duration;
	}
	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	public LocalTime getAverageRhythm() {
		return averageRhythm;
	}
	public void setAverageRhythm(LocalTime averageRhythm) {
		this.averageRhythm = averageRhythm;
	}
	public LocalDate getCdate() {
		return cdate;
	}
	public void setCdate(LocalDate cdate) {
		this.cdate = cdate;
	}
}