package com.webApplication.Todo.helloWorld;

public class helloWorldBean {

	private String msg;

	public helloWorldBean(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "helloWorldBean [msg=" + msg + "]";
	}

}
