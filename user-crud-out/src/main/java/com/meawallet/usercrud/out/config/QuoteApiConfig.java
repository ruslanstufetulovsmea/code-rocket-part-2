package com.meawallet.usercrud.out.config;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuoteApiConfig {

    @NotBlank
    private String quoteUrl;
}
