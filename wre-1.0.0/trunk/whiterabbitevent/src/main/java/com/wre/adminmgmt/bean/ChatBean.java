package com.wre.adminmgmt.bean;

import java.util.List;

public class ChatBean {
	private String name;
	private String mobno;
	private String reg_id;
	private String fromn;
	private String from;
	private String date;
	private String topic;
	private String to;
	private String msg;
	private String fromu;
	private String eventId;
	private List<String> regids;
	
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getFromn() {
		return fromn;
	}
	public void setFromn(String fromn) {
		this.fromn = fromn;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getFromu() {
		return fromu;
	}
	public void setFromu(String fromu) {
		this.fromu = fromu;
	}
	public List<String> getRegids() {
		return regids;
	}
	public void setRegids(List<String> regids) {
		this.regids = regids;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	
}
