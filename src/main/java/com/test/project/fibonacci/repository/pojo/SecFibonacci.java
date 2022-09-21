package com.test.project.fibonacci.repository.pojo;

import java.io.Serializable;
import java.util.List;

public class SecFibonacci implements Serializable {

	private static final long serialVersionUID = 1L;
	private String create;
	private List<Integer> secuence;

	public SecFibonacci(String create, List<Integer> secuence) {
		this.create = create;
		this.secuence = secuence;
	}

	public SecFibonacci() {
	}

	public String getCreate() {
		return create;
	}

	public void setCreate(String create) {
		this.create = create;
	}

	public List<Integer> getSecuence() {
		return secuence;
	}

	public void setSecuence(List<Integer> secuence) {
		this.secuence = secuence;
	}

}
