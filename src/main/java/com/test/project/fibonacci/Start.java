package com.test.project.fibonacci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.test.project.fibonacci")
@SpringBootApplication
public class Start {
	
	public static void main(String arg[]) {
		SpringApplication.run(Start.class);
	}

}
