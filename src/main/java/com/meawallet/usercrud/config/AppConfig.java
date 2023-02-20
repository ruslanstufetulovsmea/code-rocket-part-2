package com.meawallet.usercrud.config;

import com.meawallet.usercrud.ui.MenuAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {

    @Bean("userReadMenuActions")
    public List<MenuAction> userReadMenuActions() {
        return List.of();
    }

    @Bean
    public List<MenuAction> userAdminMenuActions() {
        return List.of();
    }
}
