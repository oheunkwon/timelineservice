package com.project.spring_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Spring01Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring01Application.class, args);
    }

}
