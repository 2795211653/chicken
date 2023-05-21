package com.cqm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class ChickenApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChickenApplication.class,args);
    }
}
