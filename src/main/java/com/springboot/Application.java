package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class Application {
    public static void main(String arg[]){
        SpringApplication.run(Application.class, arg);
    }
}
