package com.clearsettle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

@SpringBootApplication
public class ReportingApiApplication extends AsyncConfigurerSupport {

    public static void main(String[] args) {
        SpringApplication.run(ReportingApiApplication.class, args);
    }

}
