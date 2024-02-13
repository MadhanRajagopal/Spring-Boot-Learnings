package com.dev;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaultExampleApplication implements CommandLineRunner {

	private final AppConfiguration configuration;

	public VaultExampleApplication(AppConfiguration configuration) {
		this.configuration = configuration;
	}


	public static void main(String[] args) {
		SpringApplication.run(VaultExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Logger logger = LoggerFactory.getLogger(VaultExampleApplication.class);

		logger.info("----------------------------------------");
		logger.info("Configuration properties");
		logger.info("username is {}", configuration.getUsername());
		logger.info("----------------------------------------");
	}
}
