package com.example.springtestingplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootApplication
public class SpringTestingPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestingPlaygroundApplication.class, args);
    }

    @Autowired
    ApplicationEventPublisher eventPublisher;

}
