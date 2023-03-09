package ru.demo.debtors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

// -Djavax.net.debug=all
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
