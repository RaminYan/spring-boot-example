package com.common.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {
	Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Value("${user.role:Hello default}")
	private String message;

	@RequestMapping("/")
	public String index() {
		logger.debug("Greetings from Spring Boot!");
		logger.info("Greetings from Spring Boot!");
		logger.error("Greetings from Spring Boot!");
		return "Hello " + message;
	}
}
