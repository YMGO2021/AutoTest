package com.tester.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tester.spring.server")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
