package com.test.project.fibonacci.service;

import java.util.List;

import com.test.project.fibonacci.repository.pojo.SecFibonacci;

public interface FibonacciService {

	List<Integer> create(int value);
	SecFibonacci selectSec(int value);
	boolean deleteSec(int value);
	boolean updateSec(int value);

	default int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n - 2) + fibonacci(n - 1);
	}
}
