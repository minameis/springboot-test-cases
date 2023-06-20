package com.testcases.testing.testcontainers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.testcases.testing.TestingApplication;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.ResourceUtils;

@SpringBootTest(classes = {TestingApplication.class, TestContainerConfig.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestPropertySource(ResourceUtils.CLASSPATH_URL_PREFIX + "application-test.properties")
class TestContainerApplicationTests {


	@Autowired
	private JdbcTemplate jdbc;

	@Test
	@DisplayName("Should get a total count of all users")
	void getTotalUserCount(){
		//When
		int count = jdbc.queryForObject("SELECT COUNT(*) FROM USERS", Integer.class);

		//Then
		assertEquals(4, count);
	}


	@Test
	@DisplayName("Should check first record's name is Jack")
	void  checkNameOfExistingUserBeforeChange(){
		//When
		String name = jdbc.queryForObject("select name from users WHERE id=1", String.class);

		//Then
		assertEquals("Jack", name);
	}

	@Test
	@DisplayName("Should modify existing user's name to newName")
	void modifyExistingUser(){
		//When
		var update = jdbc.update("UPDATE USERS SET name='newName' WHERE id=2");

		//Then
		assertEquals(1, update);
	}


	@Test
	@DisplayName("Should check updated name is newName")
	void verifyNameOfExistingUser(){
		//When
		String name = jdbc.queryForObject("select name from users WHERE id=2", String.class);

		//Then
		assertEquals("newName", name);
	}

}