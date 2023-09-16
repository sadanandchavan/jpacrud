package com.sada.jpacrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan("com.sada.jpacrud.controller")
public class JpacrudApplication {
	
	private static Logger logger   = LoggerFactory.getLogger(JpacrudApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpacrudApplication.class, args);
		
		logger.info("*******************************************");
		logger.info("JpacrudApplication started successfully.");
		logger.info("*******************************************");
	}

}
