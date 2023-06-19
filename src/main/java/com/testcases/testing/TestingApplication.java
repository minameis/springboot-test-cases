package com.testcases.testing;

import static org.slf4j.LoggerFactory.*;

import com.testcases.testing.entity.User;
import com.testcases.testing.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestingApplication  implements CommandLineRunner {

	private static final Logger log = getLogger(TestingApplication.class);
	@Autowired
	private UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(TestingApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("Starting  save ");
		// save a couple of users
		repository.save(new User("Jack", "jack@beanstalk.com"));
		repository.save(new User("John", "john@gmail.com"));
	}
}
