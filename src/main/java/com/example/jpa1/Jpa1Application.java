package com.example.jpa1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

@EnableJpaAuditing
@SpringBootApplication
public class Jpa1Application {

    public static void main(String[] args) {
        SpringApplication.run(Jpa1Application.class, args);
    }

}
