package com.test.project.fibonacci.repository.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.test.project.fibonacci.repository.FibonacciRepository;
import com.test.project.fibonacci.repository.pojo.SecFibonacci;

@Profile("json")
@Repository
public class FibonacciRepositoryJsonImpl implements FibonacciRepository {

	@Value("${db.h2.repo}")
	private String db;

	public SecFibonacci selectSec(int value) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectMapper toObject = new ObjectMapper();
			byte[] jsonData = Files.readAllBytes(Paths.get(this.db));
			JsonNode rootNode = objectMapper.readTree(jsonData);
			return (rootNode.has(String.valueOf(value)) == true)
					? toObject.readValue(rootNode.get(String.valueOf(value)).asText(), SecFibonacci.class)
					: null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteSec(int value) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			byte[] jsonData = Files.readAllBytes(Paths.get(this.db));
			JsonNode rootNode = objectMapper.readTree(jsonData);
			if (((ObjectNode) rootNode).has(String.valueOf(value))) {
				((ObjectNode) rootNode).remove(String.valueOf(value));
				objectMapper.writeValue(new File(this.db), rootNode);
				return true;
			}
			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertSec(List<Integer> sec, int value) {
		try {
			SecFibonacci secFibonacci = new SecFibonacci();
			secFibonacci.setCreate(LocalDateTime.now().toString());
			secFibonacci.setSecuence(sec);
			ObjectMapper toString = new ObjectMapper();
			ObjectMapper objectMapper = new ObjectMapper();

			byte[] jsonData = Files.readAllBytes(Paths.get(this.db));
			JsonNode rootNode = objectMapper.readTree(jsonData);
			if (rootNode.size() == 0) {
				rootNode = objectMapper.createObjectNode();
			}
			((ObjectNode) rootNode).put(String.valueOf(value), toString.writeValueAsString(secFibonacci));
			objectMapper.writeValue(new File(this.db), rootNode);
			return true;
		} catch (JsonGenerationException | JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
			ObjectMapper objectMapper = new ObjectMapper();

			byte[] jsonData = Files.readAllBytes(Paths.get(this.db));
			JsonNode rootNode = objectMapper.readTree(jsonData);
			if (rootNode.size() == 0) {
				rootNode = objectMapper.createObjectNode();
			}
			((ObjectNode) rootNode).put(String.valueOf(value), toString.writeValueAsString(secFibonacci));
			objectMapper.writeValue(new File(this.db), rootNode);
			return true;
		} catch (JsonGenerationException | JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
