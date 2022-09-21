package com.test.project.fibonacci.repository.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.project.fibonacci.repository.FibonacciRepository;
import com.test.project.fibonacci.repository.pojo.SecFibonacci;
import com.test.project.fibonacci.repository.mapper.Mapper;;

@Profile("h2")
@Repository
public class FibonacciRepositoryH2Impl implements FibonacciRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public SecFibonacci selectSec(int value) {
		List<SecFibonacci> r = jdbcTemplate.query("select json from Binnacle where sequence=" + value, new Mapper());
		return r != null && !r.isEmpty() ? r.get(0) : null;
	}

	public boolean deleteSec(int value) {
		return jdbcTemplate.update("delete from Binnacle where sequence=" + value) > 0 ? true : false;
	}

	public boolean insertSec(List<Integer> sec, int value) {
		try {
			SecFibonacci secFibonacci = new SecFibonacci();
			secFibonacci.setCreate(LocalDateTime.now().toString());
			secFibonacci.setSecuence(sec);
			ObjectMapper toString = new ObjectMapper();
			String query;
			query = "insert into Binnacle(json,sequence) values('" + toString.writeValueAsString(secFibonacci) + "',"
					+ value + ")";
			return jdbcTemplate.update(query) > 0 ? true : false;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public boolean updateSec(List<Integer> sec, int value) {
		try {
			SecFibonacci secFibonacci = new SecFibonacci();
			secFibonacci.setCreate(LocalDateTime.now().toString());
			secFibonacci.setSecuence(sec);
			ObjectMapper toString = new ObjectMapper();
			String json=toString.writeValueAsString(secFibonacci);
			String query;
			query = "update Binnacle set json='".concat(json).concat( "' where sequence= ").concat(String.valueOf(value));
			return jdbcTemplate.update(query) > 0 ? true : false;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
