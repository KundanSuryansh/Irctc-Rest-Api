package com.kundan.railticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration;

@SpringBootApplication
public class RailticketApplication {

    public static void main(String[] args) {
        SpringApplication.run(RailticketApplication.class, args);
    }

}
