package com.test.project.fibonacci.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.project.fibonacci.repository.FibonacciRepository;
import com.test.project.fibonacci.repository.pojo.SecFibonacci;
import com.test.project.fibonacci.service.FibonacciService;

@Service
public class FibonacciServiceImpl implements FibonacciService {
	@Autowired
	private FibonacciRepository fibonacciRepository;

	public List<Integer> create(int value) {
		// valida que no se haya generado una secuencia previa de ser asi devuelve la ya creada.
		SecFibonacci exist = selectSec(value);
		if (exist == null) {
			List<Integer> secuence = new ArrayList<>();
			for (int i = 0; i < value; i++) {
				secuence.add(fibonacci(i));
			}
			fibonacciRepository.insertSec(secuence, value);
			return secuence;
		} else {
			return exist.getSecuence();
		}
	}

	@Override
	public SecFibonacci selectSec(int value) {
		return fibonacciRepository.selectSec(value);
	}

	@Override
	public boolean deleteSec(int value) {
		SecFibonacci exist = selectSec(value);
		return exist!=null?fibonacciRepository.deleteSec(value):false;
	}

	@Override
	public boolean updateSec(int value) {
		SecFibonacci exist = selectSec(value);
		return exist!=null?fibonacciRepository.updateSec(create(value), value):false;
	}
}
