package com.air.lease.domain;

public class ResultMsg {
	
	private String message;
	private int code;
	private Object data;
	private Long total;
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
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public ResultMsg(String message, int code, Object data, Long total) {
		super();
		this.message = message;
		this.code = code;
		this.data = data;
		this.total = total;
	}
	public ResultMsg() {
		
	}

}
