package com.test.project.fibonacci.controllers.pojo;


import com.test.project.fibonacci.repository.pojo.SecFibonacci;

public class GenericFibonacciResponse {

	private int code;
	private String desc;
	private SecFibonacci secuence;

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
	public SecFibonacci getSecuence() {
		return secuence;
	}
	public void setSecuence(SecFibonacci secuence) {
		this.secuence = secuence;
	}
}
