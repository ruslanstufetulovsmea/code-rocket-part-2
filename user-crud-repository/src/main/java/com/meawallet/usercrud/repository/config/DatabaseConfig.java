package com.meawallet.usercrud.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.meawallet")
@EntityScan(basePackages = "com.meawallet")
public class DatabaseConfig {

}
