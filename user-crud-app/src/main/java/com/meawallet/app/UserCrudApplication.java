package com.meawallet.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.meawallet")
public class UserCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCrudApplication.class);
    }

}
