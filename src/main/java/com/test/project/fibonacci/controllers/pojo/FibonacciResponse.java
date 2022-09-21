package com.test.project.fibonacci.controllers.pojo;

import java.util.List;

public class FibonacciResponse {

	private int code;
	private String desc;
	private List<Integer> secuence;

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Integer> getSecuence() {
		return secuence;
	}
	public void setSecuence(List<Integer> secuence) {
		this.secuence = secuence;
	}
}
