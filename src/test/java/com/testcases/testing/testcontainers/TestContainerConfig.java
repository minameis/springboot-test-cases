package com.testcases.testing.testcontainers;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

import org.junit.ClassRule;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * This is using test containers found in pom.xml
 * to launch a docker image of postgres and to initialise
 * the db instance for bound test cases
 *
 */
public class TestContainerConfig {

  // Launch postgres and run init script
    @ClassRule
    private PostgreSQLContainer<?> postgre = new PostgreSQLContainer<>("postgres:9.6.18-alpine")
    .withInitScript("init-db.sql");

    // Configure data source a per config file application-test.properties
    // passed in by TestContainerApplicationTests.java
    @Bean
    public DataSource getDataSource(){
    postgre.start();

     var dataSource = new HikariDataSource();
     dataSource.setJdbcUrl(postgre.getJdbcUrl());
     dataSource.setUsername(postgre.getUsername());
     dataSource.setPassword(postgre.getPassword());
     return dataSource;
    }

}
