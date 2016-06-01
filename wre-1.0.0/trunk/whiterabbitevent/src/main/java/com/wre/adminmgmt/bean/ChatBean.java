package com.wre.adminmgmt.bean;

import java.util.List;

public class ChatBean {
	String name;
	String mobno;
	String reg_id;
	String fromn;
	String from;
	
	String to;
	String msg;
	String fromu;
	List<String> regids;
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
