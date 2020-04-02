package com.air.lease.domain;

public class ResultMsg {
	
	private String message;
	private int code;
	private Object data;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResultMsg(String message, int code, Object data) {
		super();
		this.message = message;
		this.code = code;
		this.data = data;
	}
	public ResultMsg() {
		
	}

}
