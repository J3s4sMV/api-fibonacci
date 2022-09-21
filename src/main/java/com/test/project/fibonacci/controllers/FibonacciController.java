package com.test.project.fibonacci.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.project.fibonacci.controllers.pojo.FibonacciResponse;
import com.test.project.fibonacci.controllers.pojo.GenericFibonacciResponse;
import com.test.project.fibonacci.controllers.pojo.Sequence;
import com.test.project.fibonacci.service.FibonacciService;

@RestController
@RequestMapping("${base-endpoint}")
public class FibonacciController {
	@Autowired
	private FibonacciService fibonacciService;

	@PostMapping(value = "/sec", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FibonacciResponse> executeFibonacci(@RequestBody Sequence sec) {
		FibonacciResponse response = new FibonacciResponse();
		response.setCode(0);
		response.setDesc("Sequence created successful!");
		response.setSecuence(fibonacciService.create(sec.getValue()));
		return new ResponseEntity<FibonacciResponse>(response, null, HttpStatus.CREATED);
	}

	@GetMapping(value = "/find/{secuence}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericFibonacciResponse> findSecuence(@PathVariable(value = "secuence") int secuence) {
		GenericFibonacciResponse response = new GenericFibonacciResponse();
		response.setSecuence(fibonacciService.selectSec(secuence));
		response.setDesc(response.getSecuence() != null ? "Found!" : "Not Found!");
		response.setCode(response.getSecuence() != null ? 0 : 2);
		return new ResponseEntity<GenericFibonacciResponse>(response, null,
				response.getSecuence() != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/remove/{secuence}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericFibonacciResponse> deleteSecuence(@PathVariable(value = "secuence") int secuence) {
		GenericFibonacciResponse response = new GenericFibonacciResponse();
		boolean res = fibonacciService.deleteSec(secuence);
		response.setDesc(res ? "Sequence deleted successful!" : "Error Deleting Sequence or Not Found!");
		response.setCode(res ? 0 : 3);
		return new ResponseEntity<GenericFibonacciResponse>(response, null, res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PatchMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericFibonacciResponse> updateFibonacci(@RequestBody Sequence sec) {
		GenericFibonacciResponse response = new GenericFibonacciResponse();
		boolean res = fibonacciService.updateSec(sec.getValue());
		response.setDesc(res ? "Sequence updated successful!" : "Error updating Sequence or Not Found!");
		response.setCode(res ? 0 : 1);
		return new ResponseEntity<GenericFibonacciResponse>(response, null, res ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

}
