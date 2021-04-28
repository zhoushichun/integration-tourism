package com.ifm;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AppRunClient {
    public static void main(String[] args) {
        SpringApplication.run(AppRunClient.class,args);
    }
}
