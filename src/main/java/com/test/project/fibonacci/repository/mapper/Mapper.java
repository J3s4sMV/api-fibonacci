package com.test.project.fibonacci.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.project.fibonacci.repository.pojo.SecFibonacci;

public class Mapper implements RowMapper<SecFibonacci> {

	@Override
	public SecFibonacci mapRow(ResultSet rs, int rowNum) throws SQLException {
		try {
			ObjectMapper toObject = new ObjectMapper();
			return toObject.readValue(rs.getString("json"), SecFibonacci.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
