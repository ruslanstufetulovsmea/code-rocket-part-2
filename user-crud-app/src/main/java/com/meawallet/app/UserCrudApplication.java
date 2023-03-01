package com.meawallet.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.meawallet",
        exclude = HibernateJpaAutoConfiguration.class)
public class UserCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCrudApplication.class);
    }

}
