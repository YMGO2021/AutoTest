package com.course;

import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

import javax.annotation.PreDestroy;

@SpringBootApplication
@EnableScheduling
public class Application {
    private  static ConfigurableApplicationContext context;
    public static void main(String[] args) {
        Application.context = SpringApplication.run(Application.class,args);
    }
    /*@PreDestroy修饰的方法会在服务器卸载Servlet的时候运行，并且只会被服务器调用一次，
    类似于Servlet的destroy()方法。被@PreDestroy修饰的方法会在destroy()方法之后运行，在Servlet被彻底卸载之前*/
    @PreDestroy
    public void close(){
        Application.context.close();
    }
}
