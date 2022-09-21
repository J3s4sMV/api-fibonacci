package com.test.project.fibonacci.repository;

import java.util.List;

import com.test.project.fibonacci.repository.pojo.SecFibonacci;

public interface FibonacciRepository{

	SecFibonacci selectSec(int value);

	boolean deleteSec(int value);

	boolean insertSec(List<Integer> sec, int value);
	
	boolean updateSec(List<Integer> sec, int value);
}
