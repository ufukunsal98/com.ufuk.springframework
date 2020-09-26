package com.ufuk;

import com.ufuk.repository.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author ufukremzi
 */

@SpringBootApplication
@EnableMongoRepositories
@RequiredArgsConstructor
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class , args);
    }
}
