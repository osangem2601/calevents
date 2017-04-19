package com.adp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CaleventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaleventsApplication.class, args);
	}
}
