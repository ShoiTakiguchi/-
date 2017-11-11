package model;

import java.util.Calendar;

public class News {

	private int requestid;
	private String userid;
	private Calendar mandate;
	private Calendar decdate;
	private Calendar deldate;
	private boolean mannews = false;
	private boolean decnews = false;
	private boolean delnews = false;
	public int getRequestid() {
		return requestid;
	}
	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Calendar getMandate() {
		return mandate;
	}
	public void setMandate(Calendar mandate) {
		this.mandate = mandate;
	}
	public Calendar getDecdate() {
		return decdate;
	}
	public void setDecdate(Calendar decdate) {
		this.decdate = decdate;
	}
	public Calendar getDeldate() {
		return deldate;
	}
	public void setDeldate(Calendar deldate) {
		this.deldate = deldate;
	}
	public boolean isMannews() {
		return mannews;
	}
	public void setMannews(boolean mannews) {
		this.mannews = mannews;
	}
	public boolean isDecnews() {
		return decnews;
	}
	public void setDecnews(boolean decnews) {
		this.decnews = decnews;
	}
	public boolean isDelnews() {
		return delnews;
	}
	public void setDelnews(boolean delnews) {
		this.delnews = delnews;
	}


}
