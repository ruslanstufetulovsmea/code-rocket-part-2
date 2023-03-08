package com.meawallet.usercrud.in.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record UpdateUserInRequest(
        @NotBlank
        @Pattern(regexp = "[a-zA-Z]+")
        @Length(min = 3, max = 20)
        String name,
        @Positive
        Integer age
) {

}
