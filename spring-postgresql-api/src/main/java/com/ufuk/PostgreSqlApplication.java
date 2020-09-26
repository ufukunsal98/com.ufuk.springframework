package com.ufuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ufukremzi
 */
@SpringBootApplication
@EnableJpaRepositories
public class PostgreSqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(PostgreSqlApplication.class , args);
    }
}
